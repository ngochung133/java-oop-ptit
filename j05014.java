import java.util.*;
class teacher{
    String id;
    String name;
    String code;
    double diem1;
    double diem2;
    public teacher(){
        id = "";
        name = "";
        code = "";
        diem1 = 0;
        diem2 = 0;
    }
    String subject(){
        String x = code.substring(0,1);
        if(x.equals("A")){
            return "TOAN";
        }
        else if(x.equals("B")){
            return "LY";
        }
        else{
            return "HOA";
        }
    }
    double tong(){
        double uutien = 0;
        String x = code.substring(1,2);
        if(x.equals("1")){
            uutien = 2.0;
        }
        else if(x.equals("2")){
            uutien = 1.5;
        }
        else if(x.equals("3")){
            uutien = 1.0;
        }
        return diem1 * 2 + diem2 + uutien;
    }
    String trangthai(){
        double total = tong();
        if(total >= 18){
            return "TRUNG TUYEN";
        }
        else{
            return "LOAI";
        }
    }
}
public class j05014{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        teacher [] a = new teacher[n];
        for(int i = 0; i < n; i++){
            teacher tea = new teacher();
            tea.id =String.format("GV%02d", i +1);
            tea.name = sc.nextLine();
            tea.code = sc.nextLine();
            tea.diem1 = Double.parseDouble(sc.nextLine());
            tea.diem2 = Double.parseDouble(sc.nextLine());
            a[i] = tea;
        }
        Arrays.sort(a, new Comparator<teacher>(){
            public int compare(teacher a,teacher b){
                return Double.compare(b.tong(),a.tong());
            }
        });
        for(teacher tea : a){
            System.out.printf("%s %s %s %.1f %s%n",tea.id,tea.name,tea.subject(),tea.tong(),tea.trangthai());
        }
    }
}