import java.util.*;
class People{
    private String name;
    private int ngay,thang,nam;
    public People(String line){
        String [] arr = line.trim().split("\\s+");
        this.name = arr[0];
        String [] date = arr[1].split("/");
        this.ngay = Integer.parseInt(date[0]);
        this.thang = Integer.parseInt(date[1]);
        this.nam = Integer.parseInt(date[2]);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNgay() {
        return ngay;
    }
    public void setNgay(int ngay) {
        this.ngay = ngay;
    }
    public int getThang() {
        return thang;
    }
    public void setThang(int thang) {
        this.thang = thang;
    }
    public int getNam() {
        return nam;
    }
    public void setNam(int nam) {
        this.nam = nam;
    }
}
public class j05032{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<People> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            a.add(new People(line));
        }
        a.sort(new Comparator<People>(){
            public int compare(People a, People b){
                if(a.getNam() != b.getNam()){
                    return Integer.compare(a.getNam(),b.getNam());
                }
                if(a.getThang() != b.getThang()){
                    return Integer.compare(a.getThang(),b.getThang());
                }
                return Integer.compare(a.getNgay(), b.getNgay());
            }
        });
        System.out.println(a.get(a.size() - 1).getName());
        System.out.println(a.get(0).getName());
    }
}