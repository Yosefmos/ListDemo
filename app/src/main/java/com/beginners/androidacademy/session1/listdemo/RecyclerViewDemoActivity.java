package com.beginners.androidacademy.session1.listdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Britt on 05/11/2016.
 */
public class RecyclerViewDemoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ColorsRepository.ColorEntry[] colors = ColorsRepository.getColorsArray();
        ColorEntriesAdapter adapter = new ColorEntriesAdapter(this, colors);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.vertical_lm:
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                return true;
            case R.id.horizontal_lm:
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                return true;
            case R.id.grid_lm:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                return true;
            case R.id.staggered_lm:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public static class ColorEntriesAdapter extends RecyclerView.Adapter<ColorViewHolder> {

        private final ColorsRepository.ColorEntry[] colors;
        private final LayoutInflater inflater;

        public ColorEntriesAdapter(Context context, ColorsRepository.ColorEntry[] colors) {
            this.colors = colors;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.item_color, parent, false);
            ColorViewHolder holder = new ColorViewHolder(itemView);
            holder.name = (TextView) itemView.findViewById(R.id.coloritem_name);
            holder.detail = (TextView) itemView.findViewById(R.id.coloritem_detail);
            holder.swatch = itemView.findViewById(R.id.coloritem_swatch);
            return holder;
        }

        @Override
        public void onBindViewHolder(ColorViewHolder holder, int position) {
            ColorsRepository.ColorEntry color = colors[position];
            holder.name.setText(color.getName());
            holder.detail.setText(color.getColor());
            holder.swatch.setBackgroundColor(Color.parseColor(color.getColor()));

        }

        @Override
        public int getItemCount() {
            return colors.length;
        }

    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView detail;
        View swatch;

        public ColorViewHolder(View itemView) {
            super(itemView);
        }
    }


}
