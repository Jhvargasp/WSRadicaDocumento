package com.intent.admin.filenetp8;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.filenet.api.core.Document;
import com.filenet.api.core.VersionSeries;
import com.filenet.api.property.Properties;
import com.filenet.api.property.Property;
import com.filenet.apiimpl.collection.StringListImpl;
import com.intent.filenet.cews.WSDLFile.Metadata;

import filenet.vw.api.VWAttachment;
import filenet.vw.api.VWAttachmentType;
import filenet.vw.api.VWException;
import filenet.vw.api.VWFieldType;
import filenet.vw.api.VWLibraryType;
import filenet.vw.api.VWParameter;
import filenet.vw.api.VWSession;
import filenet.vw.api.VWStepElement;

public class PEUtils {

	private final Logger log = Logger.getLogger(getClass());

	public void launchProcess(Document localObject2, VWSession peSession) throws VWException {

		String[] workClassNames = peSession.fetchWorkClassNames(true);
		for (int i = 0; i < workClassNames.length; i++) {
			log.debug(workClassNames[i]);
		}

		String idFlow = "Distribuir correspondencia entrante";
		log.debug("Buscando WDef:" + idFlow);

		String vwVersion = idFlow;
		VWStepElement launchStep = peSession.createWorkflow(vwVersion);

		launchStep.setComment("Lanzado desde WS Custom");
		Property[] ps = localObject2.getProperties().toArray();
		for (Property property : ps) {
			if (launchStep.hasParameterName(property.getPropertyName())) {
				VWParameter param = launchStep.getParameter(property.getPropertyName());
				Object value = property.getObjectValue();
				log.debug(property.getPropertyName() + ":" + value);

				if (value instanceof StringListImpl) {
					String[] args = new String[((StringListImpl) value).size()];
					for (int i = 0; i < args.length; i++) {
						args[i] = ((StringListImpl) value).get(i).toString();
					}
					value = args;
				}
				log.debug(property.getPropertyName() + ":" + value);
				if (value != null) {
					launchStep.setParameterValue(property.getPropertyName(), value, false);
				}

			} else {
				log.debug("Parametro no existe!:" + property.getPropertyName());
			}
		}
		// correspondencia
		launchStep.setParameterValue("Correspondencia", getAttachment(localObject2), false);

		launchStep.doDispatch();
		log.debug("process launched");

	}

	ResourceBundle BUNDLE = ResourceBundle.getBundle("WcmApiConfig");

	private VWAttachment getAttachment(Document document) throws VWException {
		VWAttachment attachment = new VWAttachment();
		attachment.setType(VWAttachmentType.ATTACHMENT_TYPE_DOCUMENT);
		attachment.setLibraryType(VWLibraryType.LIBRARY_TYPE_CONTENT_ENGINE);
		attachment.setLibraryName(BUNDLE.getString("objectStore"));

		attachment.setAttachmentName(document.getProperties().getStringValue("DocumentTitle"));

		VersionSeries vs = document.get_VersionSeries();
		attachment.setId(vs.get_Id().toString());
		attachment.setVersion(((com.filenet.api.core.Document) document.get_ReleasedVersion()).get_Id().toString());

		return attachment;
	}

}
