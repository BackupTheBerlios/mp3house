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
public interface BookOperations {
  /**
   * <pre>
   *   long getID ();
   * </pre>
   */
  public int getID ();

  /**
   * <pre>
   *   string getTitle ();
   * </pre>
   */
  public java.lang.String getTitle ();

  /**
   * <pre>
   *   string getISBN ();
   * </pre>
   */
  public java.lang.String getISBN ();

  /**
   * <pre>
   *   float getCost ();
   * </pre>
   */
  public float getCost ();

}
