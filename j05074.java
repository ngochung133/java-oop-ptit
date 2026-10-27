import java.util.*;

class Student{
    String id;
    String name;
    String lop;
    String s;
    int score;
    final int diem = 10;
    public Student(String id, String name, String lop){
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.score = cal_score(s);
    }
    public int cal_score(String s){
        int cnt_diemtru = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'v'){
                cnt_diemtru += 2;
            }
            else if(s.charAt(i) == 'm'){
                cnt_diemtru += 1;
            }
            else{
                continue;
            }
        }
        return Math.max(0, diem - cnt_diemtru);
    }
}
public class j05074{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Student> map = new HashMap<>();
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.nextLine();
            Student st = new Student(id, name, lop);
            arr.add(st);
            map.put(id, st);
        }
        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            String [] words = line.trim().split("\\s+");
            String code = words[0];
            String s = words[1];
            Student st = map.get(code);
            st.cal_score(s);
        }
        // Collections.sort(arr, new Comparator<Student>(){
        //     public int compare(Student a, Student b){
        //         return Integer.compare(a.score,b.score);
        //     }
        // });
        for(Student st : arr){
            if(st.score <= 0){
                System.out.printf("%s %s %s %d KDDK%n",st.id,st.name,st.lop,st.score);
            }
            else{
                System.out.printf("%s %s %s %d%n", st.id,st.name,st.lop,st.score);
            }
        }
        sc.close();
    }
}