package Pages;

public abstract class Bike {
    abstract void run();
}
//Creating a child class and override abstract method
class Honda extends Bike{
    void run(){System.out.println("running safely");}
}
