package Books;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "../idl/Books.idl"
 * <li> <b>IDL Name</b>      ::Books::Book
 * <li> <b>Repository Id</b> IDL:Books/Book:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface Book {
  ...
};
 * </pre>
 */
public class _BookStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements Books.Book {
  final public static java.lang.Class _opsClass = Books.BookOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:Books/Book:1.0"
  };

  /**
   * <pre>
   *   long getID ();
   * </pre>
   */
  public int getID () {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      int _result;
      try {
        _output = this._request("getID", true);
        _input = this._invoke(_output);
        _result = _input.read_long();
        return _result;
      }
      catch (org.omg.CORBA.portable.ApplicationException _exception) {
        java.lang.String _exception_id = _exception.getId();
        throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
      }
      catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
       if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
        return 0;

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
    Books.BookOperations _self = null;
    final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getID", _opsClass);
    if (_so == null) {
    continue;
    }
    try {
    _self = (Books.BookOperations)_so.servant;
    }catch (java.lang.ClassCastException _vis_ce) {
    org.omg.CORBA.portable.OutputStream _output = null;
    org.omg.CORBA.portable.InputStream  _input  = null;
    int _result;
    try {
    _output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb().create_output_stream();
    com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler.getResponseHandler(_response_output,_response_ex_output);
    org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler)_so.servant)._invoke("getID",_output.create_input_stream(),_vis_vbr));
    _input = _result_output.create_input_stream();

    _result = _input.read_long();
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
    int _ret = _self.getID();
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

  /**
   * <pre>
   *   string getTitle ();
   * </pre>
   */
  public java.lang.String getTitle () {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      java.lang.String _result;
      try {
        _output = this._request("getTitle", true);
        _input = this._invoke(_output);
        _result = _input.read_string();
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
    Books.BookOperations _self = null;
    final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getTitle", _opsClass);
    if (_so == null) {
    continue;
    }
    try {
    _self = (Books.BookOperations)_so.servant;
    }catch (java.lang.ClassCastException _vis_ce) {
    org.omg.CORBA.portable.OutputStream _output = null;
    org.omg.CORBA.portable.InputStream  _input  = null;
    java.lang.String _result;
    try {
    _output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb().create_output_stream();
    com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler.getResponseHandler(_response_output,_response_ex_output);
    org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler)_so.servant)._invoke("getTitle",_output.create_input_stream(),_vis_vbr));
    _input = _result_output.create_input_stream();

    _result = _input.read_string();
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
    java.lang.String _ret = _self.getTitle();
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

  /**
   * <pre>
   *   string getISBN ();
   * </pre>
   */
  public java.lang.String getISBN () {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      java.lang.String _result;
      try {
        _output = this._request("getISBN", true);
        _input = this._invoke(_output);
        _result = _input.read_string();
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
    Books.BookOperations _self = null;
    final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getISBN", _opsClass);
    if (_so == null) {
    continue;
    }
    try {
    _self = (Books.BookOperations)_so.servant;
    }catch (java.lang.ClassCastException _vis_ce) {
    org.omg.CORBA.portable.OutputStream _output = null;
    org.omg.CORBA.portable.InputStream  _input  = null;
    java.lang.String _result;
    try {
    _output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb().create_output_stream();
    com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler.getResponseHandler(_response_output,_response_ex_output);
    org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler)_so.servant)._invoke("getISBN",_output.create_input_stream(),_vis_vbr));
    _input = _result_output.create_input_stream();

    _result = _input.read_string();
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
    java.lang.String _ret = _self.getISBN();
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

  /**
   * <pre>
   *   float getCost ();
   * </pre>
   */
  public float getCost () {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      float _result;
      try {
        _output = this._request("getCost", true);
        _input = this._invoke(_output);
        _result = _input.read_float();
        return _result;
      }
      catch (org.omg.CORBA.portable.ApplicationException _exception) {
        java.lang.String _exception_id = _exception.getId();
        throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
      }
      catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
       if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return 0.0F;

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
    Books.BookOperations _self = null;
    final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCost", _opsClass);
    if (_so == null) {
    continue;
    }
    try {
    _self = (Books.BookOperations)_so.servant;
    }catch (java.lang.ClassCastException _vis_ce) {
    org.omg.CORBA.portable.OutputStream _output = null;
    org.omg.CORBA.portable.InputStream  _input  = null;
    float _result;
    try {
    _output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb().create_output_stream();
    com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler.getResponseHandler(_response_output,_response_ex_output);
    org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler)_so.servant)._invoke("getCost",_output.create_input_stream(),_vis_vbr));
    _input = _result_output.create_input_stream();

    _result = _input.read_float();
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
    float _ret = _self.getCost();
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
