package edu.gu.hajo.chat.client.client;

import java.lang.Thread.State;
import java.rmi.RemoteException;

import edu.gu.hajo.chat.server.spec.IChatClient;
import edu.gu.hajo.chat.server.spec.IMessage;
import edu.gu.hajo.chat.server.spec.IPeer;

/**
 * Handles the states and transitions between them
 *
 * @author hajo
 *
 */
final class StateContext {

	private IState state = new Disconnected();
	
	public void setState(IState state) {
		//TODO
	}
	
	public IState getState(){
		//TODO
		return null;
	}

	
	public class Connected implements IState{
		

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
		public void send(IMessage msg) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public IPeer lookUp(String username) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public class Disconnected implements IState{

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
		public void send(IMessage msg) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public IPeer lookUp(String username) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
