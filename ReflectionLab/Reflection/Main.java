package ReflectionLab.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> aClass = Reflection.class;
        //print this class type
        System.out.println(aClass);
        //print super class type
        System.out.println(aClass.getSuperclass());
        //print all interfaces tht are implemented by this class
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //print instantiate object using reflection and print it too
        Reflection ref = aClass.getDeclaredConstructor().newInstance();
        System.out.println(ref);
    }

}