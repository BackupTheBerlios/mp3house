package Books;
/**
 * <ul>
 * <li><b>IDL Source </b> "../idl/Books.idl"
 * <li><b>IDL Name </b> ::Books::BookManager
 * <li><b>Repository Id </b> IDL:Books/BookManager:1.0
 * </ul>
 * <b>IDL definition: </b>
 * 
 * <pre>
 * 
 *  interface BookManager {
 *  ...
 *  };
 *  
 * </pre>
 */
public class _BookManagerStub
		extends
			com.inprise.vbroker.CORBA.portable.ObjectImpl
		implements
			Books.BookManager {
	final public static java.lang.Class _opsClass = Books.BookManagerOperations.class;
	public java.lang.String[] _ids() {
		return __ids;
	}
	private static java.lang.String[] __ids = {"IDL:Books/BookManager:1.0"};
	/**
	 * <pre>
	 * 
	 *    Books.Book getBook (in long id);
	 *  
	 * </pre>
	 */
	public Books.Book getBook(int id) {
		while (true) {
			if (!_is_local()) {
				org.omg.CORBA.portable.OutputStream _output = null;
				org.omg.CORBA.portable.InputStream _input = null;
				Books.Book _result;
				try {
					_output = this._request("getBook", true);
					_output.write_long((int) id);
					_input = this._invoke(_output);
					_result = Books.BookHelper.read(_input);
					return _result;
				} catch (org.omg.CORBA.portable.ApplicationException _exception) {
					java.lang.String _exception_id = _exception.getId();
					throw new org.omg.CORBA.UNKNOWN(
							"Unexpected User Exception: " + _exception_id);
				} catch (org.omg.CORBA.NO_RESPONSE _vis_nm) {
					if (_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
						return null;
					}
					throw _vis_nm;
				} catch (org.omg.CORBA.portable.RemarshalException _exception) {
					continue;
				} finally {
					this._releaseReply(_input);
				}
			} else {
				Books.BookManagerOperations _self = null;
				final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"getBook", _opsClass);
				if (_so == null) {
					continue;
				}
				try {
					_self = (Books.BookManagerOperations) _so.servant;
				} catch (java.lang.ClassCastException _vis_ce) {
					org.omg.CORBA.portable.OutputStream _output = null;
					org.omg.CORBA.portable.InputStream _input = null;
					Books.Book _result;
					try {
						_output = _orb().create_output_stream();
						final org.omg.CORBA.portable.OutputStream _response_output = _orb()
								.create_output_stream();
						final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb()
								.create_output_stream();
						com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler
								.getResponseHandler(_response_output,
										_response_ex_output);
						_output.write_long((int) id);
						org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler) _so.servant)
								._invoke("getBook", _output
										.create_input_stream(), _vis_vbr));
						_input = _result_output.create_input_stream();
						_result = Books.BookHelper.read(_input);
						if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
							((org.omg.CORBA.portable.ServantObjectExt) _so)
									.normalCompletion();
						}
						return _result;
					} catch (java.lang.RuntimeException _vis_re) {
						if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
							((org.omg.CORBA.portable.ServantObjectExt) _so)
									.exceptionalCompletion((Throwable) _vis_re);
						}
						throw _vis_re;
					} catch (java.lang.Error _vis_err) {
						if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
							((org.omg.CORBA.portable.ServantObjectExt) _so)
									.exceptionalCompletion((Throwable) _vis_err);
						}
						throw _vis_err;
					} finally {
						_servant_postinvoke(_so);
						this._releaseReply(_input);
					}
				}
				try {
					Books.Book _ret = _self.getBook(id);
					if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
						((org.omg.CORBA.portable.ServantObjectExt) _so)
								.normalCompletion();
					}
					return _ret;
				} catch (java.lang.RuntimeException _vis_re) {
					if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
						((org.omg.CORBA.portable.ServantObjectExt) _so)
								.exceptionalCompletion((Throwable) _vis_re);
					}
					throw _vis_re;
				} catch (java.lang.Error _vis_err) {
					if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
						((org.omg.CORBA.portable.ServantObjectExt) _so)
								.exceptionalCompletion((Throwable) _vis_err);
					}
					throw _vis_err;
				} finally {
					_servant_postinvoke(_so);
				}
			}
		}
	}
}