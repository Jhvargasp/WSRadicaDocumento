package com.minas.filenet.cews.service;

import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.TypeID;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Factory.Folder;
import com.filenet.api.util.Id;
import com.filenet.wcm.api.BadReferenceException;
import com.filenet.wcm.api.BaseRuntimeException;
import com.filenet.wcm.api.Document;
import com.filenet.wcm.api.InvalidContentEngineClassException;
import com.filenet.wcm.api.InvalidCredentialsException;
import com.filenet.wcm.api.ReadOnlyObjectException;
import com.filenet.wcm.api.RemoteServerException;
import com.filenet.wcm.api.TransportInputStream;
import com.filenet.wcm.api.UniquenessConstraintException;
import com.intent.admin.filenetp8.PEUtils;
import com.intent.admin.filenetp8.UtilFilenetP8;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import com.minas.filenet.cews.service.*;
import com.intent.filenet.cews.WSDLFile.*;
import com.intent.logic.LabelGenerator;

public class Util {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("WcmApiConfig");
	private final Logger log = Logger.getLogger(getClass());
	private String validation_msg = "";

	public final SearchDocRs executeSearch(SearchDocRq paramSearchDocRq) {
		this.log.debug("Start query");
		SearchDocRs localSearchDocRs = new SearchDocRs();
		try {
			this.log.debug("Validate User");
			String str1 = BUNDLE.getString("USERCONTENT");
			if (!validateParameter(str1)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter User can't be empty ");
				return localSearchDocRs;
			}
			this.log.debug("Validate Password");
			String localObject1 = BUNDLE.getString("PASSWORDCONTENT");

			if (!validateParameter((String) localObject1)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Password can't be empty ");
				return localSearchDocRs;
			}
			this.log.debug("Validate ObjectStore");
			String str2 = BUNDLE.getString("objectStore");
			if (!validateParameter(str2)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter ObjectStore can't be empty ");
				return localSearchDocRs;
			}
			this.log.debug("Validate DocClass");
			String str3 = "ComunicacionEntrante";
			if (!validateParameter(str3)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter DocClass can't be empty ");
				return localSearchDocRs;
			}
			String str4 = "";

			this.log.debug("Validate QueryCondition");
			String str5 = ("Radicado ='" + paramSearchDocRq.getRadicado() + "'");
			if (!validateParameter(str5)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter QueryCondition can't be empty ");
				return localSearchDocRs;
			}
			if (str5.trim().length() == 0) {
				str5 = "Id = Id ";
			}
			this.log.debug("Params");
			this.log.debug(str1 + "--" + str2 + "--" + str3 + "--" + str4 + "--" + str5);
			UtilFilenetP8 localUtilFilenetP8 = new UtilFilenetP8(str1, (String) localObject1, str2);
			UtilFilenetP8.setFormatDate(BUNDLE.getString("DATEFORMAT"));
			UtilFilenetP8.setPatternDate(BUNDLE.getString("DATEPATTERN"));
			UtilFilenetP8.setTimeZone(BUNDLE.getString("TIMEZONE"));
			localUtilFilenetP8.setMultivalueSplit(BUNDLE.getString("SPLITCHARACTER"));
			HashMap localHashMap1 = localUtilFilenetP8.getPropertyDefinitionsByClass(str3);
			List localList1 = getDateProperties(localHashMap1);
			String str6 = "";
			if ((str4 != null) && (str4.trim().length() > 0)) {
				str6 = "  " + str3 + ".This INFOLDER '" + str4 + "' AND ";
			}
			String str7 = "SELECT " + fixParams(localHashMap1) + " FROM ";
			str7 = str7 + str3 + " WHERE " + "VersionStatus" + "= 1 " + " AND " + str6 + parseCharacters(str5);
			String where = "VersionStatus" + "= 1 " + " AND " + str6 + parseCharacters(str5);
			this.log.debug("Query : " + str7);
			List localList2 = localUtilFilenetP8.query(fixParams(localHashMap1), str3, where);
			this.log.debug("Results : ".concat(String.valueOf(localList2.size())));
			String[] arrayOfString = fixParams(localHashMap1).split(",");
			List<Metadata> arrayOfMetadata = new ArrayList<Metadata>();

			// mx.com.metlife.filenet.cews.WSDLFile.Document[] arrayOfMetadata = new
			// mx.com.metlife.filenet.cews.WSDLFile.Document[localList2.size()];
			int i = localList2.size();
			Metadata[][] arrayOfDocuments = new Metadata[i][];
			for (int j = 0; j < i; j++) {
				HashMap localHashMap2 = (HashMap) localList2.get(j);
				Metadata[] arrayOfMetadata1 = new Metadata[arrayOfString.length];
				// mx.com.metlife.filenet.cews.wsdlfile.Document document=new
				// mx.com.metlife.filenet.cews.wsdlfile.Document();

				for (int k = 0; k < arrayOfString.length; k++) {
					Metadata localMetadata = new Metadata();
					Object localObject2 = localHashMap2.get(arrayOfString[k]);
					if (localList1.contains(arrayOfString[k])) {
						try {
							localObject2 = UtilFilenetP8.getFormatDate().format((Date) localObject2);
						} catch (Exception localException2) {
						}
					}
					if (arrayOfString[k].equals("Id")) {
						localMetadata.setKey("GUID");
					} else {
						localMetadata.setKey(arrayOfString[k]);
					}
					if (localHashMap2.get(arrayOfString[k]) != null) {
						localMetadata.setValue(localObject2.toString());
					} else {
						localMetadata.setValue("".toString());
					}
					arrayOfMetadata1[k] = localMetadata;
					// document.getMetadata().add(localMetadata);
				}

				arrayOfDocuments[j] = arrayOfMetadata1;
				// arrayOfMetadata[j]=new mx.com.metlife.filenet.cews.WSDLFile.Document();
				// arrayOfMetadata[j].setDocuments( arrayOfMetadata1);
			}
			localSearchDocRs.setDocuments(arrayOfDocuments);
			localSearchDocRs.setErrStatDesc("");
			localSearchDocRs.setOperationStatCd("000");
			if (localList2.size() == 0) {
				localSearchDocRs.setErrStatDesc("CONTENTENGINE_FILE_NOT_FOUND The query did not match any documents.");
				localSearchDocRs.setOperationStatCd("005");
			}
		} catch (Exception localException1) {
			Object localObject1 = evaluateException(localException1);
			localSearchDocRs.setOperationStatCd(((ResponseError) localObject1).getErrCd());
			localSearchDocRs.setErrStatDesc(((ResponseError) localObject1).getErrStat());
			// localSearchDocRs.setDocuments(new Metadata[0][]);
		}
		return localSearchDocRs;
	}

