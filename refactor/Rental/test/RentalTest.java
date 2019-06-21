import org.junit.*;
import org.junit.Assert;

public class RentalTest {
    Customer c1;
    Customer c2;
    Customer c3;
    Movie m1;
    Movie m2;
    Movie m3;
    Rental r1;
    Rental r2;
    Rental r3;

    @Before
    public void setUp() throws Exception {
        c1 = new Customer("C1");
        c2 = new Customer("C2");
        c3 = new Customer("C3");
        m1 = new NewReleaseMovie("m1", 1);
        m2 = new ChildMovie("m2", 2);
        m3 = new RegularMovie("m3", 0);
        r1 = new Rental(m1, 2);
        r2 = new Rental(m2, 1);
        r3 = new Rental(m3, 2);
    }

    @After
    public void tearDown() throws Exception {
        // clear resources here
    }

    @Test
    public void testMutipleRental() {
        c1.addRental(r1);
        c1.addRental(r3);
        String statement = c1.statement();
        String[] strs = statement.split("\n");
        Assert.assertEquals("3",strs[strs.length - 1].substring(11, 12));
        Assert.assertEquals("8.0",strs[strs.length - 2].substring(15, 18));
    }

    @Test
    public void testRental() {
        c2.addRental(r2);
        c2.addRental(r1);
        c2.addRental(r3);
        c2.addRental(r2);
        String statement = c2.statement();
        String[] strs = statement.split("\n");
        Assert.assertEquals("5",strs[strs.length - 1].substring(11, 12));
        Assert.assertEquals("11.0",strs[strs.length - 2].substring(15, 19));
    }
}