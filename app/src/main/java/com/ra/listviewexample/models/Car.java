package com.ra.listviewexample.models;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private String name;
    private String cylinderCapacity;
    private String model;
    private String value;
    private String image;

    public Car(String name, String cylinderCapacity, String model, String value, String image) {
        this.name = name;
        this.cylinderCapacity = cylinderCapacity;
        this.model = model;
        this.value = value;
        this.image = image;
    }

    protected Car(Parcel in) {
        name = in.readString();
        cylinderCapacity = in.readString();
        model = in.readString();
        value = in.readString();
        image = in.readString();
    }

    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(String cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(cylinderCapacity);
        dest.writeString(model);
        dest.writeString(value);
        dest.writeString(image);
    }
}


