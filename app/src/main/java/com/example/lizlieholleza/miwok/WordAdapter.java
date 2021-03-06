package com.example.lizlieholleza.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResource;

    public WordAdapter(Context context, ArrayList<Word> words, int color) {
       super(context,0,words);
       this.colorResource = color;
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

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
//        imageView.setImageResource(currentWord.getImageId());
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResource);
        textContainer.setBackgroundColor(color);
        return  listItemView;
    }
}
