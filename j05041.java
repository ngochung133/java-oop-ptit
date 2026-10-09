import java.util.*;
class Employee{
    private String id;
    private String name;
    private long salary_day;
    private long days;
    private String role;
    private long salary_month;
    private long reward;
    private long allowance;
    private long salary;
    public Employee(int order, String name, long salary_day,long days,String role){
        this.id = String.format("NV%02d",order);
        this.name = name;
        this.salary_day = salary_day;
        this.days = days;
        this.role =role;
        this.salary_month = days * salary_day;
        this.reward = cal_reward();
        this.allowance = cal_role();
        this.salary = salary_month + reward + allowance;
    }
    public long cal_reward(){
        long temp = 0;
        if(this.days >= 25){
            return temp = Math.round(0.2 * this.salary_month);
        }
        else if(this.days >= 22){
            return temp = Math.round(0.1 * salary_month);
        }
        else{
            return temp = 0;
        }
    }
    public long cal_role(){
        if(this.role.equals("GD")){
             return 250000;
        }
        else if(this.role.equals("PGD")){
            return 200000;
        }
        else if(this.role.equals("TP")){
            return 180000;
        }
        else{
            return 150000;
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
    public long getSalary_day() {
        return salary_day;
    }
    public void setSalary_day(long salary_day) {
        this.salary_day = salary_day;
    }
    public long getDays() {
        return days;
    }
    public void setDays(long days) {
        this.days = days;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public long getSalary_month() {
        return salary_month;
    }
    public void setSalary_month(long salary_month) {
        this.salary_month = salary_month;
    }
    public long getReward() {
        return reward;
    }
    public void setReward(long reward) {
        this.reward = reward;
    }
    public long getAllowance() {
        return allowance;
    }
    public void setAllowance(long allowance) {
        this.allowance = allowance;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    
}
public class j05041{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int  n = Integer.parseInt(sc.nextLine());
        ArrayList<Employee> a = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            long salary_day = Long.parseLong(sc.nextLine());
            long days = Long.parseLong(sc.nextLine());
            String role = sc.nextLine();
            a.add(new Employee(i,name,salary_day,days,role));
        }
        a.sort(new Comparator<Employee>(){
            public int compare(Employee a, Employee b){
                return Long.compare(b.getSalary(), a.getSalary());
            }
        });
        for(Employee e : a){
            System.out.printf("%s %s %d %d %d %d%n",e.getId(),e.getName(),e.getSalary_month(),e.getReward(),e.getAllowance(),e.getSalary());
        }
    }
}