package com.ra.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ra.listviewexample.models.Car;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewCars;
    private ArrayList<Car> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        cars = bundle.<Car>getParcelableArrayList("cars");

        listViewCars = findViewById(R.id.ListViewCars);

        AdapterCar adapter = new AdapterCar(this, cars);
        listViewCars.setAdapter(adapter);
        listViewCars.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "ha pulsado el elemento"+ cars.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}