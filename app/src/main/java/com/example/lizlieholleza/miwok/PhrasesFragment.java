package com.example.lizlieholleza.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.word_list, container, false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapter adapter = new WordAdapter(getActivity(),phrasesList, R.color.category_phrases);
        ListView lv = (ListView) rootview.findViewById(R.id.list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word word = phrasesList.get(position);
                int result = audioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), word.getSoundId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootview;
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

}
