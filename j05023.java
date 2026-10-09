import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String lop;
    private String email;

    public SinhVien(String id, String name, String lop, String email) {
        this.id = id.trim();
        this.name = name.trim();
        this.lop = lop.trim();
        this.email = email.trim();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLop() {
        return lop;
    }

    public String getEmail() {
        return email;
    }

    // Lấy năm khóa học
    public String getKhoa() {
        return "20" + id.substring(1, 3);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + email;
    }
}

public class J05023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        ArrayList<SinhVien> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            list.add(new SinhVien(id, name, lop, email));
        }

        int q = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < q; i++) {
            String querry = sc.nextLine().trim();
            System.out.println("DANH SACH SINH VIEN KHOA " + querry + ":");

            for (SinhVien sv : list) {
                if (sv.getKhoa().equals(querry)) {
                    System.out.println(sv);
                }
            }
        }

        sc.close();
    }
}