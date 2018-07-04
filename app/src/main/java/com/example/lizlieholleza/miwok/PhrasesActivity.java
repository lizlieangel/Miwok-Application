package com.example.lizlieholleza.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrasesList = new ArrayList<Word>();
        phrasesList.add(new Word("minto wuksus","Where are you going?"));
        phrasesList.add(new Word("tinnә oyaase'nә","What is your name?"));
        phrasesList.add(new Word("oyaaset...","My name is..."));
        phrasesList.add(new Word("michәksәs?","How are you feeling?"));
        phrasesList.add(new Word("kuchi achit","I'm feeling good."));
        phrasesList.add(new Word("әәnәs'aa?","Are you coming?"));
        phrasesList.add(new Word("hәә’ әәnәm","Yes, I'm coming."));
        phrasesList.add(new Word("әәnәm","I'm coming."));
        phrasesList.add(new Word("yoowutis","Let's go."));
        phrasesList.add(new Word("әnni'nem","Come here."));

        WordAdapter adapter = new WordAdapter(this,phrasesList);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
}
