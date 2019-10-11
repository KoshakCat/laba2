package model.paragraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ServiceParagraph {
    private List<String> paragraphs;
    private Paragraph paragraph;

    public ServiceParagraph(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    private List<String> parseParagraphsToSentences() {
        List<String> sentences = new ArrayList<>();
        for (String p: paragraphs
             ) {
            String[] temp = p.trim().split("[.?!]");
            for (int i = 0; i < temp.length; i++) {
                sentences.add(temp[i]);
            }
        }
        return sentences;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public void setParagraph() {
        this.paragraph = new Paragraph(parseParagraphsToSentences());
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }
}
