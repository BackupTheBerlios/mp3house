package Bank;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "../idl/Bank.idl"
 * <li> <b>IDL Name</b>      ::Bank::AccountManager
 * <li> <b>Repository Id</b> IDL:Bank/AccountManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface AccountManager {
  ...
};
 * </pre>
 */
public class _AccountManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements Bank.AccountManager {
  final public static java.lang.Class _opsClass = Bank.AccountManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:Bank/AccountManager:1.0"
  };

  /**
   * <pre>
   *   Bank.Account open (in string name);
   * </pre>
   */
  public Bank.Account open (java.lang.String name) {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      Bank.Account _result;
      try {
        _output = this._request("open", true);
        _output.write_string((java.lang.String)name);
        _input = this._invoke(_output);
        _result = Bank.AccountHelper.read(_input);
        return _result;
      }
      catch (org.omg.CORBA.portable.ApplicationException _exception) {
        java.lang.String _exception_id = _exception.getId();
        throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
      }
      catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
       if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
              return null;

    }
    throw _vis_nm;
    }
    catch (org.omg.CORBA.portable.RemarshalException _exception) {
    continue;
    }
    finally {
    this._releaseReply(_input);
    }
    } else {
    Bank.AccountManagerOperations _self = null;
    final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("open", _opsClass);
    if (_so == null) {
    continue;
    }
    try {
    _self = (Bank.AccountManagerOperations)_so.servant;
    }catch (java.lang.ClassCastException _vis_ce) {
    org.omg.CORBA.portable.OutputStream _output = null;
    org.omg.CORBA.portable.InputStream  _input  = null;
    Bank.Account _result;
    try {
    _output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb().create_output_stream();
    com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler.getResponseHandler(_response_output,_response_ex_output);
    _output.write_string((java.lang.String)name);
    org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler)_so.servant)._invoke("open",_output.create_input_stream(),_vis_vbr));
    _input = _result_output.create_input_stream();

    _result = Bank.AccountHelper.read(_input);
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
    }
    return _result;
    } catch (java.lang.RuntimeException _vis_re) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_re);
    }
    throw _vis_re;
    } catch (java.lang.Error _vis_err) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_err);
    }
    throw _vis_err;
    }finally {
    _servant_postinvoke(_so);
    this._releaseReply(_input);
    }
    }
    try {
    Bank.Account _ret = _self.open(name);
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
    }
    return _ret;
    } catch (java.lang.RuntimeException _vis_re) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_re);
    }
    throw _vis_re;
    } catch (java.lang.Error _vis_err) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_err);
    }
    throw _vis_err;
    } finally {
    _servant_postinvoke(_so);
    }

    }
    }
  }

}
