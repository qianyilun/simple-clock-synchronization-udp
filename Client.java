import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception{
        // start the "timer"
        long startTimeInMillis = System.currentTimeMillis();

        DatagramSocket clientSocket = new DatagramSocket();

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        InetAddress serverIp = InetAddress.getByName("192.168.0.15");
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIp, 1234);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String serverResponse = new String(receivePacket.getData());
        System.out.println(serverResponse);
        long serverTimeInMillis = Long.parseLong(serverResponse.trim()); 
        
        // stop the "timer"
        long endTimeInMillis = System.currentTimeMillis();
        long calculatedClientTime = (endTimeInMillis - startTimeInMillis) / 2 + serverTimeInMillis;
        Calendar newClientTime = Calendar.getInstance();
        newClientTime.setTimeInMillis(calculatedClientTime);

        System.out.println("calculated Client Time in Milliseconds is: " + calculatedClientTime);
        System.out.println("calculated Client Time is: " + newClientTime.getTime());

        clientSocket.close();
    }
}