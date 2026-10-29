import java.util.*;

class Teacher{
    String code;
    String name;
    long salary;
    long allowance;
    int heso;
    long sum;
    public Teacher(String code, String name, long salary){
        this.code = code;
        this.name = name;
        this.salary = salary;
        this.heso = Integer.parseInt(code.substring(2));
        this.allowance = cal_allowance(this.code);
        this.sum = this.salary * heso + this.allowance;
    }
    public long cal_allowance(String s){
        String temp = s.substring(0,2);
        if(temp.equals("HT")) return 2000000;
        else if (temp.equals("HP")) return 900000;
        else return 500000; 
    }
}

public class j05071{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int cnt_head = 0;
        int cnt_pho = 0;
        ArrayList<Teacher> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            long salary = Long.parseLong(sc.nextLine());
            Teacher tea = new Teacher(code,name,salary);
            String temp_code = tea.code.substring(0,2);
            if(temp_code.equals("HT")){
                if(cnt_head >= 1) continue;
                cnt_head++;
            }
            if(temp_code.equals("HP")){
                if(cnt_pho >= 2) continue;
                cnt_pho++;
            }
            arr.add(tea);
        }
        for(Teacher tea : arr){
            System.out.printf("%s %s %d %d %d%n",tea.code, tea.name,tea.heso,tea.allowance,tea.sum);
        }
    }
}