
import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String argv[]) {
        String clientSentence, capitalizedSentence;
        try (ServerSocket welcomeSocket = new ServerSocket(6789); 
                Socket connectionSocket = welcomeSocket.accept(); 
                BufferedReader inFromClient = new BufferedReader(
                new InputStreamReader(connectionSocket.getInputStream())); 
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());) {
            
            System.out.println("server connected");
            
            while (true) {
                clientSentence = inFromClient.readLine();
                if (clientSentence == null) {
                    break;
                }
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                outToClient.writeBytes(capitalizedSentence);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    
}
