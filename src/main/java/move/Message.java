package move;

import java.io.Serializable;

public class Message implements MessageBase {
    private final String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public int count() {
        return this.text.length() + 10;
    }
}