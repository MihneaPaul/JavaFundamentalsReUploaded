package interfaces;

/**
 * Created by Mihnea on 26.04.2017.
 */
public interface Movable {
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    default void move(double deltaX, double deltaY) {
        double newX = getX() + deltaX;
        double newY = getY() + deltaY;
        setX(newX);
        setY(newY);
    }
}

class Pen implements Movable {
    private double x;
    private double y;

    public Pen() {
    }

    public Pen(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(double x) {
        this.x=x;
    }

    @Override
    public void setY(double y) {
        this.y=y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }
    public String toString() {
        return "Pen("+x+", "+y+")";
    }
}

class MovableTest {
    public static void main(String[] args) {
        Movable p1 = new Pen();
        System.out.println(p1);
        p1.setX(10.0);
        p1.setY(5.0);
        System.out.println(p1);
        p1.move(5.0,2.0);
        System.out.println(p1);
    }
}
