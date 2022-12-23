import java.util.Scanner;

public class Main {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Originator originator = new Originator(in);
        originator.mainDisplay();
        in.close();
        
                
    }
}
