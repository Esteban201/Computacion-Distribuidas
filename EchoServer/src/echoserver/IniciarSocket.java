/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gato
 */
public class IniciarSocket implements Runnable {

    private  ServerSocket server;

    @Override
    public void run() {
        int portNumber = 8080;
        try {
            server =
                    new ServerSocket(portNumber);

        } catch (IOException ex) {
            Logger.getLogger(IniciarSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  ServerSocket getServer() {
        return server;
    }

    public  void setServer(ServerSocket server) {
        this.server = server;
    }
    
    
}
