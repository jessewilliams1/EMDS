/**
 * ViewDiscServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package discrepancies;

public class ViewDiscServiceLocator extends org.apache.axis.client.Service implements discrepancies.ViewDiscService {

    public ViewDiscServiceLocator() {
    }


    public ViewDiscServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ViewDiscServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ViewDiscPort
    private java.lang.String ViewDiscPort_address = "http://localhost:7001/maintenance/ViewDiscService";

    public java.lang.String getViewDiscPortAddress() {
        return ViewDiscPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ViewDiscPortWSDDServiceName = "ViewDiscPort";

    public java.lang.String getViewDiscPortWSDDServiceName() {
        return ViewDiscPortWSDDServiceName;
    }

    public void setViewDiscPortWSDDServiceName(java.lang.String name) {
        ViewDiscPortWSDDServiceName = name;
    }

    public discrepancies.ViewDisc getViewDiscPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ViewDiscPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getViewDiscPort(endpoint);
    }

    public discrepancies.ViewDisc getViewDiscPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            discrepancies.ViewDiscPortBindingStub _stub = new discrepancies.ViewDiscPortBindingStub(portAddress, this);
            _stub.setPortName(getViewDiscPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setViewDiscPortEndpointAddress(java.lang.String address) {
        ViewDiscPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (discrepancies.ViewDisc.class.isAssignableFrom(serviceEndpointInterface)) {
                discrepancies.ViewDiscPortBindingStub _stub = new discrepancies.ViewDiscPortBindingStub(new java.net.URL(ViewDiscPort_address), this);
                _stub.setPortName(getViewDiscPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ViewDiscPort".equals(inputPortName)) {
            return getViewDiscPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://discrepancies/", "ViewDiscService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://discrepancies/", "ViewDiscPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ViewDiscPort".equals(portName)) {
            setViewDiscPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
