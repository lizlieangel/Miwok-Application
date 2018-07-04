package com.example.lizlieholleza.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> familyList = new ArrayList<Word>();

        familyList.add(new Word("fatherәpә", "father"));
        familyList.add(new Word("әṭa", "mother"));
        familyList.add(new Word("angsi", "son"));
        familyList.add(new Word("tune", "daughter"));
        familyList.add(new Word("taachix", "taachi"));
        familyList.add(new Word("chalitti", "younger brother"));
        familyList.add(new Word("teṭe", "older sister"));
        familyList.add(new Word("kolliti", "younger sister"));
        familyList.add(new Word("ama", "grandmother"));
        familyList.add(new Word("paapa", "grandfather"));

        WordAdapter adapter = new WordAdapter(this, familyList);
        ListView  lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
}
