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
public interface BookManagerOperations {
  /**
   * <pre>
   *   Books.Book getBook (in long id);
   * </pre>
   */
  public Books.Book getBook (int id);

}
