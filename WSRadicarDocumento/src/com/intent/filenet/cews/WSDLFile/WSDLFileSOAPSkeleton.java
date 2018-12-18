/**
 * WSDLFileSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.intent.filenet.cews.WSDLFile;

public class WSDLFileSOAPSkeleton implements com.intent.filenet.cews.WSDLFile.WSDLFile_PortType, org.apache.axis.wsdl.Skeleton {
    private com.intent.filenet.cews.WSDLFile.WSDLFile_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "InsertDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", ">InsertDocRq"), com.intent.filenet.cews.WSDLFile.InsertDocRq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertDocument", _params, new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "InsertDocRs"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", ">InsertDocRs"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "insertDocument"));
        _oper.setSoapAction("http://cews.filenet.intent.com/WSDLFile/Operation1");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertDocument") == null) {
            _myOperations.put("insertDocument", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertDocument")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "SearchDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", ">SearchDocRq"), com.intent.filenet.cews.WSDLFile.SearchDocRq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchDocument", _params, new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "SearchDocRs"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", ">SearchDocRs"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "searchDocument"));
        _oper.setSoapAction("http://cews.filenet.intent.com/WSDLFile/Operation2");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchDocument") == null) {
            _myOperations.put("searchDocument", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchDocument")).add(_oper);
    }

    public WSDLFileSOAPSkeleton() {
        this.impl = new com.intent.filenet.cews.WSDLFile.WSDLFileSOAPImpl();
    }

    public WSDLFileSOAPSkeleton(com.intent.filenet.cews.WSDLFile.WSDLFile_PortType impl) {
        this.impl = impl;
    }
    public com.intent.filenet.cews.WSDLFile.InsertDocRs insertDocument(com.intent.filenet.cews.WSDLFile.InsertDocRq parameters) throws java.rmi.RemoteException
    {
        com.intent.filenet.cews.WSDLFile.InsertDocRs ret = impl.insertDocument(parameters);
        return ret;
    }

    public com.intent.filenet.cews.WSDLFile.SearchDocRs searchDocument(com.intent.filenet.cews.WSDLFile.SearchDocRq parameters) throws java.rmi.RemoteException
    {
        com.intent.filenet.cews.WSDLFile.SearchDocRs ret = impl.searchDocument(parameters);
        return ret;
    }

}
