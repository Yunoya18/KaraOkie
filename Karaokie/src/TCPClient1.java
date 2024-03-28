
import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient1 {

    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        String sentence;
        String modifiedSentence;
        try (Socket clientSocket = new Socket("localhost", 6789/*9999*/); DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); BufferedReader inFromServer = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));) {
            
            System.out.println("client connected");

            sentence = sc.nextLine();
            while (!sentence.equals("end")) {
                outToServer.writeBytes(sentence + "\n");
                modifiedSentence = inFromServer.readLine();
                System.out.println("FROM SERVER: " + modifiedSentence);
                sentence = sc.nextLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
