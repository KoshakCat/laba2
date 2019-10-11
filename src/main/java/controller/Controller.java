package controller;

import model.sentence.ServiceSentence;
import model.text.ServiceText;
import view.View;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private ServiceText serviceText;
    private ServiceSentence serviceSentence;
    private View view;
    private InputStream in;

    private final Pattern menuCodePattern = Pattern.compile("[1-9]+");


    public Controller(ServiceText serviceText, ServiceSentence serviceSentence, View view, InputStream in) {
        this.serviceText = serviceText;
        this.serviceSentence = serviceSentence;
        this.view = view;
        this.in = in;
    }

    private boolean isNumberMenuValid (String userString) {
        Matcher menuNumberCodeMatcher = menuCodePattern.matcher(userString);
        return menuNumberCodeMatcher.matches();
    }

    public void userInputData () {

        boolean isExit = false;
        while (!isExit) {

            view.printLabaMenu();
            Scanner scanner = new Scanner(in);
            String userMenuCommand = scanner.nextLine();

            if (!isNumberMenuValid(userMenuCommand)) {
                view.printInputIncorrectData();
                continue;
            }

            int inputUserLength = Integer.parseInt(userMenuCommand);

            view.printWordToChange();
            String userInputText = scanner.nextLine();



            List<String> result = serviceSentence.changingStringListWithInputLength(inputUserLength, userInputText);

            for (String resultString : result
                 ) {
                System.out.print(resultString + " ");
            }

            System.out.println();
            System.out.println("Total changing : " + serviceSentence.getChangeNumber());

            isExit = true;

        }
    }
}
