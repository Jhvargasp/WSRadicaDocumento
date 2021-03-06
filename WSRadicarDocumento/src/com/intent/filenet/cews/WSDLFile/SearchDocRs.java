/**
 * SearchDocRs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.intent.filenet.cews.WSDLFile;

public class SearchDocRs  implements java.io.Serializable {
    private java.lang.String operationStatCd;

    private java.lang.String errStatDesc;

    private com.intent.filenet.cews.WSDLFile.Metadata[][] documents;

    private com.intent.filenet.cews.WSDLFile.ContentData[] replyContent;

    public SearchDocRs() {
    }

    public SearchDocRs(
           java.lang.String operationStatCd,
           java.lang.String errStatDesc,
           com.intent.filenet.cews.WSDLFile.Metadata[][] documents,
           com.intent.filenet.cews.WSDLFile.ContentData[] replyContent) {
           this.operationStatCd = operationStatCd;
           this.errStatDesc = errStatDesc;
           this.documents = documents;
           this.replyContent = replyContent;
    }


    /**
     * Gets the operationStatCd value for this SearchDocRs.
     * 
     * @return operationStatCd
     */
    public java.lang.String getOperationStatCd() {
        return operationStatCd;
    }


    /**
     * Sets the operationStatCd value for this SearchDocRs.
     * 
     * @param operationStatCd
     */
    public void setOperationStatCd(java.lang.String operationStatCd) {
        this.operationStatCd = operationStatCd;
    }


    /**
     * Gets the errStatDesc value for this SearchDocRs.
     * 
     * @return errStatDesc
     */
    public java.lang.String getErrStatDesc() {
        return errStatDesc;
    }


    /**
     * Sets the errStatDesc value for this SearchDocRs.
     * 
     * @param errStatDesc
     */
    public void setErrStatDesc(java.lang.String errStatDesc) {
        this.errStatDesc = errStatDesc;
    }


    /**
     * Gets the documents value for this SearchDocRs.
     * 
     * @return documents
     */
    public com.intent.filenet.cews.WSDLFile.Metadata[][] getDocuments() {
        return documents;
    }


    /**
     * Sets the documents value for this SearchDocRs.
     * 
     * @param documents
     */
    public void setDocuments(com.intent.filenet.cews.WSDLFile.Metadata[][] documents) {
        this.documents = documents;
    }


    /**
     * Gets the replyContent value for this SearchDocRs.
     * 
     * @return replyContent
     */
    public com.intent.filenet.cews.WSDLFile.ContentData[] getReplyContent() {
        return replyContent;
    }


    /**
     * Sets the replyContent value for this SearchDocRs.
     * 
     * @param replyContent
     */
    public void setReplyContent(com.intent.filenet.cews.WSDLFile.ContentData[] replyContent) {
        this.replyContent = replyContent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchDocRs)) return false;
        SearchDocRs other = (SearchDocRs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operationStatCd==null && other.getOperationStatCd()==null) || 
             (this.operationStatCd!=null &&
              this.operationStatCd.equals(other.getOperationStatCd()))) &&
            ((this.errStatDesc==null && other.getErrStatDesc()==null) || 
             (this.errStatDesc!=null &&
              this.errStatDesc.equals(other.getErrStatDesc()))) &&
            ((this.documents==null && other.getDocuments()==null) || 
             (this.documents!=null &&
              java.util.Arrays.equals(this.documents, other.getDocuments()))) &&
            ((this.replyContent==null && other.getReplyContent()==null) || 
             (this.replyContent!=null &&
              java.util.Arrays.equals(this.replyContent, other.getReplyContent())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getOperationStatCd() != null) {
            _hashCode += getOperationStatCd().hashCode();
        }
        if (getErrStatDesc() != null) {
            _hashCode += getErrStatDesc().hashCode();
        }
        if (getDocuments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocuments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocuments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReplyContent() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReplyContent());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReplyContent(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchDocRs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", ">SearchDocRs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationStatCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OperationStatCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errStatDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ErrStatDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Documents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "Document"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Document"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replyContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReplyContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "ContentData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Data"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
