package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class RecieveUDPPAcket {
    private static final int BUFFLEN = 2000;

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(1024);
        byte[] recieveData = new byte[BUFFLEN];

        DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);

        try {
            serverSocket.receive(receivePacket);
            String data = new String(receivePacket.getData());
            System.out.println("RECIEVED : " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
