package interfaces;

import com.sun.prism.shader.DrawCircle_LinearGradient_PAD_AlphaTest_Loader;

/**
 * Created by Mihnea on 26.04.2017.
 */
public interface Walkable {
    void walk();

    static void letThemWalk(Walkable[] list) {
        for(Walkable w : list) {
            w.walk();
        }
    }
}

class Person implements Walkable {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public void walk() {
        System.out.println(name+" (a person) is walking.");
    }
}

class Duck implements Walkable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }
    public void walk() {
        System.out.println(name+" (a duck) is walking.");
    }
}

class Cat implements Walkable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }
    public void walk() {
        System.out.println(name+" (a cat) is walking.");
    }
}

class WalkablesTest {
    public static void main(String[] args) {
        Walkable[] w = new Walkable[4];
        w[0]=new Person("Jack");
        w[1]=new Duck("Duffy");
        w[2]=new Duck("Android");
        w[3]=new Cat("Lola");

        Walkable.letThemWalk(w);
    }
}
