import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sefa on 30.4.2016.
 */
public class SimulateTest {

    @Test
    public void testRunSimulate() throws Exception {

        Simulate sim=new Simulate("test.txt");

        sim.runSimulate();
        List<Customer> data= sim.getData();
        List<Customer> expected=new ArrayList<Customer>();

        expected.add(new Customer("Customer1","00:00" ,"10"));
        expected.get(0).setTerminated("0:10");
        expected.add(new Customer("Customer3","00:05" ,"11"));
        expected.get(1).setTerminated("0:25");
        expected.add(new Customer("Customer2","00:08" ,"04"));
        expected.get(2).setTerminated("0:14");

        for(int i=0; i < data.size();i++) {

            assertEquals(expected.get(i).getArrivalTime(), data.get(i).getArrivalTime());
            assertEquals(expected.get(i).getName(), data.get(i).getName());
            assertEquals(expected.get(i).getTerminated(), data.get(i).getTerminated());
            assertEquals(expected.get(i).getTransaction(), data.get(i).getTransaction());


        }
    }
}