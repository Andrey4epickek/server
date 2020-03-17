import java.net.*;
import java.io.*;

public class Server {

   public static void main(String[]args) throws IOException {
       int b1,b2,b3,b4,b5,b6;
      int response;
       ServerSocket serverSocket=new ServerSocket(8000);
       while(true) {
           Socket clientSocket = serverSocket.accept();

           DataOutputStream writer =
                   new DataOutputStream(
                           clientSocket.getOutputStream());

           DataInputStream reader =
                   new DataInputStream(
                           clientSocket.getInputStream());

           int request = reader.readInt();
           System.out.println(request);
           b1 = request / 100000;
           b2 = request / 10000 % 10;
           b3 = request / 1000 % 10;
           b4 = request % 1000 / 100;
           b5 = request % 100 / 10;
           b6 = request % 10;
           if (b1 + b2 + b3 == b4 + b5 + b6)
               response = 1;
           else
               response = 2;

           writer.writeInt(response);
           writer.flush();

           reader.close();
           writer.close();
           clientSocket.close();
       }
   }
}
