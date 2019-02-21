import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class Server {
    public static void main(String[] args){
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(1234); // at port 1234
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("Server IP: " + inetAddress.getHostAddress());
            System.out.println("Server port: 1234");
            System.out.println("Server is listening...");

            
            byte[] recevied = new byte[1024]; // magic number
            byte[] send = new byte[1024];

            DatagramPacket dpReceive = null;

            while (true) {
                dpReceive = new DatagramPacket(recevied, recevied.length);
                serverSocket.receive(dpReceive);

                System.out.println("Server recevied!");

                InetAddress ip = dpReceive.getAddress();
                int port = dpReceive.getPort();

                String serverTime = getServerTime();

                System.out.println(serverTime);

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