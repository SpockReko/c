package edu.gu.hajo.chat.client.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * The Client seen from the GUI.
 * Implemented by Client used by GUI 
 * @author hajo
 */
public interface ILocalClient {
 
	
	public void connectGui() throws RemoteException, NotBoundException;
	
	public void disconnectGui();
	
	public void sendGui(String data);
	
}
