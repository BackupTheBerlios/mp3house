package Books;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "../idl/Books.idl"
 * <li> <b>IDL Name</b>      ::Books::BookManager
 * <li> <b>Repository Id</b> IDL:Books/BookManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface BookManager {
  ...
};
 * </pre>
 */
public final class BookManagerHolder implements org.omg.CORBA.portable.Streamable {
public Books.BookManager value;

public BookManagerHolder () {
}

public BookManagerHolder (final Books.BookManager _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = Books.BookManagerHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  Books.BookManagerHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return Books.BookManagerHelper.type();
}
}
