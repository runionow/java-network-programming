package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoMultipleClientTCP {
    private static final int TELNET_PORT = 9090;
    private static final int BUFFER_SIZE = 2044;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(TELNET_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            InetSocketAddress client = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
            System.out.println("Connection from port :" + client.getPort() + "Hostname :" + client.getHostName());
            new Thread(()->{
                InputStream in;
                try {
                    in = clientSocket.getInputStream();
                    OutputStream out = clientSocket.getOutputStream();
                    byte[] buffer = new byte[BUFFER_SIZE];

                    while (clientSocket.isConnected()) {
                        int len = in.read(buffer);
                        String data = new String(buffer);
                        System.out.println(data);
                        if (len > 0) {
                            out.write(buffer,0,len);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }
}
