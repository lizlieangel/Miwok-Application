package com.example.lizlieholleza.miwok;

public class Word {
    private String miwokWord;
    private String defaultWord;

    public Word(String dMiwok, String dWord) {
        this.miwokWord = dMiwok;
        this.defaultWord = dWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public void setMiwokWord(String miwokWord) {
        this.miwokWord = miwokWord;
    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public void setDefaultWord(String defaultWord) {
        this.defaultWord = defaultWord;
    }
}
