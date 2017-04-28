/**
 * Created by Mihnea on 26.04.2017.
 */
public class Annotation {
    public void calculate(double num) {
        System.out.println("Inside superclass calculate method: "+num);
    }
}

class SubAnnotation extends Annotation {
    @Override
    public void calculate(double num) {
        System.out.println("Inside subclass calculate method: "+num);
    }
}
class TestAnnotation {
    public static void main(String[] args) {
        Annotation a1 = new Annotation();
        Annotation a2 = new SubAnnotation();
        SubAnnotation sa = new SubAnnotation();
        SubAnnotation sa2 = new SubAnnotation();
        a1.calculate(5);
        a2.calculate(6);
        sa.calculate(7);
        sa2.calculate(8.0);
    }
}
