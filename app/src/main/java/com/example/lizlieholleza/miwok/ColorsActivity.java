package com.example.lizlieholleza.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorList = new ArrayList<Word>();

        colorList.add(new Word("weṭeṭṭi","red"));
        colorList.add(new Word("chokokki","green"));
        colorList.add(new Word("ṭakaakki","brown"));
        colorList.add(new Word("ṭopoppi","gray"));
        colorList.add(new Word("kululli","black"));
        colorList.add(new Word("kelelli","white"));
        colorList.add(new Word("ṭopiisә","dusty yellow"));
        colorList.add(new Word("chiwiiṭә","mustard yellow"));

        WordAdapter adapter = new WordAdapter(this, colorList);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
}
