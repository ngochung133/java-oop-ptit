import java.util.*;

class Employee{
    String role;
    String heso;
    String sohieu;
    String name;
    public Employee(String name, String role, String heso, String sohieu) {
        this.name = name;
        this.role = role;
        this.heso = heso;
        this.sohieu = sohieu;
    }
    
}

public class j05065{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, ArrayList<Employee>> map = new LinkedHashMap<>();
        int cntGD = 0;
        int cntTP = 0;
        int cntPP = 0;
        for(int i = 1; i <= n; i++){
            String line = sc.nextLine().trim();
            String [] words = line.split("\\s+", 2);
            String code = words[0];
            String name = words[1];
            String role = words[0].substring(0,2);
            String heso = words[0].substring(2,4);
            String sohieu = words[0].substring(4);
            if(role.equals("GD")){
                if(cntGD >= 1){
                    role = "NV";
                }
                cntGD += 1;
            }
            if(role.equals("TP")){
                if(cntTP >= 3){
                    role = "NV";
                }
                cntTP += 1;
            }
            if(role.equals("PP")){
                if(cntPP >= 3){
                    role = "NV";
                }
                cntPP +=1;
            }
            if(!map.containsKey(role)){
                map.put(role,new ArrayList<>());
            }
            map.get(role).add(new Employee(name, role, heso, sohieu));
        }
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 1;i <= m; i++){
            String querry = sc.nextLine();
            if(map.containsKey(querry)){
                ArrayList<Employee> arr = map.get(querry);
                arr.sort(new Comparator<Employee>() {
                    public int compare(Employee a, Employee b){
                        if(a.heso.equals(b.heso)){
                            return a.sohieu.compareTo(b.sohieu);
                        }
                        return b.heso.compareTo(a.heso);
                    }
                });
                for(Employee e : arr){
                    System.out.printf("%s %s %s %s%n", e.name,e.role,e.sohieu,e.heso);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}