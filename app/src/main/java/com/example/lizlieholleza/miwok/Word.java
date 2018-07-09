package com.example.lizlieholleza.miwok;

public class Word {
    private String miwokWord;
    private String defaultWord;
    private int imageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int soundId;

    public Word(String dMiwok, String dWord, int soundId) {
        this.miwokWord = dMiwok;
        this.defaultWord = dWord;
        this.soundId = soundId;
    }

    public Word(String mword, String dword, int imgId, int soundId) {
        this.miwokWord = mword;
        this.defaultWord = dword;
        this.imageId = imgId;
        this.soundId = soundId;
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

    public boolean hasImage() {
        return imageId != NO_IMAGE_PROVIDED; //true
    }

    public int getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }
}
