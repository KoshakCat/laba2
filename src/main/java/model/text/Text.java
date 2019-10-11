package model.text;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private List<String> paragraphs;

    public Text(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs=" + paragraphs +
                '}';
    }
}
