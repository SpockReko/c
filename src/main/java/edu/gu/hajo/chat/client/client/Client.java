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
    
    MessageBox n = new MessageBox();
	MessageBox o = new MessageBox();

	static IChatServer server;
	
    public Client(IObserver observer) {
        this.observer = observer;
    }
    /*
    // ILocalClient ------------------------------------------
    * "The Client seen from the GUI."
    * "Implemented by Client used by GUI"
    */
    // -Callad From MainFrames Connect Button
    @Override
	public void connectGui() throws RemoteException, NotBoundException {
    	
		me = new User(login, passwd,n,o);
		me = login();
    	observer.onEvent(Event.CONNECTED, me);
    	observer.onEvent(Event.USER_JOINED, login);
    }
    // -Called From MainFrames Disconnect Button
    @Override
    public void disconnectGui(){
    	observer.onEvent(Event.DISCONNECTED, me);
    	observer.onEvent(Event.USER_LEFT, login);
    }
	
    // -Called From Mainframes Send Button
    @Override
	public void sendGui(String data){
    	// skickar meddelande till servern så lägger de ut den till användarna.
	}
    
    // -------- IPeer --------------------
    /*
    * Frågor:
    * Vad vet vi om IPeer nu?
    * Interfaces finns på server klassen.
    * One clients view of another (peer2peer)
    * Vad har IPeer för syfte?
    * En annan klient ska kunna integrera med en annan specifik klient.
    * Möjliga metoder:
    */
    // - Called From PeerDialogs Download Button
    @Override
    public void Download(){
    	
    }
	
    // - Called From PeerDialogs Cancel Button
    @Override
	public void cancel(){
    	
    }
    // IChatClient -----------------------------------------------
    /*
    * Frågor:
    * 
    * 
    * 
    */
    public User login() throws RemoteException, NotBoundException{
    	Registry reg =  LocateRegistry.getRegistry(
                ChatClientOptions.getConnection().getRegistryIp(),
                ChatClientOptions.getConnection().getRegistryPort());
    	server = (IChatServer) reg.lookup(Constants.SERVER_NAME);
    	UnicastRemoteObject.exportObject(this,ChatClientOptions.getConnection().getMyPort());
    	return me;
    }
    // -------------------------------------------------------------------
    
    // Handle over to Swing thread (from RMI thread)
    
    private void publishSwing(final IObserver.Event event, final Object data) {
       
    }

	
		
	

}
