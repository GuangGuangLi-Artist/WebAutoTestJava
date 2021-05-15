package day18.JDbcUtilsLearn;

public class StuDay18 {
    private int sid;
    private  int age;
    private String sname;
    private String gender;

    public StuDay18(int sid, int age, String sname, String gender) {
        this.sid = sid;
        this.age = age;
        this.sname = sname;
        this.gender = gender;
    }

    public StuDay18() {
    }

    @Override
    public String toString() {
        return "StuDay18{" +
                "sid=" + sid +
                ", age=" + age +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getsname() {
        return sname;
    }

    public void setsname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
