package com.example.myapplication02;

public class Productmain {
    String Name;
    String Cost;
    int Pic;

    public Productmain(String name, String cost, int pic) {
        Name = name;
        Cost = cost;
        Pic = pic;
    }

    public int getPic(){
        return Pic;
    }
    public void setPic(int pic){
        Pic = pic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }
}
