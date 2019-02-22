import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception{
        // start the "timer"
        long startTimeInMillis = System.currentTimeMillis();

        // create a client datagramSocket instance
        DatagramSocket clientSocket = new DatagramSocket();

        // buffs to store data
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        // get server's ip instance
        InetAddress serverIp = InetAddress.getByName("192.168.0.15");

        // send request by udp
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIp, 1234);
        clientSocket.send(sendPacket);

        // receive response from server by udp
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String serverResponse = new String(receivePacket.getData());
        System.out.println("Server's response: " + serverResponse);

        long serverTimeInMillis = Long.parseLong(serverResponse.trim()); 
        
        // stop the "timer" and caculate RTT
        long endTimeInMillis = System.currentTimeMillis();
        long calculatedClientTime = (endTimeInMillis - startTimeInMillis) / 2 + serverTimeInMillis;
        Calendar newClientTime = Calendar.getInstance();
        newClientTime.setTimeInMillis(calculatedClientTime);

        System.out.println("calculated Client Time in Milliseconds is: " + calculatedClientTime);
        System.out.println("calculated Client Time is: " + newClientTime.getTime());

        // close connection
        clientSocket.close();
    }
}