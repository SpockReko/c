package edu.gu.hajo.chat.client.client;

import java.util.List;


/**
 * The Client seen from the GUI.
 * Implemented by Client used by GUI 
 * @author hajo
 */
public interface ILocalClient {
 
	
    public void connectToServer();
    public void disconnectFromServer();
    public void send(String msg);
    public void lookUp(String username);
    public List<String> getdownloadableFiles();
    public void downloadFile(String filename);

}
