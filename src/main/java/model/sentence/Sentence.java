package model.sentence;


import java.util.List;

public class Sentence {
    private List<String> words;

    public Sentence(List<String> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + words +
                '}';
    }
}
