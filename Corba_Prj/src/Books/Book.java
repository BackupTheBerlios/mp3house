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
public interface Book extends com.inprise.vbroker.CORBA.Object, Books.BookOperations, org.omg.CORBA.portable.IDLEntity {
}
