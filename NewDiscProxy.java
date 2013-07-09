package discrepancies;

public class NewDiscProxy implements discrepancies.NewDisc {
  private String _endpoint = null;
  private discrepancies.NewDisc newDisc = null;
  
  public NewDiscProxy() {
    _initNewDiscProxy();
  }
  
  public NewDiscProxy(String endpoint) {
    _endpoint = endpoint;
    _initNewDiscProxy();
  }
  
  private void _initNewDiscProxy() {
    try {
      newDisc = (new discrepancies.NewDiscServiceLocator()).getNewDiscPort();
      if (newDisc != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)newDisc)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)newDisc)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (newDisc != null)
      ((javax.xml.rpc.Stub)newDisc)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public discrepancies.NewDisc getNewDisc() {
    if (newDisc == null)
      _initNewDiscProxy();
    return newDisc;
  }
  
  public java.lang.String[] newDisc(java.lang.String[] arg0) throws java.rmi.RemoteException, discrepancies.Exception{
    if (newDisc == null)
      _initNewDiscProxy();
    return newDisc.newDisc(arg0);
  }
  
  
}