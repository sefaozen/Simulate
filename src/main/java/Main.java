import java.io.IOException;

/**
 * Created by Sefa on 24.4.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Simulate sim=new Simulate("data1.txt");

        sim.runSimulate();


        HashCard hashCard=new HashCard();

       if( hashCard.equals(1792,11360))
           System.out.println("\nTwo cards belongs to the same asistant");
        else
           System.out.println("\nTwo cards belongs to the different asistant");


    }
}
