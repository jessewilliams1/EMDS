package discrepancies;

public class UpdateDiscProxy implements discrepancies.UpdateDisc {
  private String _endpoint = null;
  private discrepancies.UpdateDisc updateDisc = null;
  
  public UpdateDiscProxy() {
    _initUpdateDiscProxy();
  }
  
  public UpdateDiscProxy(String endpoint) {
    _endpoint = endpoint;
    _initUpdateDiscProxy();
  }
  
  private void _initUpdateDiscProxy() {
    try {
      updateDisc = (new discrepancies.UpdateDiscServiceLocator()).getUpdateDiscPort();
      if (updateDisc != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)updateDisc)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)updateDisc)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (updateDisc != null)
      ((javax.xml.rpc.Stub)updateDisc)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public discrepancies.UpdateDisc getUpdateDisc() {
    if (updateDisc == null)
      _initUpdateDiscProxy();
    return updateDisc;
  }
  
  public java.lang.String[] updateDisc(java.lang.String[] arg0) throws java.rmi.RemoteException, discrepancies.Exception{
    if (updateDisc == null)
      _initUpdateDiscProxy();
    return updateDisc.updateDisc(arg0);
  }
  
  
}