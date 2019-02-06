package move;

import java.net.Socket;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 7777);
        System.out.println("Connected!");

        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        Class<? extends MessageAbstract> message = Message.class;
        // create an object output stream from the output stream so we can send an object through it
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // make a bunch of messages to send.
//        List<Message> messages = new ArrayList<>();
//        messages.add(new Message("Hello from the other side!"));
//        messages.add(new Message("How are you doing?"));
//        messages.add(new Message("What time is it?"));
//        messages.add(new Message("Hi hi hi hi."));

        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(message);

        System.out.println("Closing socket and terminating program.");
        socket.close();
    }
}
