package com.example.capstone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem> listItems = new ArrayList<ListItem>();

    public ListViewAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView list_image=(ImageView)convertView.findViewById(R.id.list_image);
        TextView list_ingredients = (TextView)convertView.findViewById(R.id.list_ingredients);
        TextView list_date = (TextView)convertView.findViewById(R.id.list_date);
        ListItem listItem = listItems.get(position);

        list_image.setImageDrawable(listItem.getImage());
        list_ingredients.setText(listItem.getText1());
        list_date.setText(listItem.getText2());



        return convertView;
    }
    public void addItem(Drawable image, String text1, String text2){
        ListItem listItem = new ListItem();

        listItem.setImage(image);
        listItem.setText1(text1);
        listItem.setText2(text2);

        listItems.add(listItem);
    }



}
