import java.util.*;

class Stu {

    String id;
    String name;
    double diem1;
    double diem2;
    double diem3;

    public Stu(String id, String name, double diem1, double diem2, double diem3) {
        this.id = id;
        this.name = name;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    double uutien() {

        String kv = id.substring(0, 3);

        if (kv.equals("KV1")) {
            return 0.5;
        }
        else if (kv.equals("KV2")) {
            return 1.0;
        }
        else {
            return 2.5;
        }
    }

    double sum() {
        return diem1 * 2 + diem2 + diem3;
    }

    String trangthai() {

        if (sum() + uutien() >= 24) {
            return "TRUNG TUYEN";
        }

        return "TRUOT";
    }

    String format(double x) {

        if (x == (long) x) {
            return String.valueOf((long) x);
        }

        return String.valueOf(x);
    }

    void output() {

        System.out.printf(
            "%s %s %s %s %s%n",
            this.id,
            this.name,
            this.format(uutien()),
            this.format(sum()),
            this.trangthai()
        );
    }
}

public class j04013 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        String name = sc.nextLine();

        double diem1 = Double.parseDouble(sc.nextLine());
        double diem2 = Double.parseDouble(sc.nextLine());
        double diem3 = Double.parseDouble(sc.nextLine());

        Stu sv = new Stu(id, name, diem1, diem2, diem3);

        sv.output();
    }
}