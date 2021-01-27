package com.dashi;

public class Car{
    public String color;
    public String userName;
    Car(){}
    Car(String color,String userName){
        this.color = color;
        this.userName = userName;
    }
    public void use(){
        System.out.println("我是机动车！");
    }
    public String getColor(){
        return color;
    }
    public String getUserName(){
        return userName;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public boolean equals(Car c) {
        if(this.getColor()==c.getColor()&&this.getUserName()==c.getUserName())
            return true;
        else
            return false;
    }
}
