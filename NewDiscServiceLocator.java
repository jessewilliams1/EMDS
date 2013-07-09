/**
 * NewDiscServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package discrepancies;

public class NewDiscServiceLocator extends org.apache.axis.client.Service implements discrepancies.NewDiscService {

    public NewDiscServiceLocator() {
    }


    public NewDiscServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NewDiscServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NewDiscPort
    private java.lang.String NewDiscPort_address = "http://localhost:7001/maintenance/NewDiscService";

    public java.lang.String getNewDiscPortAddress() {
        return NewDiscPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NewDiscPortWSDDServiceName = "NewDiscPort";

    public java.lang.String getNewDiscPortWSDDServiceName() {
        return NewDiscPortWSDDServiceName;
    }

    public void setNewDiscPortWSDDServiceName(java.lang.String name) {
        NewDiscPortWSDDServiceName = name;
    }

    public discrepancies.NewDisc getNewDiscPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NewDiscPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNewDiscPort(endpoint);
    }

    public discrepancies.NewDisc getNewDiscPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            discrepancies.NewDiscPortBindingStub _stub = new discrepancies.NewDiscPortBindingStub(portAddress, this);
            _stub.setPortName(getNewDiscPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNewDiscPortEndpointAddress(java.lang.String address) {
        NewDiscPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (discrepancies.NewDisc.class.isAssignableFrom(serviceEndpointInterface)) {
                discrepancies.NewDiscPortBindingStub _stub = new discrepancies.NewDiscPortBindingStub(new java.net.URL(NewDiscPort_address), this);
                _stub.setPortName(getNewDiscPortWSDDServiceName());
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
        if ("NewDiscPort".equals(inputPortName)) {
            return getNewDiscPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://discrepancies/", "NewDiscService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://discrepancies/", "NewDiscPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NewDiscPort".equals(portName)) {
            setNewDiscPortEndpointAddress(address);
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
