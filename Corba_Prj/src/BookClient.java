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
public class BookClient {

	  public static void main(String[] args) {
	    // Initialize the ORB.
	    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
	    
	    // Get the manager Id
	    byte[] managerId = "BookManager".getBytes();
	    
	    // Locate an account manager. Give the full POA name and the servant ID.
	    Books.BookManager manager = 
		Books.BookManagerHelper.bind(orb, "/book_agent_poa", managerId);
	    
	    // Request the account manager to open a named account.
	    Books.Book account = manager.getBook(11);
	    
	    // Print out the balance.
	    System.out.println
	      ("The book " + account.getTitle() + " costs $" + account.getCost());
	  }
}
