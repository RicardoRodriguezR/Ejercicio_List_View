package com.ra.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.squareup.picasso.Picasso;
import com.ra.listviewexample.models.Car;


public class AdapterCar extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Car> cars;

    public AdapterCar(Activity activity, ArrayList<Car> cars) {
        this.activity = activity;
        this.cars = cars;
    }

    public  void addCar(ArrayList<Car> carsElements){
        cars.addAll(carsElements);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.car_item, null);
        }

        Car carElement = cars.get(position);

        TextView nameCar = v.findViewById(R.id.CarName);
        TextView modelCar = v.findViewById(R.id.carModel);
        TextView value = v.findViewById(R.id.carValue);
        TextView cylinderCapacity = v.findViewById(R.id.carCylindreCapacity);
        ImageView carImageView = v.findViewById(R.id.carImageView);

        nameCar.setText(carElement.getName());
        modelCar.setText(carElement.getModel());
        value.setText(carElement.getName());
        cylinderCapacity.setText(carElement.getName());

        Picasso.get().load(carElement.getImage()).resize(300, 150).centerCrop().error(R.mipmap.ic_launcher).into(carImageView);
        return v;
    }
}
