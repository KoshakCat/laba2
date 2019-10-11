package model.sentence;

import model.text.ServiceText;

import java.util.ArrayList;
import java.util.List;


public class ServiceSentence {

    private static ServiceSentence instance;
    private ServiceText serviceText;

    private List<String> listClearWords = new ArrayList<>();
    private List<String> listUnclearWords = new ArrayList<>();
    private List<String> listChanging = new ArrayList<>();
    private int changeNumber = 0;

    public static ServiceSentence getInstance(ServiceText serviceText) {
        if (instance == null) {
            instance = new ServiceSentence(serviceText);
        }
        return instance;
    }

    private ServiceSentence (ServiceText serviceText) {
        this.serviceText = serviceText;
    }

    private void parseTextToWords() {
        for (String paragraph : serviceText.getText().getParagraphs()
             ) {
            String[] temp = paragraph.trim().split("[,;:.!?()\\s]+");
            for (int i = 0; i < temp.length; i++) {
                if ("".equals(temp[i])) {
                    continue;
                }
                listClearWords.add(temp[i]);
            }
            //listClearWords.add("\n");
        }
    }

    private void parseTextToWordsBySpace() {
        for (String paragraph : serviceText.getText().getParagraphs()
        ) {
            String[] temp = paragraph.trim().split("[\\s]+");
            for (int i = 0; i < temp.length; i++) {
                if ("".equals(temp[i]) || temp[i].matches("[,;:.!?()]?")) {
                    continue;
                }
                listUnclearWords.add(temp[i]);
            }
            //listUnclearWords.add("\n");
        }
    }

    public List<String> changingStringListWithInputLength (int inputLength, String inputString) {
        parseTextToWords();
        parseTextToWordsBySpace();

        for (int i = 0; i < listUnclearWords.size(); i++) {
            if (listClearWords.get(i).length() == inputLength) {
                String changeTempString = listUnclearWords.get(i).replaceAll(listClearWords.get(i), inputString);
                listChanging.add(changeTempString);
                changeNumber++;
            } else {
                listChanging.add(listUnclearWords.get(i));
            }
        }
        return listChanging;
    }

    public List<String> getListClearWords() {
        return listClearWords;
    }

    public List<String> getListUnclearWords() {
        return listUnclearWords;
    }

    public int getChangeNumber() {
        return changeNumber;
    }
}