	private String fixParams(HashMap paramHashMap) {
		String str1 = "";
		Iterator localIterator = paramHashMap.keySet().iterator();
		while (localIterator.hasNext()) {
			String str2 = (String) localIterator.next();
			HashMap localHashMap = (HashMap) paramHashMap.get(str2);
			if (((localHashMap.get("Cardinality")) == Cardinality.SINGLE)
					&& (!"SourceDocument".equals(localHashMap.get("SymbolicName").toString()))) {
				str1 = str1 + localHashMap.get("SymbolicName").toString().concat(",");
			}
		}
		str1 = str1 + "Id,";
		str1 = str1 + "DateCreated,";
		str1 = str1 + "DateLastModified,";
		str1 = str1 + "LastModifier";
		this.log.debug("PARAM " + str1);
		return str1;
	}

	private List getDateProperties(HashMap paramHashMap) {
		ArrayList localArrayList = new ArrayList();
		Iterator localIterator = paramHashMap.keySet().iterator();
		while (localIterator.hasNext()) {
			String str = (String) localIterator.next();
			HashMap localHashMap = (HashMap) paramHashMap.get(str);
			if (localHashMap.get("DataType") == TypeID.DATE) {
				localArrayList.add(localHashMap.get("SymbolicName").toString());
			}
		}
		localArrayList.add("DateCreated");
		localArrayList.add("DateLastModified");
		return localArrayList;
	}

