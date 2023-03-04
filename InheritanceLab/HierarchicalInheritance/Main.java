package InheritanceLab.HierarchicalInheritance;

public class Main {
    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
