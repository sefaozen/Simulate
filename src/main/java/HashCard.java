import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Sefa on 29.4.2016.
 */
public class HashCard {

    private Hashtable<Integer,Person> table;
    private List<Person> people;

    public HashCard() throws IOException {

        table=new Hashtable<Integer, Person>(15000);
        people=new ArrayList<Person>();

        int id,student,aca;
        File file = new File("barcode.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        while (line!=null) {
            String[] tokens = line.split("\\s+");
            id=Integer.parseInt(tokens[0]);
            try {
                 student=Integer.parseInt(tokens[1]);
            }
            catch(Exception e) {
                student=0;
            }
            aca=Integer.parseInt(tokens[2]);
            people.add(new Person(id,student,aca));
            table.put(id,new Person(id,student,aca));
            line = reader.readLine();
        }

    }


    public boolean equals(int stu, int aca) {

        if(stu==0)
            return false;
        int index1=0,index2=0;
        for(int i=0;i < people.size();i++)
        {
            if(people.get(i).getStudentNum()==stu)
                index1=people.get(i).getId();
            if (people.get(i).getAcademicNum()==aca)
                index2=people.get(i).getId();
        }
        Person person1= table.get(index1);
        Person person2= table.get(index2);
        if(person1==null ||person2== null)
            return false;
        if(person1.getId()==person2.getId())
        {
            return true;
        }
        else return false;


    }
}
