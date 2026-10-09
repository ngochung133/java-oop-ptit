import java.util.*;
class Teacher{
    private String id;
    private String name;
    private String subject;
    public Teacher(int order, String name,String subject){
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
}
public class j05026{
    static String Code(String smth){
        String [] arr = smth.trim().split("\\s+");
        String s = "";
        for(int i = 0; i < arr.length; i++){
            s += arr[i].charAt(0);
        }
        return s.toUpperCase();
    }
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String , ArrayList<Teacher>> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            String subject = sc.nextLine();
            if(!map.containsKey(subject)){
                map.put(subject, new ArrayList<>());
            }
            map.get(subject).add(new Teacher(i,name,subject));
        }
        int Q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < Q; i++){
            String querry = sc.nextLine();
            String temp = Code(querry);
            System.out.println("DANH SACH GIANG VIEN BO MON " + temp + ":");
            if(map.containsKey(querry)){
                for(Teacher tea : map.get(querry)){
                    System.out.printf("%s %s %s%n", tea.getId(),tea.getName(),Code(tea.getSubject()));
                }
            }
        }
    }
}