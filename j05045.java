import java.util.*;
class Employee{
    private String id;
    private String name;
    private String role;
    private long allowance;
    private long basic_salary;
    private long days;
    private long main_salary;
    private long TamUng;
    private long rest;
    public Employee(int order,String name,String role,long days,long basic_salary){
        this.id = String.format("NV%02d",order);
        this.name = name;
        this.role = role;
        this.days = days;
        this.basic_salary = basic_salary;
        this.allowance = cal_allowance(role);
        this.main_salary = basic_salary * days;
        this.TamUng = cal_TamUng(allowance,main_salary);
        this.rest = (main_salary + allowance) - TamUng;
    }
    public long cal_allowance(String s){
        if(s.equals("GD")){
            return 500;
        }
        else if(s.equals("PGD")){
            return 400;
        }
        else if(s.equals("TP")){
            return 300;
        }
        else if(s.equals("KT")){
            return 250;
        }
        else{
            return 100;
        }
    }
    public long cal_TamUng(long p, long s){
        double temp = (p + s) * 2.0 / 3;
        if(temp < 25000){
            return Math.round(temp / 1000.0) * 1000;
        }
        else{
            return 25000;
        }
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public long getAllowance() {
        return allowance;
    }
    public void setAllowance(long allowance) {
        this.allowance = allowance;
    }
    public long getBasic_salary() {
        return basic_salary;
    }
    public void setBasic_salary(long basic_salary) {
        this.basic_salary = basic_salary;
    }
    public long getDays() {
        return days;
    }
    public void setDays(long days) {
        this.days = days;
    }
    public long getMain_salary() {
        return main_salary;
    }
    public void setMain_salary(long main_salary) {
        this.main_salary = main_salary;
    }
    public long getTamUng() {
        return TamUng;
    }
    public void setTamUng(long tamUng) {
        TamUng = tamUng;
    }
    public long getRest() {
        return rest;
    }
    public void setRest(long rest) {
        this.rest = rest;
    }
}
public class j05045{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Employee> a = new ArrayList<>();
        for(int i = 1;i <= n; i++){
            String name = sc.nextLine();
            String role = sc.nextLine();
            long basic_salary = Long.parseLong(sc.nextLine());
            long days = Long.parseLong(sc.nextLine());
            a.add(new Employee(i,name,role,days,basic_salary));
        }
        a.sort(new Comparator<Employee>(){
    public int compare(Employee a, Employee b){
        long incomeA = a.getMain_salary() + a.getAllowance();
        long incomeB = b.getMain_salary() + b.getAllowance();
        
        if (incomeA != incomeB) {
            return Long.compare(incomeB, incomeA); // So sánh thu nhập giảm dần
        }
        return a.getId().compareTo(b.getId()); // Nếu bằng nhau thì mã NV nhỏ hơn xếp trước
    }
});
        for(Employee e : a){
            System.out.printf("%s %s %d %d %d %d%n",e.getId(),e.getName(),e.getAllowance(),e.getMain_salary(),e.getTamUng(),e.getRest());
        }
    }
} 