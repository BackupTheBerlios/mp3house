
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
public class BookManagerPOATie extends BookManagerPOA {
  private Books.BookManagerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public BookManagerPOATie (final Books.BookManagerOperations _delegate) {
    this._delegate = _delegate;
  }

  public BookManagerPOATie (final Books.BookManagerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public Books.BookManagerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final Books.BookManagerOperations the_delegate) {
    this._delegate = the_delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

  /**
   * <pre>
   *   Books.Book getBook (in long id);
   * </pre>
   */
  public Books.Book getBook (int id) {
    return this._delegate.getBook(id);
  }

}
