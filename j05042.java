import java.util.*;
class Student{
    private String name;
    private int correct;
    private int total;
    public Student(String name,int c,int t){
        this.name = name;
        this.correct = c;
        this.total = t;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCorrect() {
        return correct;
    }
    public void setCorrect(int correct) {
        this.correct = correct;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
public class j05042{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String [] s = sc.nextLine().trim().split("\\s+");
            int correct = Integer.parseInt(s[0]);
            int total = Integer.parseInt(s[1]);
            a.add(new Student(name,correct,total));
        }
        a.sort(new Comparator<Student>(){
            public int compare(Student a, Student b){
                if(a.getCorrect() == b.getCorrect()){
                    if(a.getTotal() == b.getTotal()){
                        return a.getName().compareTo(b.getName());
                    }
                    return Integer.compare(a.getTotal(),b.getTotal());
                }
                return Integer.compare(b.getCorrect(),a.getCorrect());
            }
        });
        for(Student sv : a){
            System.out.printf("%s %d %d%n",sv.getName(),sv.getCorrect(),sv.getTotal());
        }
    }
}