import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Date;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = new DatagramSocket(1234); // at port 1234
        byte[] recevied = new byte[65535]; // magic number
        byte[] send = new byte[65535];

        DatagramPacket dpReceive = null;

        while (true) {
            dpReceive = new DatagramPacket(recevied, recevied.length);
            ds.receive(dpReceive);

            System.out.println("Server recevied!");

            InetAddress ip = dpReceive.getAddress();
            int port = dpReceive.getPort();

            send = getServerTime().getBytes();

            DatagramPacket sendPacket = new DatagramPacket(send, send.length, ip, port);
            serverSocket.send(sendPacket);
        }
    }

    private static String getServerTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        long timeInMillis = date.getTime(); 
        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int msec = cal.get(Calendar.MILLISECOND);

        System.out.println("Get sever time: " + hour + ":" + min + ":" + sec + ":" + msec);
        
        return String.valueOf(timeInMillis);
    }
}