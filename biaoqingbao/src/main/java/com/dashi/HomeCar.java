package com.dashi;

public final class HomeCar extends Car{
    int num;
    HomeCar(){}
    HomeCar(String color,String userName,int num){
        super(color,userName);
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num){
        this.num = num;
    }
    public void display(){
        System.out.println("拥有的"+this.getColor()+"颜色的私家车有"+num+"座位");
    }
    public void display(int num){
        System.out.println("家用汽车大多有"+num+"个座位");
    }
}