package karaokie.Menu;

import java.io.*;
import java.net.*;
import java.util.*;

public class ImportMenu {

    public static void main(String argv[]) {
        try (Socket clientSocket = new Socket("localhost", 6789);
             ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream())) {

            outToServer.writeObject("sendMenu");
            outToServer.flush();

            Map<Food, Integer> map = (Map<Food, Integer>) inFromServer.readObject();

            

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}