import Books.BookPOA;

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
public class BookImpl extends Books.BookPOA{
	
	private int id;
	private String title, isbn;
	private float cost;
	
	public BookImpl(int id, 
			String title, 
			String isbn, 
			float cost){
		
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.cost = cost;
	}
	
	public BookImpl(int id){
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see Books.BookOperations#getID()
	 */
	public int getID() {
		return id;
	}

	/* (non-Javadoc)
	 * @see Books.BookOperations#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see Books.BookOperations#getISBN()
	 */
	public String getISBN() {
		return isbn;
	}

	/* (non-Javadoc)
	 * @see Books.BookOperations#getCost()
	 */
	public float getCost() {
		return cost;
	}
}
