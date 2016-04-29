import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 24.4.2016.
 */
public class Simulate {

    private List<Customer> data;


    public Simulate() throws IOException {

        data=new ArrayList<Customer>();

        File file = new File("data1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        line = reader.readLine();
        while (line!=null) {
            int i;
            String[] tokens = line.split("\\s+");
            tokens[2] = tokens[2] + tokens[3];
            for (i = 0; i < data.size(); i++) {
                if (tokens[0].compareTo(data.get(i).getArrivalTime()) == -1)
                    break;
            }
            data.add(i, new Customer(tokens[2], tokens[0], tokens[1]));

            line = reader.readLine();
        }

    }
    public Simulate(List t)
    {
        data=t;

    }
    public Simulate(String fileName) throws IOException {
        data=new ArrayList<Customer>();

        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        line = reader.readLine();
        while (line!=null) {
            int i;
            String[] tokens = line.split("\\s+");
            tokens[2]=tokens[2]+tokens[3];
            for ( i =0; i < data.size(); i++)
            {
                if(tokens[0].compareTo(data.get(i).getArrivalTime())==-1)
                    break;
            }
            data.add(i,new Customer(tokens[2],tokens[0],tokens[1]));

            line = reader.readLine();
        }

    }

    public void runSimulate() throws IOException {

        List<Customer> saved=new ArrayList<Customer>(data);
        PriorityQueue terminal= new PriorityQueue();
        String[] tokens = data.get(0).getArrivalTime().split(":");
        int firstHour=Integer.parseInt(tokens[0]);
        int firstMinute=Integer.parseInt(tokens[1]);

          terminal.add(data.get(0));
        data.remove(0);


        while(terminal.size()!=0) {

            Customer cus=terminal.poll();
//boşsa data kontrolu
            int time=Integer.parseInt(cus.getTransaction());
             tokens = cus.getArrivalTime().split(":");
            int hour=firstHour;
            int minute=firstMinute;
            int resultHour=Integer.parseInt(tokens[0]);
            int resultMinute=Integer.parseInt(tokens[1]);

                for(int ii=0; ii <= time; ii++) {
                    minute++;
                    if(minute==60)
                    {
                        minute=0;
                        hour++;
                    }

                    for(int iii=0; iii < data.size();iii++) {
                            String[] temp =data.get(iii).getArrivalTime().split(":");
                        int temphour=Integer.parseInt(temp[0]);
                        int tempminute=Integer.parseInt(temp[1]);
                        if(temphour==hour && tempminute==minute) {

                            terminal.add(data.get(iii));
                            data.remove(iii);
                        }

                    }

                  //  System.out.println("se");
                }



            firstMinute=firstMinute+time;
            if(firstMinute>=60)
            {
                firstMinute= firstMinute %60;
                firstHour++;
            }
            for(int t=0; t < saved.size(); t++) {
                String[] temp =saved.get(t).getArrivalTime().split(":");
                int temphour=Integer.parseInt(temp[0]);
                int tempminute=Integer.parseInt(temp[1]);
                if(temphour==resultHour && tempminute==resultMinute) {
                    saved.get(t).setTerminated(firstHour + ":" + firstMinute);

                }

            }
            //System.out.println(""+firstHour);

            if (terminal.size()==0)
            {
                if(data.size()!= 0)
                {
                    terminal.add(data.get(0));
                     tokens = data.get(0).getArrivalTime().split(":");
                     firstHour=Integer.parseInt(tokens[0]);
                     firstMinute=Integer.parseInt(tokens[1]);
                    data.remove(0);
                }



            }


        }

        data=saved;

    }


}
