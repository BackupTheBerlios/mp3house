
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
public class BookPOATie extends BookPOA {
  private Books.BookOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public BookPOATie (final Books.BookOperations _delegate) {
    this._delegate = _delegate;
  }

  public BookPOATie (final Books.BookOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public Books.BookOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final Books.BookOperations the_delegate) {
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
   *   long getID ();
   * </pre>
   */
  public int getID () {
    return this._delegate.getID();
  }

  /**
   * <pre>
   *   string getTitle ();
   * </pre>
   */
  public java.lang.String getTitle () {
    return this._delegate.getTitle();
  }

  /**
   * <pre>
   *   string getISBN ();
   * </pre>
   */
  public java.lang.String getISBN () {
    return this._delegate.getISBN();
  }

  /**
   * <pre>
   *   float getCost ();
   * </pre>
   */
  public float getCost () {
    return this._delegate.getCost();
  }

}
