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
import org.omg.PortableServer.*;

public class BookServer {
	  public static void main(String[] args) {
	    try {
	      // Initialize the ORB.
	      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
	      
	      // get a reference to the root POA
	      POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

	      // Create policies for our persistent POA
	      org.omg.CORBA.Policy[] policies = { 
	        rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT) 
	      };
	      
	      // Create myPOA with the right policies
	      POA myPOA = rootPOA.create_POA( "book_agent_poa", rootPOA.the_POAManager(), 
	                                        policies );
	      // Create the servant
	      BookManagerImpl managerServant = new BookManagerImpl();
	      
	      // Decide on the ID for the servant
	      byte[] managerId = "BookManager".getBytes();
	      
	      // Activate the servant with the ID on myPOA
	      myPOA.activate_object_with_id(managerId, managerServant);

	      // Activate the POA manager
	      rootPOA.the_POAManager().activate();

	      System.out.println(myPOA.servant_to_reference(managerServant) + 
	                         " is ready.");
	      // Wait for incoming requests
	      orb.run();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
