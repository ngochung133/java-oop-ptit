import java.util.*;
class Time{
    private int hour;
    private int min;
    private int sec;
    public Time(String line){
        String [] arr = line.trim().split("\\s+");
        this.hour = Integer.parseInt(arr[0]);
        this.min = Integer.parseInt(arr[1]);
        this.sec = Integer.parseInt(arr[2]);
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getSec() {
        return sec;
    }
    public void setSec(int sec) {
        this.sec = sec;
    }
}
public class j05033{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Time> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            a.add(new Time(line));
        }
        a.sort(new Comparator<Time>(){
            public int compare(Time a, Time b){
                if(a.getHour() != b.getHour()){
                    return Integer.compare(a.getHour(),b.getHour());
                }
                if(a.getMin() != b.getMin()){
                    return Integer.compare(a.getMin(),b.getMin());
                }
                return Integer.compare(a.getSec(),b.getSec());
            }
        });
        for(Time t : a){
            System.out.printf("%d %d %d%n",t.getHour(),t.getMin(),t.getSec());
        }
    }
}