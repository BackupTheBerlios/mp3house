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
public final class BookHolder implements org.omg.CORBA.portable.Streamable {
public Books.Book value;

public BookHolder () {
}

public BookHolder (final Books.Book _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = Books.BookHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  Books.BookHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return Books.BookHelper.type();
}
}
