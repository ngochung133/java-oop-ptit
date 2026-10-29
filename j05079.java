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

public class j05079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LinkedHashMap<String, ArrayList<HocPhan>> map = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String code = sc.nextLine().trim();
            String name = sc.nextLine().trim();
            String group = sc.nextLine().trim();
            String nameTeacher = sc.nextLine().trim();

            if (!map.containsKey(code)) {
                map.put(code, new ArrayList<>());
            }
            // SỬA: Dùng key 'code' thay vì 'nameTeacher'
            map.get(code).add(new HocPhan(code, name, group, nameTeacher));
        }

        int m = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= m; i++) {
            String querry = sc.nextLine().trim();
            if (map.containsKey(querry)) {
                ArrayList<HocPhan> arr = map.get(querry);
                
                // Sắp xếp nhóm lớp theo thứ tự tăng dần
                arr.sort(new Comparator<HocPhan>() {
                    public int compare(HocPhan a, HocPhan b) {
                        return a.group.compareTo(b.group);
                    }
                });

                String nameSub = arr.get(0).name;
                // SỬA: Thêm %n để xuống dòng sau tiêu đề
                System.out.printf("Danh sach nhom lop mon %s:%n", nameSub);
                
                // SỬA: In ra p.nameTeacher thay vì p.name
                for (HocPhan p : arr) {
                    System.out.printf("%s %s%n", p.group, p.nameTeacher);
                }
            }
        }
        sc.close();
    }
}