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

        colorList.add(new Word("weṭeṭṭi","red", R.drawable.color_red));
        colorList.add(new Word("chokokki","green", R.drawable.color_green));
        colorList.add(new Word("ṭakaakki","brown", R.drawable.color_brown));
        colorList.add(new Word("ṭopoppi","gray", R.drawable.color_gray));
        colorList.add(new Word("kululli","black", R.drawable.color_black));
        colorList.add(new Word("kelelli","white", R.drawable.color_white));
        colorList.add(new Word("ṭopiisә","dusty yellow", R.drawable.color_dusty_yellow));
        colorList.add(new Word("chiwiiṭә","mustard yellow", R.drawable.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, colorList, R.color.category_numbers);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
}
