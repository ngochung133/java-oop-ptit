import java.util.*;
class Teacher{
    private String id;
    private String name;
    private String subject;
    public Teacher(int order,String name,String subject){
        this.id = String.format("GV%02d",order);
        this.name = name;
        this.subject = subject;
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
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String LastName(){
        String [] arr = this.getName().trim().split("\\s+");
        return arr[arr.length - 1];
    }
    public String CodeSubject(){
        String [] arr = this.getSubject().trim().split("\\s+");
        String s = "";
        for(int i = 0; i < arr.length;i++){
            s +=  arr[i].charAt(0);
        }
        return s.toUpperCase();
    }
}
public class j05025{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Teacher> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String subject = sc.nextLine();
            a.add(new Teacher(i + 1,name,subject));
        }
        a.sort(new Comparator<Teacher>(){
            public int compare(Teacher a, Teacher b){
                if(a.LastName().equals(b.LastName())){
                    return a.getId().compareTo(b.getId());
                }
                return a.LastName().compareTo(b.LastName());
            }
        });
        for(Teacher tea : a){
            System.out.printf("%s %s %s%n",tea.getId(),tea.getName(),tea.CodeSubject());
        }
    }
}