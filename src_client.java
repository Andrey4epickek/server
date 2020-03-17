import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class client {
    public static int number;

    public static void setNumber(int number) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
        System.out.print("Введите число: ");
        client.number = Integer.parseInt(input.readLine());
    }
    public static void main(String[] args) throws IOException{
        Socket clientSocket=new Socket("127.0.0.1",8000);

        DataOutputStream writer =
                new DataOutputStream(
                        clientSocket.getOutputStream());

        DataInputStream reader=
                new DataInputStream(
                        clientSocket.getInputStream());

        setNumber(client.number);
        writer.writeInt(number);

        writer.flush();

        int response=reader.readInt();
        System.out.println("Ваш билет счастливый(1)/несчастливый(2) - "+response);

        writer.close();
        reader.close();
        clientSocket.close();
    }
}

