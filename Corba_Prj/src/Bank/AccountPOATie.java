package Bank;
/**
 * <ul>
 * <li><b>IDL Source </b> "../idl/Bank.idl"
 * <li><b>IDL Name </b> ::Bank::Account
 * <li><b>Repository Id </b> IDL:Bank/Account:1.0
 * </ul>
 * <b>IDL definition: </b>
 * 
 * <pre>
 * 
 *  interface Account {
 *  ...
 *  };
 *  
 * </pre>
 */
public class AccountPOATie extends AccountPOA {
	private Bank.AccountOperations _delegate;
	private org.omg.PortableServer.POA _poa;
	public AccountPOATie(final Bank.AccountOperations _delegate) {
		this._delegate = _delegate;
	}
	public AccountPOATie(final Bank.AccountOperations _delegate,
			final org.omg.PortableServer.POA _poa) {
		this._delegate = _delegate;
		this._poa = _poa;
	}
	public Bank.AccountOperations _delegate() {
		return this._delegate;
	}
	public void _delegate(final Bank.AccountOperations the_delegate) {
		this._delegate = the_delegate;
	}
	public org.omg.PortableServer.POA _default_POA() {
		if (_poa != null) {
			return _poa;
		} else {
			return super._default_POA();
		}
	}
	/**
	 * <pre>
	 * float balance();
	 * </pre>
	 */
	public float balance() {
		return this._delegate.balance();
	}
}