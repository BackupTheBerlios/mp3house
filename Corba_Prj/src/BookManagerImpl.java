import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Logger;
import Books.Book;
import Books.BookManagerPOA;
import com.vj.util.ConnectionPool;
/*
 * Created on Jun 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class BookManagerImpl extends BookManagerPOA {
	private static final Logger log = Logger.getLogger("BookManagerImpl");
	/* (non-Javadoc)
	 * @see Books.BookManagerOperations#getBook(int)
	 */
	public Book getBook(int id) {
		log.warning("reached");
		Book book = null;
		BookImpl bookimpl = null;
		ConnectionPool CP = ConnectionPool.getInstance();
		Connection con = CP.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books where id="
					+ id);
			rs.next();
			bookimpl = new BookImpl(rs.getInt("id"), rs.getString("title"), rs
					.getString("isbn"), rs.getFloat("cost"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			// Activate it on the default POA which is root POA for this servant
			book = Books.BookHelper.narrow(_default_POA()
					.servant_to_reference(bookimpl));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		log.warning("before return");
		return book;
	}
}