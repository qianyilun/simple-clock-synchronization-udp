## Java Socket Programming with UDP

**DatagramSockets** are Java's mechansim for network communication via UDP.DatagramSockets can be used to both send and receive packets over the Internet.



### Java Datagram Programming Model Steps

1. Creation of DatagramSocket

   *  A DatagramSocket object is created to carry the packet to the destination and to receive it whenever the server sends any data
   * `DatagramSocket ds = new DatagramSocket();` is used

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

