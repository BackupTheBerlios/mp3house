package Books;
/**
 * <ul>
 * <li><b>IDL Source </b> "../idl/Books.idl"
 * <li><b>IDL Name </b> ::Books::Book
 * <li><b>Repository Id </b> IDL:Books/Book:1.0
 * </ul>
 * <b>IDL definition: </b>
 * 
 * <pre>
 * 
 *  interface Book {
 *  ...
 *  };
 *  
 * </pre>
 */
public abstract class BookPOA extends org.omg.PortableServer.Servant
		implements
			org.omg.CORBA.portable.InvokeHandler,
			Books.BookOperations {
	public Books.Book _this() {
		return Books.BookHelper.narrow(super._this_object());
	}
	public Books.Book _this(org.omg.CORBA.ORB orb) {
		return Books.BookHelper.narrow(super._this_object(orb));
	}
	public java.lang.String[] _all_interfaces(
			final org.omg.PortableServer.POA poa, final byte[] objectId) {
		return __ids;
	}
	private static java.lang.String[] __ids = {"IDL:Books/Book:1.0"};
	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
		_methods.put("getID", new int[]{0, 0});
		_methods.put("getTitle", new int[]{0, 1});
		_methods.put("getISBN", new int[]{0, 2});
		_methods.put("getCost", new int[]{0, 3});
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
					return Books.BookPOA._invoke(this, method[1], _input,
							handler);
				}
		}
		throw new org.omg.CORBA.BAD_OPERATION();
	}
	public static org.omg.CORBA.portable.OutputStream _invoke(
			Books.BookOperations _self, int _method_id,
			org.omg.CORBA.portable.InputStream _input,
			org.omg.CORBA.portable.ResponseHandler _handler) {
		org.omg.CORBA.portable.OutputStream _output = null;
		{
			switch (_method_id) {
				case 0 :
					{
						int _result = _self.getID();
						_output = _handler.createReply();
						_output.write_long((int) _result);
						return _output;
					}
				case 1 :
					{
						java.lang.String _result = _self.getTitle();
						_output = _handler.createReply();
						_output.write_string((java.lang.String) _result);
						return _output;
					}
				case 2 :
					{
						java.lang.String _result = _self.getISBN();
						_output = _handler.createReply();
						_output.write_string((java.lang.String) _result);
						return _output;
					}
				case 3 :
					{
						float _result = _self.getCost();
						_output = _handler.createReply();
						_output.write_float((float) _result);
						return _output;
					}
			}
			throw new org.omg.CORBA.BAD_OPERATION();
		}
	}
}