/**
 * Documents.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.intent.filenet.cews.WSDLFile;

public class Documents  implements java.io.Serializable {
    private com.intent.filenet.cews.WSDLFile.Metadata[][] document;

    private com.intent.filenet.cews.WSDLFile.ContentData[] replyContent;

    public Documents() {
    }

    public Documents(
           com.intent.filenet.cews.WSDLFile.Metadata[][] document,
           com.intent.filenet.cews.WSDLFile.ContentData[] replyContent) {
           this.document = document;
           this.replyContent = replyContent;
    }


    /**
     * Gets the document value for this Documents.
     * 
     * @return document
     */
    public com.intent.filenet.cews.WSDLFile.Metadata[][] getDocument() {
        return document;
    }


    /**
     * Sets the document value for this Documents.
     * 
     * @param document
     */
    public void setDocument(com.intent.filenet.cews.WSDLFile.Metadata[][] document) {
        this.document = document;
    }

    public com.intent.filenet.cews.WSDLFile.Metadata[] getDocument(int i) {
        return this.document[i];
    }

    public void setDocument(int i, com.intent.filenet.cews.WSDLFile.Metadata[] _value) {
        this.document[i] = _value;
    }


    /**
     * Gets the replyContent value for this Documents.
     * 
     * @return replyContent
     */
    public com.intent.filenet.cews.WSDLFile.ContentData[] getReplyContent() {
        return replyContent;
    }


    /**
     * Sets the replyContent value for this Documents.
     * 
     * @param replyContent
     */
    public void setReplyContent(com.intent.filenet.cews.WSDLFile.ContentData[] replyContent) {
        this.replyContent = replyContent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Documents)) return false;
        Documents other = (Documents) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.document==null && other.getDocument()==null) || 
             (this.document!=null &&
              java.util.Arrays.equals(this.document, other.getDocument()))) &&
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
        if (getDocument() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocument());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocument(), i);
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
        new org.apache.axis.description.TypeDesc(Documents.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "Documents"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Document"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "Document"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
