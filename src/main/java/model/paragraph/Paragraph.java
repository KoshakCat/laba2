package model.paragraph;

import java.util.List;

public class Paragraph {
    private List<String> sentences;

    public Paragraph(List<String> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "sentences=" + sentences +
                '}';
    }
}
