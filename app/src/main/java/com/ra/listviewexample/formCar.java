package com.ra.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ra.listviewexample.models.Car;

import java.util.ArrayList;

public class formCar extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtModel;
    private EditText txtCylindre;
    private EditText txtValue;
    private EditText txtImage;
    private Button btnSave;
    private Button btnList;
    private ArrayList<Car> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_car);

        txtName = findViewById(R.id.txtName);
        txtModel = findViewById(R.id.txtModel);
        txtCylindre = findViewById(R.id.txtCylindre);
        txtValue = findViewById(R.id.txtValue);
        txtImage = findViewById(R.id.txtImage);
        btnSave = findViewById(R.id.btnSave);
        btnList = findViewById(R.id.btnList);

        btnSave.setOnClickListener(this);
        btnList.setOnClickListener(this);

        cars.add(new Car("FORD MUSTANG SHELBY GT350 ", "5163 cc", "2021","274.320.242", "https://www.elpais.com.co/files/article_main/uploads/2019/03/26/5c9a4d87921b4.jpeg"));
        cars.add(new Car("CHEVROLET CAMARO", "6162 cc", "2021","274.000.000", "https://www.cochesusa.com/wp-content/uploads/2020/04/2020-chevrolet-camaro-ss.jpg"));
        cars.add(new Car("SHELBY COBRA", "7010 cc", "1968","226.970.769", "https://cdni.rt.com/actualidad/public_images/2021.02/article/6032b5bee9ff7161fa598825.jpg"));
        cars.add(new Car("ASTON MARTIN VANQUISH", "5935 cc", "2021","990.506.498", "https://cdn.tekniikanmaailma.fi/wp-content/uploads/2017/11/1102-as-vanquish-s-ultimate-1-768x512.jpg"));
        cars.add(new Car("NISSAN SKYLINE GT-R", "3799 cc", "2021","990.506.498", "https://media.gossipvehiculo.com/wp-content/uploads/2020/11/05165244/2021-nissan-gt-r-nismo-mmp-1-1599069103.jpg"));
        cars.add(new Car("NISSAN SKYLINE GT-R", "3745 cc", "2021","1.193.513.343", "https://www.actualidadmotor.com/wp-content/uploads/2020/03/porsche-911-turbo-s-2020-frontal-3-4.jpg"));
    }

    @Override
    public void onClick(View v) {
        if  (v.getId() == R.id.btnSave){
            addCarro();
        }
        if (v.getId() == R.id.btnList){
            Intent myIntent = new Intent(this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("cars", cars);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }
    }

    private void addCarro(){
        String name = txtName.getText().toString();
        String model = txtModel.getText().toString();
        String cylinder = txtCylindre.getText().toString();
        String value = txtValue.getText().toString();
        String image = txtImage.getText().toString();

        Car car = new Car(name,model,cylinder,value,image);
        cars.add(car);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtName.getText().clear();
        txtModel.getText().clear();
        txtCylindre.getText().clear();
        txtValue.getText().clear();
        txtImage.getText().clear();
    }
}