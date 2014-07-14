package com.PPCtrl.malain.powerpointcontrol;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] web;
    //private final int[] imageId;

    public CustomList(Activity context, String[] web/*, int[] imageId*/){
        super(context, R.layout.slide_list_item, web);
        this.context = context;
        this.web = web;
        //this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.slide_list_item, null, true);
        TextView txtTitle = (TextView)rowView.findViewById(R.id.tv_slide_name);
        //ImageView imageView = (ImageView)rowView.findViewById(R.id.slide_thumbnail);
        txtTitle.setText(web[position]);
        //imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
