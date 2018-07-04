package com.example.lizlieholleza.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context,0,words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word currentWord = getItem(position);
        TextView mTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        mTextView.setText(currentWord.getMiwokWord());

        TextView dTextView = (TextView)  listItemView.findViewById(R.id.default_text_view);
        dTextView.setText(currentWord.getDefaultWord());

        return  listItemView;
    }
}
