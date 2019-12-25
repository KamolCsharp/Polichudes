package com.example.polichudes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<ModelImage> modelImages;

    public MyAdapter(Context context, ArrayList<ModelImage> modelImages) {
        this.context = context;
        this.modelImages = modelImages;
    }

    @Override
    public int getCount() {
        return modelImages.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false);
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        ImageView imageView = view.findViewById(R.id.imageview);
        title.setText(modelImages.get(position).getTitle());
        description.setText(modelImages.get(position).getDescription());
        imageView.setImageResource(modelImages.get(position).getImages());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Main2Activity.this,Main3Activity.class );
                context.startActivity(new Intent(context, Main3Activity.class).putExtra("Id", position));
            }
        });
        return view;
    }
}
