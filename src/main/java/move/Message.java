package move;

import java.io.Serializable;

public class Message extends MessageAbstract {
    private String text;
    public Message(){
        super();
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int count() {
        return this.text.length() + 10;
    }

    @Override
    public void write(String key) {
        System.out.println("We are in message");
    }
}

