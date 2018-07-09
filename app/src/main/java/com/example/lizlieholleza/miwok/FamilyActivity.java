package com.example.lizlieholleza.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class    FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> familyList = new ArrayList<Word>();

        familyList.add(new Word("fatherәpә", "father", R.drawable.family_father, R.raw.family_father));
        familyList.add(new Word("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother));
        familyList.add(new Word("angsi", "son", R.drawable.family_son, R.raw.family_son));
        familyList.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        familyList.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyList.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyList.add(new Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyList.add(new Word("kolliti", "younger sister",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyList.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyList.add(new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, familyList, R.color.category_family);
        ListView  lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = familyList.get(position);
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getSoundId());
                mediaPlayer.start();
            }
        });
    }
}
