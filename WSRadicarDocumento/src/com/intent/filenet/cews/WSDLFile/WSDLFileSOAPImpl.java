/**
 * WSDLFileSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.intent.filenet.cews.WSDLFile;

import com.minas.filenet.cews.service.Util;

public class WSDLFileSOAPImpl implements com.intent.filenet.cews.WSDLFile.WSDLFile_PortType {
	public com.intent.filenet.cews.WSDLFile.InsertDocRs insertDocument(
			com.intent.filenet.cews.WSDLFile.InsertDocRq parameters) throws java.rmi.RemoteException {
		return new Util().executeInsert(parameters);
	}

	public com.intent.filenet.cews.WSDLFile.SearchDocRs searchDocument(com.intent.filenet.cews.WSDLFile.SearchDocRq parameters) throws java.rmi.RemoteException {
		return new Util().executeSearch(parameters);
    }

}
