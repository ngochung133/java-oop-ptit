import java.util.*;
class gvien{
    String id;
    String name;
    long luongcoban;
    public gvien(String id, String name, long luongcoban){
        this.id = id;
        this.name = name;
        this.luongcoban = luongcoban;
    }
    long phucap(){
        if(this.id.substring(0,2).equals("HT")){
            return 2000000;
        }
        else if(this.id.substring(0,2).equals("HP")){
            return 900000;
        }
        else{
            return 500000;
        }
    }
    int bacluong(){
        String s = this.id.substring(2);
        return Integer.parseInt(s);
    }
    long thunhap(){
        int a = bacluong();
        return luongcoban * a + phucap();
    }
}
    public class j04015{
        public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            String name = sc.nextLine();
            long luong = sc.nextLong();
            gvien gv = new gvien(id,name,luong);
            System.out.printf("%s %s %d %d %d%n",gv.id, gv.name,gv.bacluong(),gv.phucap(),gv.thunhap());
        }
    }
