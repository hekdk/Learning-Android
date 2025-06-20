package com.example.quadraticequationsolverapp;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolverapp.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {
    String a;
    String b;
    String c;

    ActivityMainBinding activityMainBinding;

    public MyEquation(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding = activityMainBinding;
    }

    public MyEquation() {
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View view){

        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        double discriminant = b*b - 4*a*c;

        double x1, x2;

        if(discriminant > 0){
            x1 = (-b + Math.sqrt(discriminant))/(2*a);
            x2 = (-b - Math.sqrt(discriminant))/(2*a);

            activityMainBinding.textView.setText("x1= " + x1 + "x2= " + x2);
        } else if (discriminant < 0) {
            activityMainBinding.textView.setText("Nor real roots (complex roots)");
        }   else {
            x1 = -b / (2*a);
            activityMainBinding.textView.setText("x= " + x1);
        }
    }
}
