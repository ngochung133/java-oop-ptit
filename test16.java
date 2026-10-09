import java.util.*;

public class test16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] a = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
        }

        // Sàng nguyên tố
        boolean[] prime = new boolean[max + 1];

        Arrays.fill(prime, true);

        prime[0] = false;
        if (max >= 1) {
            prime[1] = false;
        }

        for (int i = 2; i * i <= max; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    prime[j] = false;
                }
            }
        }

        long sum = 0;

        // Phân tích từng số
        for (int n : a) {
            for (int p = 2; p * p <= n; p++) {

                if (prime[p]) {
                    while (n % p == 0) {
                        sum += p;
                        n /= p;
                    }
                }
            }

            // n còn lại là số nguyên tố
            if (n > 1) {
                sum += n;
            }
        }

        System.out.println(sum);
    }
}