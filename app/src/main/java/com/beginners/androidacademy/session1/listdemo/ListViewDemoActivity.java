package com.beginners.androidacademy.session1.listdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Britt on 05/11/2016.
 */
public class ListViewDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView) findViewById(R.id.listview);

        ColorsRepository.ColorEntry[] colors = ColorsRepository.getColorsArray();
        ColorEntriesAdapter adapter = new ColorEntriesAdapter(this, colors);
        listView.setAdapter(adapter);

    }

    public static class ColorEntriesAdapter extends ArrayAdapter<ColorsRepository.ColorEntry> {

        private final LayoutInflater inflater;

        public ColorEntriesAdapter(Context context, ColorsRepository.ColorEntry[] colors) {
            super(context, 0, colors);
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ColorsRepository.ColorEntry color = getItem(position);
            ColorViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_color, parent, false);
                holder = new ColorViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.coloritem_name);
                holder.detail = (TextView) convertView.findViewById(R.id.coloritem_detail);
                holder.swatch = convertView.findViewById(R.id.coloritem_swatch);
                convertView.setTag(holder);
            } else {
                holder = (ColorViewHolder) convertView.getTag();
            }
            holder.name.setText(color.getName());
            holder.detail.setText(color.getColor());
            holder.swatch.setBackgroundColor(Color.parseColor(color.getColor()));

            return convertView;
        }


    }

    public static class ColorViewHolder {
        TextView name;
        TextView detail;
        View swatch;
    }


}

