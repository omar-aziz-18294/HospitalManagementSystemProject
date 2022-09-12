package com.example.hospitalmanagementproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class MyCustomListAdapter extends ArrayAdapter<String> {
    private Activity c;
    private ArrayList<String> titlearray1, lastMessage1, fee1;
    private ArrayList imagearray1;
    ImageView iv_profileImage;
    TextView tv_title, tv_lastMessage, tv_fee;

    public MyCustomListAdapter(@NonNull Activity context, ArrayList<String> titlearray, ArrayList<String> lastMessage, ArrayList imagearray, ArrayList<String> fee) {
        super(context, R.layout.activity_book, titlearray);
        c = context;
        titlearray1 = titlearray;
        lastMessage1 = lastMessage;
        imagearray1 = imagearray;
        fee1 = fee;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = c.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_book, parent, false);
        iv_profileImage = rowView.findViewById(R.id.profile_image);
        tv_lastMessage = rowView.findViewById(R.id.tv_lastmessgae);
        tv_title = rowView.findViewById(R.id.tv_title);
        tv_fee = rowView.findViewById(R.id.tv_fee);

        iv_profileImage.setImageResource((Integer) imagearray1.get(position));
        tv_lastMessage.setText(lastMessage1.get(position));
        tv_title.setText(titlearray1.get(position));
        tv_fee.setText(fee1.get(position));

        return rowView;
    }

    @Override
    public int getCount() {
        return titlearray1.size();
    }
}