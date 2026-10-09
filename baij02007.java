import java.util.*;
public class baij02007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.println("Test " + i + ":");
            int n = sc.nextInt();
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(
                    entry.getKey() + " xuat hien " + entry.getValue() + " lan"
                );
            }
        }
        sc.close();
    }
}