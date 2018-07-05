package com.example.lizlieholleza.miwok;

public class Word {
    private String miwokWord;
    private String defaultWord;
    private int imageId;
//    private int imageId = NO_IMAGE_PROVIDED;
//    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String dMiwok, String dWord) {
        this.miwokWord = dMiwok;
        this.defaultWord = dWord;
    }

    public Word(String mword, String dword, int imgId ) {
        this.miwokWord = mword;
        this.defaultWord = dword;
        this.imageId = imgId;
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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int image) {
        this.imageId = image;
    }

//    public boolean hasImage() {
//        return imageId != NO_IMAGE_PROVIDED; //true
//    }
}
