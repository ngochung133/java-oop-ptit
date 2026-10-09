import java.util.*;
class  nvien{
    String id;
    String name;
    String sex;
    String birth;
    String addr;
    String code;
    String date;
    public nvien(){
        id = "";
        name = "";
        sex = "";
        birth = "";
        addr = "";
        code = "";
        date = "";
    }
}
public class j05007{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        nvien [] a = new nvien[n];
        for(int i = 0; i < n; i++){
            nvien nv = new nvien();
            nv.id = String.format("%05d", i + 1);
            nv.name = sc.nextLine();
            nv.sex = sc.nextLine();
            nv.birth = sc.nextLine();
            nv.addr = sc.nextLine();
            nv.code = sc.nextLine();
            nv.date = sc.nextLine();
            a[i] = nv;
        }
        Arrays.sort(a, new Comparator<nvien>(){
            public int compare(nvien a, nvien b){
                String [] x = a.birth.split("/");
                String [] y = b.birth.split("/");
                int ngayA = Integer.parseInt(x[0]);
                int thangA = Integer.parseInt(x[1]);
                int namA = Integer.parseInt(x[2]);
                int ngayB = Integer.parseInt(y[0]);
                int thangB = Integer.parseInt(y[1]);
                int namB = Integer.parseInt(y[2]);
                if(ngayA != ngayB){
                    return Integer.compare(namA,namB);
                }
                if(thangA != thangB){
                    return Integer.compare(thangA,thangB);
                }
                return Integer.compare(ngayA,thangB);
            }
        });
        for(nvien nv : a){
            System.out.printf("%s %s %s %s %s %s %s%n", nv.id, nv.name,nv.sex,nv.birth,nv.addr,nv.code,nv.date);
        }
    }
}