import java.util.*;
class svien{
    int id;
    String name;
    String birth;
    double diem1;
    double diem2;
    double diem3;
    public svien(){
        id = 0;
        name = "";
        diem1 = 0;
        diem2 = 0;
        diem3 = 0;
    }
    double tong(){
        return diem1 + diem2 + diem3;
    }
}
public class j05009{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        svien [] a = new svien[n];
        for(int i = 0; i < n ; i++){
            svien sv = new svien();
            sv.id = i + 1;
            sv.name = sc.nextLine();
            sv.birth = sc.nextLine();
            sv.diem1 = Double.parseDouble(sc.nextLine());
            sv.diem2 = Double.parseDouble(sc.nextLine());
            sv.diem3 = Double.parseDouble(sc.nextLine());
            sv.tong();
            a[i] = sv;
        }
        double max = 0;
        for(int i = 0; i < n; i++){
            if(a[i].tong() > max){
                max = a[i].tong();
            }
        }
        for(svien sv : a){
            if(sv.tong() == max){
                System.out.printf("%d %s %s %.1f%n",sv.id,sv.name,sv.birth,sv.tong());
            }
        }
    }
}