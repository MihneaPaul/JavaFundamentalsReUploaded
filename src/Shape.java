/**
 * Created by Mihnea on 26.04.2017.
 */
public abstract class Shape {
    private String name;

    public Shape(){
        this.name="Unknown shape";
    }
    public Shape(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void draw();
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height){
        super("Rectangle");
        this.width=width;
        this.height=height;
    }
    public void draw() {
        System.out.println("Drawing a rectangle...");
    }
    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return 2.0*(width+height);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius=radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle...");
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2.0*Math.PI*radius;
    }
}

class ShapeUtil {
    public static void drawShapes(Shape[] list) {
        for(int i=0;i<list.length;i++) {
            //Draw a shape, not matter what it is
            list[i].draw();
        }
    }
    public static void printShapeDetails(Shape[] list){
        for(int i=0;i<list.length;i++) {
            //Gather details about the shape
            String name = list[i].getName();
            double area = list[i].getArea();
            double perimeter = list[i].getPerimeter();
            System.out.println("Name: "+name);
            System.out.println("Area of "+name+": "+area);
            System.out.println("Perimenter of "+name+": "+perimeter);
        }
    }
}

class ShapeUtilTest {
    public static void main(String[] args) {
        //Create some shapes, draw, and print their details
        Shape[] shapeList = new Shape[2];
        shapeList[0]=new Rectangle(2.0,4.0);
        shapeList[1]=new Circle(5.0);

        ShapeUtil.drawShapes(shapeList);
        ShapeUtil.printShapeDetails(shapeList);
        Shape c= new Circle(4.0);
        double area = c.getArea();
        System.out.println("Area of new Circle is "+area);
    }
}