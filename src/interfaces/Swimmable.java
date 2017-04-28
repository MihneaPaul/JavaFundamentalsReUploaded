package interfaces;

/**
 * Created by Mihnea on 26.04.2017.
 */
public interface Swimmable {
    void swim();
}
class SwimmableTest {
    // Interface type to define instance variable
    private Swimmable iSwimmable;

    // Interface type to define parameter type for a constructor
    public SwimmableTest(Swimmable aSwimmable) {
        this.iSwimmable=aSwimmable;
    }
    // Interface type to define return type of a method
    public Swimmable getSwimmable() {
        return iSwimmable;
    }
    // Interface type to define parameter type for a method
    public void setSwimmable(Swimmable newSwimmable) {
        this.iSwimmable=newSwimmable;
    }
    public void letItSwim(){
        // Interface type to declare a local variable
        Swimmable localSwimmable = null;
        localSwimmable = this.iSwimmable;

        // An interface variable can be used to invoke any method
        //declared in the interface and the Object class
        localSwimmable.swim();
    }
}

class Fish implements Swimmable {
    private String name;

    public Fish(String name){
        this.name=name;
    }
    public void swim() {
        System.out.println(name+" (a fish) is swimming.");
    }
    public void swim(double distanceInYards) {

    }
}
class FishTest {
    public static void main(String[] args) {
        Swimmable finny = new Fish("Finny");
        finny.swim();
    }
}
