package edu.gu.hajo.chat.client.client;

import edu.gu.hajo.chat.client.client.IObserver.Event;
import edu.gu.hajo.chat.client.util.ChatClientOptions;
import edu.gu.hajo.chat.server.spec.IChatClient;
import edu.gu.hajo.chat.server.spec.IChatServer;
import edu.gu.hajo.chat.server.spec.IMessage;
import edu.gu.hajo.chat.server.spec.IPeer;
import edu.gu.hajo.chat.server.core.Constants;
import edu.gu.hajo.chat.server.core.MessageBox;
import edu.gu.hajo.chat.server.core.User;

import java.io.Serializable;
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
    private final String passwd = ChatClientOptions.getPasswd();
    private final IObserver observer;
    
	static IChatServer server;
	
    public Client(IObserver observer) {
        this.observer = observer;
        Registry registry;
		try { //print and paste from TestServer class
			registry = LocateRegistry.getRegistry(
			ChatClientOptions.getConnection().getRegistryIp(),
			ChatClientOptions.getConnection().getRegistryPort());
			server = (IChatServer) registry.lookup(Constants.SERVER_NAME);
		    UnicastRemoteObject.exportObject(this,ChatClientOptions.getConnection().getMyPort());
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // ILocalClient ------------------------------------------
    public void connectToServer(){ 
    	//TODO
    }
    
    public void disconnectFromServer(){
    	//TODO
    }
    public void send(String msg){
    	//TODO
    }
    public void lookUp(String username){
    	//TODO
    }
    public List<String> getdownloadableFiles(){
    	//TODO
    	return null;
    }
    public void downloadFile(String filename){
    	//TODO
    }
    // -------- IPeer --------------------
    public List<String> getUploads() throws RemoteException{
    	//TODO
    	return null;
    	}
	public byte [] uploadFile(String filename) throws RemoteException{
		//TODO
		return null;
		}
	// IChatClient -----------------------------------------------
	public String getPassword() throws RemoteException{
		// TODO
		return null;
		}
    public String getLogin() throws RemoteException{
		// TODO
		return null;}
    public User getUser() throws RemoteException{
		// TODO
		return null;}
    public void setUser(User user) throws RemoteException{
		// TODO
		}
    public void userLoggedIn(String user)throws RemoteException{
		// TODO
		}
    public void userloggedOut(String user)throws RemoteException{
		// TODO
		}
    public void iniChat(HashSet<User> users) throws RemoteException{
		// TODO
		}
    public void publish(IMessage msg) throws RemoteException{
		// TODO
		}
    public void ping() throws RemoteException{
		// TODO
		}
    // -------------------------------------------------------------------
    
    // Handle over to Swing thread (from RMI thread)
    
    private void publishSwing(final IObserver.Event event, final Object data) {
      if(observer!=null){
    	  observer.onEvent(event, data);
      }
    }

    private class Task extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
    	//TODO
    }

    private class Downloader extends SwingWorker<byte [],String>{

		@Override
		protected byte[] doInBackground() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
    	//TODO
    }

}
