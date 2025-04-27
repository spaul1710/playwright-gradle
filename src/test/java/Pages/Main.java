package Pages;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CalculationPolymorphism calc = new CalculationPolymorphism();
        // Compile-time polymorphism: selecting the appropriate add method based on parameter types
        System.out.println("Sum of integers: " + calc.add(5, 3));
        System.out.println("Sum of doubles: " + calc.add(2.5, 3.7));
        Programmer p=new Programmer();
        System.out.println("Programmer salary is:"+p.salary);
        System.out.println("Bonus of Programmer is:"+p.bonus);
        //creating an instance of the encapsulated class
        StudentEncapsulation s=new StudentEncapsulation();
//setting value in the name member
        s.setName("vijay");
//getting value of the name member
        System.out.println(s.getName());
        Bike obj = new Honda();
        obj.run();
        Drawable d=new Circle();//In real scenario, object is provided by method e.g. getDrawable()
        d.draw();

    }
}