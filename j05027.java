import java.util.*;
class Teacher{
    private String id;
    private String name;
    private String major;
    public Teacher(int order, String name,String major){
        this.id = String.format("GV%02d",order);
        this.name = name;
        this.major = major;
    }
    public String convert(){
        String [] words = this.major.trim().split("\\s+");
        String s = "";
        for(int i = 0; i < words.length; i++){
            s+= String.valueOf(words[i].charAt(0));
        }
        return s.toUpperCase();
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
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    
}
public class j05027{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Teacher> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            String major = sc.nextLine();
            arr.add(new Teacher(i,name,major));
        }
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 1; i<= m; i++){
            String querry  = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + querry + ":");
            for(Teacher tea : arr){
                String temp = tea.getName().toLowerCase();
                if(temp.contains(querry.toLowerCase())){
                System.out.printf("%s %s %s%n",tea.getId(),tea.getName(),tea.convert());
                }
            }
        }
    }
}