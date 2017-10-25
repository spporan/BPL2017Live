package com.poran.bpl2017live;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by poran on 10/6/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter {

    ArrayList<String> titles = new ArrayList<>();

    public CustomArrayAdapter(Context context, int resource, int textViewResourceId,ArrayList<String> titles ) {
        super(context, resource, textViewResourceId, titles);
        this.titles=titles;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_row, null);
        TextView textView = (TextView) v.findViewById(R.id.title);

        textView.setText(titles.get(position));

        return v;
    }
}
