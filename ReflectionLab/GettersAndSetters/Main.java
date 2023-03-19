package ReflectionLab.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //get all reflection methods
        Method[] methods = Reflection.class.getDeclaredMethods();
        //sort each collection alphabetically by methods name
        Method[] getters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") &&
                        m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        //print all getters
        Arrays.stream(getters).forEach(m ->
                System.out.printf("%s will return class %s%n",
                        m.getName(), m.getReturnType().getName()));
    }
}
