import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

class Department{
    String code;
    String name;
    public Department(String code, String name){
        this.code= code;
        this.name = name;
    }
}

class Employee{
    String name;
    String code;
    long salary;
    int days;
    Department department;
    int heso;
    long sum;
    public Employee(String name, String code, long salary, int days, Department department) {
        this.name = name;
        this.code = code;
        this.salary = salary;
        this.days = days;
        this.department = department;
        this.heso = cal_heso(this.code);
        this.sum = this.salary * this.days * this.heso * 1000;
    }
    public int cal_heso(String s){
        String type = s.substring(0,1);
        int years = Integer.parseInt(s.substring(1,3));
        if(type.equals("A") && years >= 1 && years <= 3) return 10;
         else if(type.equals("A") && years >= 4 && years <= 8) return 12;
         else if(type.equals("A") && years >= 9 && years <= 15) return 14;
         else  if(type.equals("A") && years >= 16) return 20;

         else if(type.equals("B") && years >= 1 && years <= 3) return 10;
         else if(type.equals("B") && years >= 4 && years <= 8) return 11;
         else if(type.equals("B") && years >= 9 && years <= 15) return 13;
         else  if(type.equals("B") && years >= 16) return 16;

        else  if(type.equals("C") && years >= 1 && years <= 3) return 9;
         else if(type.equals("C") && years >= 4 && years <= 8) return 10;
         else if(type.equals("C") && years >= 9 && years <= 15) return 12;
         else  if(type.equals("C") && years >= 16) return 14;

        else  if(type.equals("D") && years >= 1 && years <= 3) return 8;
         else if(type.equals("D") && years >= 4 && years <= 8) return 9;
         else if(type.equals("D") && years >= 9 && years <= 15) return 11;
         else return 13;
    }
    
}

public class j05077{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, Department> map = new LinkedHashMap<>();
        for(int i = 1; i <= n; i++){
            String line = sc.nextLine().trim();
            String [] words = line.split("\\s+", 2);
            String code = words[0];
            String name = words[1];
            map.put(code, new Department(code, name));
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Employee> arr = new ArrayList<>();
        for(int i = 1;i <= m; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            long salary = Long.parseLong(sc.nextLine());
            int days = Integer.parseInt(sc.nextLine());
            String id_department = code.substring(3);
            Department de = map.get(id_department);
            arr.add(new Employee(name,code,salary,days,de));
        }
        for(Employee e : arr){
                System.out.printf("%s %s %s %d%n", e.code,e.name,e.department.name,e.sum);
        }
    } 
}