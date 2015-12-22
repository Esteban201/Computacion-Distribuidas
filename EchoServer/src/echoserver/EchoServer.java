/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

/**
 *
 * @author gato
 */
import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {

//
//
//        int portNumber = 8080;
//
//        try (
//                ServerSocket serverSocket =
//                new ServerSocket(portNumber);
//                Socket clientSocket = serverSocket.accept();
//                PrintWriter out =
//                new PrintWriter(clientSocket.getOutputStream(), true);
//                BufferedReader in = new BufferedReader(
//                new InputStreamReader(clientSocket.getInputStream()));) {
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                out.println("devuelvo: "+inputLine);
//                System.out.println("dato: " + inputLine);
//            }
//        } catch (IOException e) {
//            System.out.println("Exception caught when trying to listen on port "
//                    + portNumber + " or listening for a connection");
//            System.out.println(e.getMessage());
//        }
//    }

        IniciarSocket iniciar = new IniciarSocket();
        iniciar.run();
        EjecutarSocket ejecutar = new EjecutarSocket(iniciar.getServer(), "hilo 1");
        EjecutarSocket ejecutar2 = new EjecutarSocket(iniciar.getServer(), "hilo 2");
        ejecutar.start();
        ejecutar2.start();

        try {
            ejecutar.join();
            ejecutar2.join();
        } catch (Exception e) {
        }
    }
}
