package edu.gu.hajo.chat.client.client;

import edu.gu.hajo.chat.client.client.StateContext.State;
import java.rmi.RemoteException;
import edu.gu.hajo.chat.server.spec.IChatClient;
import edu.gu.hajo.chat.server.spec.IMessage;
import edu.gu.hajo.chat.server.spec.IPeer;

public class IsConnected implements IState {

	
	private final State state = State.Disconnected;
	
	@Override
	public void connectToServer(IChatClient client) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnectFromServer(IChatClient client) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void broadcast(IMessage msg) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public IPeer searchFor(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