	public final InsertDocRs executeInsert(InsertDocRq paramInsertDocRq) {
		this.log.debug("Start insert: ");
		InsertDocRs localInsertDocRs = new InsertDocRs();
		try {
			ResourceBundle localResourceBundle = BUNDLE;
			this.log.debug("Validate USERCONTENT");
			if (!validateParameter(localResourceBundle.getString("USERCONTENT"))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter User can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate PASSWORDCONTENT");
			// if
			// (!validateParameter(this.blowfish.(localResourceBundle.getString("PASSWORDCONTENT"))))
			// {
			if (!validateParameter((localResourceBundle.getString("PASSWORDCONTENT")))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Password can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate ObjectStore");
			if (!validateParameter((paramInsertDocRq.getObjectStore()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter ObjectStore can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Path");
			if (!validateParameter((paramInsertDocRq.getPath()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Path can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate DocClass");
			String docClass = (paramInsertDocRq.getDocClass());
			if (!validateParameter(docClass)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter DocClass can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Content");
			this.log.debug("Validate Filenm");
			String fName = (paramInsertDocRq.getContents()[0].getFilenm());
			String tmpdir = System.getProperty("java.io.tmpdir");
			fName = tmpdir + java.io.File.separator + fName;
			if (!validateParameter(fName)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Filenm can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Properties");
			log.debug(paramInsertDocRq.getProperties());
			if ((paramInsertDocRq.getProperties() == null) || (paramInsertDocRq.getProperties().length == 0)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Properties can't be null or empty ");
				return localInsertDocRs;
			}
			// Base64 localBase64 = new Base64();
			log.debug("Creating Utilfilenet");

			UtilFilenetP8 localObject1 = new UtilFilenetP8(localResourceBundle.getString("USERCONTENT"),
					// this.blowfish.(localResourceBundle.getString("PASSWORDCONTENT")),
					((localResourceBundle.getString("PASSWORDCONTENT"))), (paramInsertDocRq.getObjectStore()));
			log.debug("Done Utilfilenet");
			UtilFilenetP8.setFormatDate(BUNDLE.getString("DATEFORMAT"));
			UtilFilenetP8.setPatternDate(BUNDLE.getString("DATEPATTERN"));
			UtilFilenetP8.setTimeZone(BUNDLE.getString("TIMEZONE"));
			localObject1.setMultivalueSplit(BUNDLE.getString("SPLITCHARACTER"));
			
			if (writeFile(paramInsertDocRq.getContents())) {
				ArrayList localArrayList1 = new ArrayList();
				ArrayList localArrayList2 = new ArrayList();
				String paramRad = null;
				int i = 0;
				for (int j = 0; j < paramInsertDocRq.getProperties().length; j++) {
					Metadata localObject2 = paramInsertDocRq.getProperties()[j];
					if (localObject2 == null) {
						localInsertDocRs.setOperationStatCd("010");
						localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Metadata Tag must have parameters");
						return localInsertDocRs;
					}
					String localObject3 = (((Metadata) localObject2).getKey());
					String str2 = (((Metadata) localObject2).getValue());

					if ((str2 != null) && (localObject3 != null) && (((String) localObject3).length() > 0)
							&& (fName != null)) {
						if ((str2 != null) && (str2.length() == 0)
								&& (((String) localObject3).equals("DocumentTitle"))) {
							str2 = fName;
						}
						localArrayList1.add(localObject3);
						localArrayList2.add(str2);
						if (((String) localObject3).equals("DocumentTitle")) {
							i = 1;
						}
						if (localObject3.equals("Radicado")) {
							paramRad = str2;
						}
					} else {
						localInsertDocRs.setOperationStatCd("010");
						if ((localObject3 != null) && (((String) localObject3).equals("DocumentTitle"))) {
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter " + (String) localObject3
									+ "/" + str2 + " Key/Value can't be null ");
						} else {
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter " + (String) localObject3
									+ "/" + str2 + " Key/Value can't be null or empty ");
						}
						return localInsertDocRs;
					}
				}

				String rad =paramRad;
				if (paramRad != null && paramRad.length() == 0) {
					localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Radicado is invalid");
					localInsertDocRs.setOperationStatCd("010");
					return localInsertDocRs;
				}else if(paramRad != null && paramRad.length()>0) {
					rad =paramRad;
				}
				else {
					localArrayList1.add("Radicado");
					rad = createRadicado();
					localArrayList2.add(rad);
				}
				/*
				 * if (i == 0) { localArrayList1.add("DocumentTitle");
				 * localArrayList2.add(fName); }
				 */
				localObject1.setUniquenessConstraint(false);

				com.filenet.api.core.Document localObject2 = localObject1.createDocumentAndContent(
						(paramInsertDocRq.getPath()), docClass,
						(String[]) localArrayList1.toArray(new String[localArrayList1.size()]),
						localArrayList2.toArray(), paramInsertDocRq.getContents());

				// launch pe instance
				for (int j = 0; j < paramInsertDocRq.getContents().length; j++) {
					ContentData contentData = paramInsertDocRq.getContents()[j];
					
					fName = (contentData.getFilenm());
					tmpdir = System.getProperty("java.io.tmpdir");
					fName = tmpdir + java.io.File.separator + fName;
					
					this.log.debug("Document on CE created: " + fName);
					new java.io.File(fName).delete();
					this.log.debug("Temp Document deleted: " + fName);
					
				}
				
				Id idValue = localObject2.getProperties().getIdValue("Id");
				this.log.debug("ID Document created: " + idValue);
				// localInsertDocRs.setGUID(localBase64.encode(localObject2.getProperties().getIdValue("Id").toString().getBytes()));
				localInsertDocRs.setGUID((rad));
				localInsertDocRs.setOperationStatCd("000");

				new PEUtils().launchProcess(localObject2, localObject1.getVWSession());

			}
		} catch (Exception localException1) {
			localException1.printStackTrace();
			Object localObject1 = evaluateException(localException1);
			localInsertDocRs.setOperationStatCd(((ResponseError) localObject1).getErrCd());
			localInsertDocRs.setErrStatDesc(((ResponseError) localObject1).getErrStat());
		}
		return localInsertDocRs;
	}

	private boolean writeFile(ContentData[] contents) throws Exception {
		for (int i = 0; i < contents.length; i++) {
			ContentData contentData = contents[i];
			String fName = (contentData.getFilenm());
			String tmpdir = System.getProperty("java.io.tmpdir");
			fName = tmpdir + java.io.File.separator + fName;
			if(!writeFile(contentData.getContent(), fName)) {
				log.debug("Error generating content: "+fName);
				return false;
			}else {
				log.debug("Generated content: "+fName);
			}
		}
		return true;
	}

	private String getLevel(String paramString) {
		String str = paramString;
		if ("ViewProperties".equals(str)) {
			str = "VIEW";
		}
		if ("ViewContent".equals(str)) {
			str = "READ";
		}
		if ("ModifyProperties".equals(str)) {
			str = "WRITE_DEFAULT";
		}
		return str;
	}

	private String createRadicado() {
		String template = "";
		String autoNum = "";

		String tipoDoc = "OFICIO";
		if (tipoDoc.equalsIgnoreCase("OFICIO") || tipoDoc.equalsIgnoreCase("MEMORANDO")) {
			template = "TEMPLATE1";
			autoNum = "correspondencia";
		} else {
			template = "TEMPLATEINTC";
			autoNum = "circular";
		}

		String params[] = new String[] {};

		log.debug("template" + template);

		String ticket = "NA";
		try {
			ticket = new LabelGenerator().GenerateLabel(template, params, autoNum);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ticket;

	}

	private String parseCharacters(String paramString) {
		paramString = paramString.replaceAll("\\&", "&amp;");
		paramString = paramString.replaceAll("<", "&lt;");
		paramString = paramString.replaceAll(">", "&gt;");
		return paramString;
	}

	private boolean writeFile(byte[] paramArrayOfByte, String paramString) throws Exception {
		java.io.File localFile = new java.io.File(paramString);
		localFile.createNewFile();
		FileOutputStream localFileOutputStream = new FileOutputStream(localFile, false);
		for (int i = 0; i < paramArrayOfByte.length; i++) {
			localFileOutputStream.write(paramArrayOfByte[i]);
		}
		localFileOutputStream.close();
		return true;
	}

	private boolean validateParameter(String paramString) {
		return (paramString != null) && (paramString.length() > 0);
	}

	private ResponseError evaluateException(Object paramObject) {
		ResponseError localResponseError = new ResponseError();
		if (paramObject == null) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL Null ");
		} else if (((Exception) paramObject).getMessage() == null) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL Null ");
		} else if ((paramObject instanceof InvalidContentEngineClassException)) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof ReadOnlyObjectException)) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof InvalidCredentialsException)) {
			localResponseError.setErrCd("020");
			localResponseError.setErrStat("INVALID_CREDENTIALS " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof RemoteServerException)) {
			if (((Exception) paramObject).getMessage().startsWith("ContentRetrieval")) {
				localResponseError.setErrCd("005");
				localResponseError.setErrStat("CONTENTENGINE_FILE_NOT_FOUND The query did not match any documents.");
			} else if ((((Exception) paramObject).getMessage().startsWith("Missing or invalid Property"))
					|| (((Exception) paramObject).getMessage().startsWith("Create failed"))) {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
			} else {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL_CE " + ((Exception) paramObject).getMessage());
			}
		} else if ((paramObject instanceof BadReferenceException)) {
			if (((Exception) paramObject).getMessage().startsWith("ContentRetrieval: ObjectStore not found")) {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL_CE " + ((Exception) paramObject).getMessage());
			} else if (((Exception) paramObject).getMessage().startsWith("ContentRetrieval")) {
				localResponseError.setErrCd("005");
				localResponseError.setErrStat("CONTENTENGINE_FILE_NOT_FOUND The query did not match any documents.");
			} else {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL_CE " + ((Exception) paramObject).getMessage());
			}
		} else if ((paramObject instanceof UniquenessConstraintException)) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("UNIQUENESSCONSTRAINT " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof BaseRuntimeException)) {
			localResponseError.setErrCd("020");
			localResponseError.setErrStat("ERROR_CONNECTION " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof Exception)) {
			if (((Exception) paramObject).getMessage().startsWith("PARAMETER_EXCEPTION")) {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat(((Exception) paramObject).getMessage());
			} else {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
			}
		}
		return localResponseError;
	}
	/*
	 * private boolean getDocumentExists(String paramString1, String paramString2,
	 * MetaDataList paramMetaDataList, UtilFilenetP8 paramUtilFilenetP8) throws
	 * Exception { this.log.debug("Initializing properties validations..."); if
	 * (paramMetaDataList.isAnyRequred()) { boolean bool = false;
	 * Iterator<com.filenet.api.core.Document> it =
	 * paramUtilFilenetP8.getDocumentsInFolder(paramString1); int i = 0; while
	 * (it.hasNext()) { this.log.debug("Checking document #" + i); i++;
	 * com.filenet.api.core.Document localDocument = (com.filenet.api.core.Document)
	 * it.next(); localDocument.refresh(); localDocument.get_Id();
	 * this.log.debug("Checking required properties for document #" + i); for (int j
	 * = 0; j < paramMetaDataList.size(); j++) { MetaData localMetaData = (MetaData)
	 * paramMetaDataList.get(j); if (localMetaData.isRequired()) { try { if
	 * (localMetaData.getValue().indexOf(';') > -1) { String[] values =
	 * localMetaData.getValue().split(";"); for (int k = 0; k < values.length; k++)
	 * { String string = values[k]; if
	 * (localDocument.getProperties().getStringListValue(localMetaData.getKey())
	 * .contains(string)) { bool = true; this.validation_msg = (this.validation_msg
	 * + " [" + localMetaData.getKey() + "]"); } else { bool = false;
	 * this.validation_msg = ""; break; } } } else if
	 * (localMetaData.getValue().toString().equals(
	 * localDocument.getProperties().getStringValue(localMetaData.getKey()).toString
	 * ())) { bool = true; this.validation_msg = (this.validation_msg + " [" +
	 * localMetaData.getKey() + "]"); } else { bool = false; this.validation_msg =
	 * ""; break; } } catch (Exception localException) { bool = false;
	 * this.validation_msg = ""; break; } } } if (bool) { return bool; } } }
	 * this.log.
	 * debug("No need to check for properties because all input properties are Required=False"
	 * ); return false; }
	 */
}
