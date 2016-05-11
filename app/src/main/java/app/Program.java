package app;

import java.io.File;

/**
 * App module
 */
public class Program {

    public static void main(String[] args) throws Exception {
        System.out.println("Program is running");

        FileClassLoader loader = new FileClassLoader();
        Class clazz = loader.createClass(new File("service\\target\\classes\\service\\MyService.class"));
        MyService service = (MyService)clazz.newInstance();
        service.execute();

        //gc (unload class)
        service = null;
        clazz = null;
        loader = null;
        System.gc();

        Thread.sleep(1000); //wait for gc to complete
        //print [Unloading class service.MyService 0x00000007c0061028]
    }
}
