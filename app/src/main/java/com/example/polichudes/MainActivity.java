package com.example.polichudes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ModelImage> modelImages;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        listShow();
        myAdapter = new MyAdapter(this, modelImages);
        listView.setAdapter(myAdapter);
    }

    private void listShow() {
        modelImages = new ArrayList<>();
        modelImages.add(new ModelImage("Bayroq", "Rasmga qarab Davlat Nomini yozing", R.drawable.uzbekistan));
        modelImages.add(new ModelImage("Mashina", "Rasmga qarab Mashina Nomini yozing", R.drawable.captiva));
        modelImages.add(new ModelImage("Aktyorlar", "Rasmga qarab Aktyorlar Ism va Familiyasini yozing", R.drawable.otabek_mahkamov));
        modelImages.add(new ModelImage("Taomlar", "Rasmga qarab Taomlar nomini yozing", R.drawable.ovqat_osh));
        modelImages.add(new ModelImage("Salatlar", "Rasmga qarab Salat nomini yozing", R.drawable.salat15));

    }
}
