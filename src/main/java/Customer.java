/**
 * Created by Sefa on 23.4.2016.
 */
public class Customer {



    private String name;



    private String terminated;
    private String arrivalTime;
    private String transaction;

    public Customer(String a,String b, String c)
    {
        name=a;
        arrivalTime=b;
        transaction=c;

    }
    public Customer()
    {
        name=null;
        arrivalTime=null;
        transaction=null;

    }
    public String getName()
    {
        return name;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int compareTo(Customer a, Customer b)
    {
        if(a.getName().equals("customer1"))
        {
            if(b.getName().equals("customer1"))
                return 0;
            else
                return 1;
        }
      else  if(a.getName().equals("customer2"))
        {
            if(b.getName().equals("customer1"))
                return -1;
            else if(b.getName().equals("customer2"))
                return 0;
            else return 1;
        }
       else if(a.getName().equals("customer3"))
        {
            if(b.getName().equals("customer3"))
                return 0;
            else
                return -1;
        }

        System.out.println("Wrong Argument. Not compare. It exits -1");
        System.exit(-1);
        return -1;
    }

    public String getTerminated() {
        return terminated;
    }

    public void setTerminated(String terminated) {
        this.terminated = terminated;
    }
}
