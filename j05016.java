import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.*;
class customer{
    private String id;
    private String name;
    private String room;
    private String date_in;
    private String date_out;
    private int extra;
    public customer(String id, String name,String room,String date_in,String date_out,int extra){
        this.id = id;
        this.name = name;
        this.room = room;
        this.date_in = date_in;
        this.date_out = date_out;
        this.extra = extra;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public String getDate_in() {
        return date_in;
    }
    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }
    public String getDate_out() {
        return date_out;
    }
    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }
    public int getExtra() {
        return extra;
    }
    public void setExtra(int extra) {
        this.extra = extra;
    }
    int price_room(){
        char r = getRoom().charAt(0);
        if(r == '1'){
            return 25;
        }
        else if(r == '2'){
            return 34;
        }
        else if(r == '3'){
            return 50;
        }
        else{
            return 80;
        }
    }
    long getLong(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateIn = LocalDate.parse(getDate_in().trim(),formatter);
        LocalDate dateOut = LocalDate.parse(getDate_out().trim(),formatter);
        long songay = ChronoUnit.DAYS.between(dateIn,dateOut) + 1;
        return songay;
    }
    long getMoney(){
        return getLong() * price_room() + getExtra();
    }
}
public class j05016{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<customer> a = new ArrayList<>();
        for(int i = 0 ;i < n; i++){
            String id = String.format("KH%02d",i + 1);
            String name = sc.nextLine();
            String room = sc.nextLine();
            String date_in = sc.nextLine();
            String date_out = sc.nextLine();
            int extra = sc.nextInt();
            if(i < n - 1){
                sc.nextLine();
            }
           customer c = new customer(id,name,room,date_in,date_out,extra);
           a.add(c);
        }
        a.sort(new Comparator<customer>(){
            public int compare(customer c1, customer c2){
                return Long.compare(c2.getMoney(),c1.getMoney());
            }
        });
        for(customer c : a){
            System.out.printf("%s %s %s %d %d%n",c.getId(),c.getName(),c.getRoom(),c.getLong(),c.getMoney());
        }
    }
}