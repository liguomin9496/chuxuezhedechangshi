package com.dashi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Car c1 = (Car)ac.getBean("c");//Spring容器默认创建单例对象，即从容器中拿出的多个对象是相同的对象
        Car c2 = (Car)ac.getBean("c");
        c1.use();
        if(c1.equals(c2))
            System.out.println("car1和car2的引用比较：true");
        else
            System.out.println("car1和car2的引用比较：true");
        System.out.println("===============================");
        Taxi t = (Taxi)ac.getBean("t");//Taxi t = ac.getBean("t",Taxi.class);
        t.ride();
        t.use();
        System.out.println("taxi的信息是："+t.toString());
        System.out.println("===============================");
        HomeCar hc = (HomeCar)ac.getBean("h");
        hc.display();
        hc.display(5);
    }
}
