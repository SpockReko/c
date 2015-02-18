package edu.gu.hajo.chat.client.client;


import java.rmi.RemoteException;

import edu.gu.hajo.chat.client.client.StateContext.State;
import edu.gu.hajo.chat.server.spec.IChatClient;
import edu.gu.hajo.chat.server.spec.IMessage;
import edu.gu.hajo.chat.server.spec.IPeer;



/**
 * The contract for the different states using
 * the State pattern
 * @author hajo
 *
 */
public interface IState {
	
	 
    public void connectToServer(IChatClient client) throws RemoteException;
    public void disconnectFromServer(IChatClient client) throws RemoteException;
    public void broadcast(IMessage msg)throws RemoteException;
    public IPeer searchFor(String username) throws RemoteException;
    
    public State getState();

}
