import java.util.*;
class customer{
    String id;
    String name;
    String time_in;
    String time_out;
    public customer(){
        id = "";
        name = "";
        time_in = "";
        time_out = "";
    }
    int phutchoi(){
        String [] a = time_in.split(":");
        String [] b = time_out.split(":");
        int giovao = Integer.parseInt(a[0]);
        int phutvao = Integer.parseInt(a[1]);
        int giora = Integer.parseInt(b[0]);
        int phutra = Integer.parseInt(b[1]);
        return giora * 60 + phutra - giovao * 60 - phutvao;
    }
}
public class j05011{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        customer [] a = new customer[n];
        for(int i = 0; i < n; i++){
            customer cus = new customer();
            cus.id = sc.nextLine();
            cus.name = sc.nextLine();
            cus.time_in = sc.nextLine();
            cus.time_out = sc.nextLine();
            a[i] = cus;
        }
        Arrays.sort(a, new Comparator<customer> (){
            public int compare(customer a, customer b){
                return Integer.compare(b.phutchoi(),a.phutchoi());
            }
        });
        for(customer c : a){
            int time = c.phutchoi();
            int hour = time / 60;
            int minutes = time % 60;
            System.out.printf("%s %s %d gio %d phut%n",c.id,c.name,hour,minutes);
        }
    }
}