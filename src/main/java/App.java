
import controller.Controller;
import model.sentence.ServiceSentence;
import model.text.ServiceText;
import view.View;

import java.util.List;

public class App {

    public static void main(String[] args) {
        final String TEXT = "In this case, it makes no difference, since you are replacing everything with an empty string (although it would be better to use \\\\s+ from an efficiency point of view). If you were replacing with a non-empty string, the two would behave differently.";

        View view = new View();
        ServiceText serviceText = ServiceText.getInstance(TEXT);
        serviceText.setText();
        ServiceSentence serviceSentence = ServiceSentence.getInstance(serviceText);
        Controller controller = new Controller(serviceText, serviceSentence, view, System.in);
        controller.userInputData();
    }
}
