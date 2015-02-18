package edu.gu.hajo.chat.client.client;

import edu.gu.hajo.chat.client.client.IObserver.Event;
import edu.gu.hajo.chat.client.exception.ChatClientException;
import edu.gu.hajo.chat.client.util.ChatClientOptions;
import edu.gu.hajo.chat.server.spec.IChatClient;
import edu.gu.hajo.chat.server.spec.IChatServer;
import edu.gu.hajo.chat.server.spec.IMessage;
import edu.gu.hajo.chat.server.spec.IPeer;
import edu.gu.hajo.chat.server.core.Constants;
import edu.gu.hajo.chat.server.core.MessageBox;
import edu.gu.hajo.chat.server.core.User;

import java.io.Serializable;
import java.lang.Thread.State;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.List;
import java.util.TimerTask;

import javax.swing.SwingWorker;

/**
 * Implementation of many interfaces. Serializable important!
 *
 * @author hajo
 */
public class Client implements ILocalClient, IChatClient, IPeer,
Serializable {

	private final transient StateContext context = null;

	// The logged in user
	private User me;
	private final String login = ChatClientOptions.getLogin();
	private final String password = ChatClientOptions.getPasswd();
	private final IObserver observer;

	static IChatServer server;

	public Client(IObserver observer) {
		this.observer = observer;
//		Registry registry;
//		try { //Print and paste from TestServer class
//			//This creates the connection between this object and the server. 
//			registry = LocateRegistry.getRegistry(
//					ChatClientOptions.getConnection().getRegistryIp(),
//					ChatClientOptions.getConnection().getRegistryPort());
//			server = (IChatServer) registry.lookup(Constants.SERVER_NAME);
//			UnicastRemoteObject.exportObject(this,ChatClientOptions.getConnection().getMyPort());
//		} catch (RemoteException | NotBoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Error in RMI-connection!");
//			e.printStackTrace();
//		}
	}

	// ILocalClient --- Used by the Mainframe and calls server methods---------------------- 
	//-----------------------------(move the code to the right State class)------

	// remotely calls an method on the server to connect the client to the chat.
	public void connectToServer(){ 
		publishSwing(Event.CONNECTED, me = new User(login, password, new MessageBox(), new MessageBox()));
	}

	// Remotely calls an method on the server to disconnect the client from the chat
	public void disconnectFromServer(){
		//TODO
	}

	// Sends an message from Mainframe to server for distribute to the other clients 
	public void broadcast(String msg){
		//TODO
	}

	// Search for the peer you click on the MainFrame 
	public void searchFor(String username){
		//TODO
	}

	// gets an list with files you can download from the Peer. 
	public List<String> getdownloadableFiles(){
		//TODO
		return null;
	}

	// Download an file from the Peers list.
	public void downloadFile(String filename){
		//TODO
	}

	// -------- IPeer --------------------

	// Gives the list from this client to an another client
	public List<String> getUploads() throws RemoteException{
		//TODO
		return null;
	}

	// Sends an file from this client to another client
	public byte [] uploadFile(String filename) throws RemoteException{
		//TODO
		return null;
	}

	// IChatClient ------ Methods that server calls --------

	// Returns this client Login
	public String getLogin() throws RemoteException{
		return login;
	}

	// Returns this client password
	public String getPassword() throws RemoteException{
		return password;
	}

	// Returns this client User
	public User getUser() throws RemoteException{
		return me;
	}

	// Change the user
	public void setUser(User user) throws RemoteException{
		me = user;
	}

	// Sends the change to the Mainframe
	public void userLoggedIn(String user)throws RemoteException{
		publishSwing(Event.USER_JOINED, user);
	}

	// Sends the change to the Mainframe
	public void userloggedOut(String user)throws RemoteException{
		publishSwing(Event.USER_LEFT, user);
	}

	// ???
	public void iniChat(HashSet<User> users) throws RemoteException{
		// TODO
	}

	// Broadcast an message from the server.
	public void publish(IMessage msg) throws RemoteException{
		publishSwing(Event.MESSAGE, msg);
	}

	// Have no idea what this is for.
	public void ping() throws RemoteException{
		// TODO
	}

	// -------------------------------------------------------------------

	// Handle over to Swing thread (from RMI thread)

	// Sends change to this clients Mainframe.
	private void publishSwing(final IObserver.Event event, final Object data) {
		if(observer!=null){
			observer.onEvent(event, data);
		}
	}

	// -- Step 8: Kontrollera felhantering och "Parallellism"
	private class Task extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}
		//TODO
	}

	// -- Step 8: Kontrollera felhantering och "Parallellism"
	private class Downloader extends SwingWorker<byte [],String>{

		@Override
		protected byte[] doInBackground() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		//TODO
	}

}
