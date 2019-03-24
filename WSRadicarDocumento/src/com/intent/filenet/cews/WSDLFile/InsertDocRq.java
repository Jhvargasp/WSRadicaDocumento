/**
 * InsertDocRq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.intent.filenet.cews.WSDLFile;

public class InsertDocRq  implements java.io.Serializable {
    private java.lang.String objectStore;

    private java.lang.String docClass;

    private java.lang.String path;

    private com.intent.filenet.cews.WSDLFile.Metadata[] properties;

    private com.intent.filenet.cews.WSDLFile.ContentData[] contents;

    private com.intent.filenet.cews.WSDLFile.ContentData[] attachments;

    public InsertDocRq() {
    }

    public InsertDocRq(
           java.lang.String objectStore,
           java.lang.String docClass,
           java.lang.String path,
           com.intent.filenet.cews.WSDLFile.Metadata[] properties,
           com.intent.filenet.cews.WSDLFile.ContentData[] contents,
           com.intent.filenet.cews.WSDLFile.ContentData[] attachments) {
           this.objectStore = objectStore;
           this.docClass = docClass;
           this.path = path;
           this.properties = properties;
           this.contents = contents;
           this.attachments = attachments;
    }


    /**
     * Gets the objectStore value for this InsertDocRq.
     * 
     * @return objectStore
     */
    public java.lang.String getObjectStore() {
        return objectStore;
    }


    /**
     * Sets the objectStore value for this InsertDocRq.
     * 
     * @param objectStore
     */
    public void setObjectStore(java.lang.String objectStore) {
        this.objectStore = objectStore;
    }


    /**
     * Gets the docClass value for this InsertDocRq.
     * 
     * @return docClass
     */
    public java.lang.String getDocClass() {
        return docClass;
    }


    /**
     * Sets the docClass value for this InsertDocRq.
     * 
     * @param docClass
     */
    public void setDocClass(java.lang.String docClass) {
        this.docClass = docClass;
    }


    /**
     * Gets the path value for this InsertDocRq.
     * 
     * @return path
     */
    public java.lang.String getPath() {
        return path;
    }


    /**
     * Sets the path value for this InsertDocRq.
     * 
     * @param path
     */
    public void setPath(java.lang.String path) {
        this.path = path;
    }


    /**
     * Gets the properties value for this InsertDocRq.
     * 
     * @return properties
     */
    public com.intent.filenet.cews.WSDLFile.Metadata[] getProperties() {
        return properties;
    }


    /**
     * Sets the properties value for this InsertDocRq.
     * 
     * @param properties
     */
    public void setProperties(com.intent.filenet.cews.WSDLFile.Metadata[] properties) {
        this.properties = properties;
    }


    /**
     * Gets the contents value for this InsertDocRq.
     * 
     * @return contents
     */
    public com.intent.filenet.cews.WSDLFile.ContentData[] getContents() {
        return contents;
    }


    /**
     * Sets the contents value for this InsertDocRq.
     * 
     * @param contents
     */
    public void setContents(com.intent.filenet.cews.WSDLFile.ContentData[] contents) {
        this.contents = contents;
    }


    /**
     * Gets the attachments value for this InsertDocRq.
     * 
     * @return attachments
     */
    public com.intent.filenet.cews.WSDLFile.ContentData[] getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this InsertDocRq.
     * 
     * @param attachments
     */
    public void setAttachments(com.intent.filenet.cews.WSDLFile.ContentData[] attachments) {
        this.attachments = attachments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsertDocRq)) return false;
        InsertDocRq other = (InsertDocRq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectStore==null && other.getObjectStore()==null) || 
             (this.objectStore!=null &&
              this.objectStore.equals(other.getObjectStore()))) &&
            ((this.docClass==null && other.getDocClass()==null) || 
             (this.docClass!=null &&
              this.docClass.equals(other.getDocClass()))) &&
            ((this.path==null && other.getPath()==null) || 
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            ((this.properties==null && other.getProperties()==null) || 
             (this.properties!=null &&
              java.util.Arrays.equals(this.properties, other.getProperties()))) &&
            ((this.contents==null && other.getContents()==null) || 
             (this.contents!=null &&
              java.util.Arrays.equals(this.contents, other.getContents()))) &&
            ((this.attachments==null && other.getAttachments()==null) || 
             (this.attachments!=null &&
              java.util.Arrays.equals(this.attachments, other.getAttachments())));
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
        if (getObjectStore() != null) {
            _hashCode += getObjectStore().hashCode();
        }
        if (getDocClass() != null) {
            _hashCode += getDocClass().hashCode();
        }
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        if (getProperties() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProperties());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProperties(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAttachments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachments(), i);
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
        new org.apache.axis.description.TypeDesc(InsertDocRq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", ">InsertDocRq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectStore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ObjectStore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DocClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("properties");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Properties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "Metadata"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Metadata"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Contents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "ContentData"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Data"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Attachments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.intent.com/WSDLFile/", "ContentData"));
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
