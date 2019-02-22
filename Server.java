import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class Server {
    public static void main(String[] args){
        DatagramSocket serverSocket = null;
        try {
            // create a instance of server datagramSocket
            serverSocket = new DatagramSocket(1234); // at port 1234
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("Server IP: " + inetAddress.getHostAddress());
            System.out.println("Server port: 1234");
            System.out.println("Server is listening...");

            // buf to store data
            byte[] recevied = new byte[1024]; // magic number
            byte[] send = new byte[1024];

            DatagramPacket dpReceive = null;

            // keep listening
            while (true) {
                // receive packet once request is in
                dpReceive = new DatagramPacket(recevied, recevied.length);
                serverSocket.receive(dpReceive);

                System.out.println("Server recevied!");

                InetAddress ip = dpReceive.getAddress();
                int port = dpReceive.getPort();

                // get server's time
                String serverTime = getServerTime();
                System.out.println(serverTime);

                // send server's time back to client by udp
                send = serverTime.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(send, send.length, ip, port);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

    private static String getServerTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        long timeInMillis = date.getTime(); 
        System.out.println(date);
        return String.valueOf(timeInMillis);
    }
}