package chainofresponsibility;

import java.util.Map;

public class Message {


    private String text;
    private Map<String, String> header;

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
