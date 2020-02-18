package chainofresponsibility;

import java.util.Collections;
import java.util.Map;

public class Message {

    private String text;
    private Map<String, String> header;

    public Message() {
        header = Collections.emptyMap();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
}
