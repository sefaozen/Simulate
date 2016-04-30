import static org.junit.Assert.assertEquals;

/**
 * Created by Sefa on 30.4.2016.
 */
public class HashCardTest {

    @org.junit.Test
    public void testEqualsForTrue() throws Exception {

        HashCard hashCard=new HashCard();

        assertEquals(true, hashCard.equals(1790,12660));

    }
    @org.junit.Test
    public void testEqualsForFalse() throws Exception {

        HashCard hashCard=new HashCard();

        assertEquals(false, hashCard.equals(12,10260));

    }
}