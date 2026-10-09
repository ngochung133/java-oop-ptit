import java.util.*;
class nvien{
    String id;
    String name;
    double diem1;
    double diem2;
    public nvien(){
        id = "";
        name = "";
        diem1 = 0;
        diem2 = 0;
    }
    void checkdiem(){
        if(diem1 > 10){
            diem1 = diem1 / 10;
        }
        if(diem2 >10){
            diem2 = diem2 / 10;
        }
    }
    String trangthai(){
        double tong = (diem1 + diem2) / 2;
        if(tong > 9.5){
            return "XUAT SAC";
        }
        else if(tong >= 8 && tong <= 9.5){
            return "DAT";
        }
        else if(tong > 5 && tong < 8){
            return "CAN NHAC";
        }
        else{
            return "TRUOT";
        }
    }
}
public class j05013{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        nvien [] a = new nvien[n];
        for(int i = 0; i < n; i++){
            nvien nv = new nvien();
            nv.id = String.format("TS%02d",i + 1);
            nv.name = sc.nextLine();
            nv.diem1 = Double.parseDouble(sc.nextLine());
            nv.diem2 = Double.parseDouble(sc.nextLine());
            nv.checkdiem();
            a[i] = nv;
        }
        Arrays.sort(a, new Comparator<nvien>(){
            public int compare(nvien a,nvien b){
                return Double.compare((b.diem1 + b.diem2) / 2,(a.diem1 + a.diem2) / 2);
            }
        });
        for(nvien nv : a){
            System.out.printf("%s %s %.2f %s%n",nv.id,nv.name,(nv.diem1 + nv.diem2) / 2,nv.trangthai());
        }
    }
}