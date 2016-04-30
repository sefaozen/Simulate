/**
 * Created by Sefa on 29.4.2016.
 */
public class Person  {

    private int id;
    private int studentNum;
    private int academicNum;

    public Person(int a,int b , int c)
    {
        id=a;
        studentNum=b;
        academicNum=c;
    }
    public int getAcademicNum() {
        return academicNum;
    }

    public void setAcademicNum(int academicNum) {
        this.academicNum = academicNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public int hashCode() {

        return getId();
    }
}
