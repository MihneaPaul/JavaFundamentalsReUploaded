package interfaces;

/**
 * Created by Mihnea on 26.04.2017.
 */
public interface Choices {
     int YES = 1;
     int NO = 2;
}
class ChoicesTest {
    public static void main(String[] args) {
        System.out.println("Choices.YES = "+Choices.YES);
        System.out.println("Choices.NO = "+Choices.NO);
    }
}
