## Java Socket Programming with UDP

**DatagramSockets** are Java's mechansim for network communication via UDP. DatagramSockets can be used to both send and receive packets over the Internet.

### Java Datagram Programming Model Steps

1. Creation of DatagramSocket

   *  A DatagramSocket object is created to carry the packet to the destination and to receive it whenever the server sends any data
   * Constructor
   ```java
   public DatagramSocket() throws SocketException

   public DatagramSocket(int port) 
                        throws SocketException
   
   public DatagramSocket(int port,
                       InetAddress inetaddress)
                        throws SocketException
   ```

2. Creation of DatagramPacket

   * the packet for sending/receiving data via a DatagramSocket is created

   * Constructor to send data

     ```java
     DatagramPacket(byte buf[], int length, InetAddress inetaddress, int port)
     ```

   * Constructor to receive data

     ```java
     DatagramPacket(byte buf[], int length)
     ```

3. Invoke a `send()` or `receive()` call on socket object



## Screenshots

#### Server

Server’s time is what we get from the system time

![server with explain](https://ws2.sinaimg.cn/large/006tKfTcly1g0ewbtbnuhj31c00u0nbt.jpg)

#### Client

Time from server is not the same as the local machine's time. It means clock is synced successfully.

![Screen Shot 2019-02-21 at 2.22.45 PM](https://ws1.sinaimg.cn/large/006tKfTcly1g0ew5rctjgj31c00u0wsj.jpg)



## Reference

* https://www.geeksforgeeks.org/working-udp-datagramsockets-java/
* https://systembash.com/a-simple-java-udp-server-and-udp-client/