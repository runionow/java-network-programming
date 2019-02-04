package tcp;


import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoTCP {
    private static final int TELNET_PORT = 9090;
    private static final int BUFFER_LEN = 2000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(TELNET_PORT);
        Socket clientSocket = serverSocket.accept();
        InetSocketAddress remote = (InetSocketAddress) clientSocket.getRemoteSocketAddress();

        System.out.println("Connection from port :" + remote.getPort() + " host : " + remote.getHostName());

        InputStream in = clientSocket.getInputStream();
        java.io.OutputStream out = clientSocket.getOutputStream();

        byte[] buffer = new byte[BUFFER_LEN];

        while (clientSocket.isConnected()) {
            int len = in.read(buffer);
            System.out.println(new String(buffer));
            if (len > 0) {
                out.write(buffer,0,len);
            }
        }
    }
}
