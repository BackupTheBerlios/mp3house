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
public abstract class BookManagerPOA extends org.omg.PortableServer.Servant
		implements
			org.omg.CORBA.portable.InvokeHandler,
			Books.BookManagerOperations {
	public Books.BookManager _this() {
		return Books.BookManagerHelper.narrow(super._this_object());
	}
	public Books.BookManager _this(org.omg.CORBA.ORB orb) {
		return Books.BookManagerHelper.narrow(super._this_object(orb));
	}
	public java.lang.String[] _all_interfaces(
			final org.omg.PortableServer.POA poa, final byte[] objectId) {
		return __ids;
	}
	private static java.lang.String[] __ids = {"IDL:Books/BookManager:1.0"};
	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
		_methods.put("getBook", new int[]{0, 0});
	}
	public org.omg.CORBA.portable.OutputStream _invoke(java.lang.String opName,
			org.omg.CORBA.portable.InputStream _input,
			org.omg.CORBA.portable.ResponseHandler handler) {
		int[] method = (int[]) _methods.get(opName);
		if (method == null) {
			throw new org.omg.CORBA.BAD_OPERATION();
		}
		switch (method[0]) {
			case 0 :
				{
					return Books.BookManagerPOA._invoke(this, method[1],
							_input, handler);
				}
		}
		throw new org.omg.CORBA.BAD_OPERATION();
	}
	public static org.omg.CORBA.portable.OutputStream _invoke(
			Books.BookManagerOperations _self, int _method_id,
			org.omg.CORBA.portable.InputStream _input,
			org.omg.CORBA.portable.ResponseHandler _handler) {
		org.omg.CORBA.portable.OutputStream _output = null;
		{
			switch (_method_id) {
				case 0 :
					{
						int id;
						id = _input.read_long();
						Books.Book _result = _self.getBook(id);
						_output = _handler.createReply();
						Books.BookHelper.write(_output, _result);
						return _output;
					}
			}
			throw new org.omg.CORBA.BAD_OPERATION();
		}
	}
}