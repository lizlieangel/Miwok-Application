package com.example.lizlieholleza.miwok;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListner = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> phrasesList = new ArrayList<Word>();
        phrasesList.add(new Word("minto wuksus","Where are you going?", R.raw.phrase_where_are_you_going));
        phrasesList.add(new Word("tinnә oyaase'nә","What is your name?", R.raw.phrase_what_is_your_name));
        phrasesList.add(new Word("oyaaset...","My name is...", R.raw.phrase_my_name_is));
        phrasesList.add(new Word("michәksәs?","How are you feeling?", R.raw.phrase_how_are_you_feeling));
        phrasesList.add(new Word("kuchi achit","I'm feeling good.", R.raw.phrase_im_feeling_good));
        phrasesList.add(new Word("әәnәs'aa?","Are you coming?", R.raw.phrase_are_you_coming));
        phrasesList.add(new Word("hәә’ әәnәm","Yes, I'm coming.", R.raw.phrase_yes_im_coming));
        phrasesList.add(new Word("әәnәm","I'm coming.", R.raw.phrase_im_coming));
        phrasesList.add(new Word("yoowutis","Let's go.", R.raw.phrase_lets_go));
        phrasesList.add(new Word("әnni'nem","Come here.", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this,phrasesList, R.color.category_phrases);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = phrasesList.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getSoundId());
                mediaPlayer.start();
            }
        });
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
