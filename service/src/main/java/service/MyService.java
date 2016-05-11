package service;


public class MyService implements app.MyService {

    public void execute() {
       System.out.println("executing " + this.getClass().getName());
    }
}
