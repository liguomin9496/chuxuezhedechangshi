package com.dashi;

public class Taxi extends Car{
    String company;
    Taxi(){};
    Taxi(String color,String userName,String company){
        super(color,userName);
        this.company = company;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public final void ride(){
        System.out.println("出租车是所属于在"+company+"公司的");
    }
    public void use(){
        System.out.println("出租车是提高市民生活质量的重要条件之一");
    }
    public String toString() {
        return this.getUserName()+"拥有一辆"+this.getColor()+"的出租车";
    }
}