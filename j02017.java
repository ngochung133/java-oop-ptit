import java.util.*;
public class j02017{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack <>();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(!st.isEmpty() && (st.peek() + x) % 2 == 0){
                st.pop();
            }
            else{
                st.push(x);
            }
        }
        System.out.println(st.size());
        sc.close();
    }
}