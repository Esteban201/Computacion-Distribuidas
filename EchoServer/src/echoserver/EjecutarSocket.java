/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gato
 */
public class EjecutarSocket extends Thread {

     ServerSocket server;
     String id;

    public EjecutarSocket(ServerSocket server,String id) {
        this.server=server;
        this.id=id;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = server.accept();
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            
             String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("devuelvo hilo: "+id+"  "+inputLine);
                System.out.println("dato: " + inputLine);
            }
        } catch (IOException ex) {
            Logger.getLogger(EjecutarSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
}
