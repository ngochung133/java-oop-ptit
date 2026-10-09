import java.util.*;
public class nvien{
    String id;
    String name;
    String sex;
    String birth;
    String addr;
    String code;
    String date;
    public nvien(String id, String name, String sex, String birth, String addr, String code, String date){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.addr = addr;
        this.code = code;
        this.date = date;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String id = "00001";
        String name = sc.nextLine();
        String sex = sc.nextLine();
        String birth = sc.nextLine();
        String addr = sc.nextLine();
        String code = sc.nextLine();
        String date = sc.nextLine();
        nvien nv = new nvien(id,name,sex,birth,addr,code,date);
        System.out.printf("%s %s %s %s %s %s %s", nv.id,nv.name,nv.sex,nv.birth,nv.addr,nv.code,nv.date);
    }
}