package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendUDPPacket {
    private static final String MESSAGE = "Hello, World";

    public static void main(String[] args) {
        byte[] buffer = MESSAGE.getBytes();
        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 1024);
            DatagramSocket datagramSocket  = new DatagramSocket();
            datagramSocket.send(packet);
            System.out.println("Message Sent");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
