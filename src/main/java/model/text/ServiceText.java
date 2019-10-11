package model.text;

import java.util.Arrays;
import java.util.List;

public class ServiceText {
    private Text text;
    private String initialText;
    private static ServiceText instance;

    private ServiceText(String initialText) {
        this.initialText = initialText;
    }

    public static ServiceText getInstance(String initialText) {
        if (instance == null) {
            instance = new ServiceText(initialText);
        }
        return instance;
    }

    private List<String> parseTextToParagraphs() {
        String[] paragraphsArray = initialText.split("[\n]+");
        List<String> paragraphs = Arrays.asList(paragraphsArray);
        return paragraphs;
    }

    public void setText() {
        this.text = new Text(parseTextToParagraphs());
    }

    public Text getText() {
        return text;
    }
}
