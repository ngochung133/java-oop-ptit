import java.util.*;

class HocPhan {
    String code;
    String name;
    String group;
    String nameTeacher;

    public HocPhan(String code, String name, String group, String nameTeacher) {
        this.code = code;
        this.name = name;
        this.group = group;
        this.nameTeacher = nameTeacher;
    }
}

public class j05080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LinkedHashMap<String, ArrayList<HocPhan>> map = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String code = sc.nextLine().trim();
            String name = sc.nextLine().trim();
            String group = sc.nextLine().trim();
            String nameTeacher = sc.nextLine().trim();

            if (!map.containsKey(nameTeacher)) {
                map.put(nameTeacher, new ArrayList<>());
            }
            map.get(nameTeacher).add(new HocPhan(code, name, group, nameTeacher));
        }

        int m = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= m; i++) {
            String querry = sc.nextLine().trim();
            if (map.containsKey(querry)) {
                ArrayList<HocPhan> arr = map.get(querry);
                
                arr.sort(new Comparator<HocPhan>() {
                    public int compare(HocPhan a, HocPhan b) {
                        if(a.code.equals(b.code)){
                            return a.group.compareTo(b.group);
                        }
                         return a.code.compareTo(b.code);
                    }
                });
                String nameTea = arr.get(0).nameTeacher;
                System.out.printf("Danh sach cho giang vien %s:%n", nameTea);  
                for (HocPhan p : arr) {
                    System.out.printf("%s %s %s%n", p.code, p.name, p.group);
                }
            }
        }
        sc.close();
    }
}