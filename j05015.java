import java.util.*;

class thisinh {
    static String start = "6:00";
    static int dis = 120;

    String id;
    String name;
    String addr;
    String time;

    public thisinh() {
        id = "";
        name = "";
        addr = "";
        time = "";
    }

    String creat_id() {
        String word = "";

        String[] a = addr.trim().split("\\s+");
        for (int i = 0; i < a.length; i++) {
            word += a[i].charAt(0);
        }

        String[] b = name.trim().split("\\s+");
        for (int i = 0; i < b.length; i++) {
            word += b[i].charAt(0);
        }

        return word;
    }
    int phut(String time) {
    String[] a = time.split(":");

    int h = Integer.parseInt(a[0]);
    int m = Integer.parseInt(a[1]);

    return h * 60 + m;
}
    int vantoc() {
       int ans1 = phut(start);
       int ans2 = phut(time);
        int total = ans2 - ans1;
        return (int)Math.round(120 / (total / 60.0));
    }
}

public class j05015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        thisinh[] a = new thisinh[n];

        for (int i = 0; i < n; i++) {
            thisinh ts = new thisinh();

            ts.name = sc.nextLine().trim();
            ts.addr = sc.nextLine().trim();
            ts.time = sc.nextLine().trim();

            ts.id = ts.creat_id();

            a[i] = ts;
        }

        Arrays.sort(a, new Comparator<thisinh>() {
     
            public int compare(thisinh a, thisinh b) {
                return Integer.compare(a.phut(a.time), b.phut(b.time));
            }
        });

        for (thisinh ts : a) {
            System.out.printf(
                "%s %s %s %d Km/h%n",
                ts.id,
                ts.name,
                ts.addr,
                ts.vantoc()
            );
        }
    }
}