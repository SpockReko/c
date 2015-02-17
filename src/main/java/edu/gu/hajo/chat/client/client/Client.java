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
	public void connect() {
		me = new User(login, passwd,n,o);
    	observer.onEvent(Event.CONNECTED, me);
    	observer.onEvent(Event.USER_JOINED, login);
    	publishSwing(Event.CONNECTED, this);
    }
    // -Called From MainFrames Disconnect Button
    @Override
    public void disconnect(){
 
    }
	
    // -Called From Mainframes Send Button
    @Override
	public void broadcast(String msg){
    
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
     * 
     *  
    */
    public User login(){
		return me;
    }
    // -------------------------------------------------------------------
    
    // Handle over to Swing thread (from RMI thread)
    
    private void publishSwing(final IObserver.Event event, final Object data) {
       
    }

	
		
	

}
