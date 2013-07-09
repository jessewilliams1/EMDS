package discrepancies;

public class ViewDiscProxy implements discrepancies.ViewDisc {
  private String _endpoint = null;
  private discrepancies.ViewDisc viewDisc = null;
  
  public ViewDiscProxy() {
    _initViewDiscProxy();
  }
  
  public ViewDiscProxy(String endpoint) {
    _endpoint = endpoint;
    _initViewDiscProxy();
  }
  
  private void _initViewDiscProxy() {
    try {
      viewDisc = (new discrepancies.ViewDiscServiceLocator()).getViewDiscPort();
      if (viewDisc != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)viewDisc)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)viewDisc)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (viewDisc != null)
      ((javax.xml.rpc.Stub)viewDisc)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public discrepancies.ViewDisc getViewDisc() {
    if (viewDisc == null)
      _initViewDiscProxy();
    return viewDisc;
  }
  
  public java.lang.String[] viewDisc(java.lang.String[] arg0) throws java.rmi.RemoteException, discrepancies.Exception{
    if (viewDisc == null)
      _initViewDiscProxy();
    return viewDisc.viewDisc(arg0);
  }
  
  
}