import java.util.*;

class Club{
    String code;
    String name;
    int price;
    public Club(String code, String name, int price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

}

class Match{
    Long sum;
    Club club;
    String match_id;
    int quantity;
    public Match(Club club, String match_id, int quantity){
        this.club = club;
        this.match_id = match_id;
        this.quantity = quantity;
        this.sum = (long) quantity * club.price;
    }
}

public class j05070{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, Club> map = new LinkedHashMap<>();
        for(int i = 1; i <= n; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());
        map.put(code, new Club(code,name,price));
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Match> arr = new ArrayList<>();
        for(int i =  1; i <= m; i++){
            String line = sc.nextLine().trim();
            String [] words = line.split("\\s+",2);
            String code = words[0];
            int quantity = Integer.parseInt(words[1]);
            String club_id = code.substring(1,3);
            Club cl = map.get(club_id);
            arr.add(new Match(cl,code,quantity));
        }
        arr.sort(new Comparator<Match>() {
            public int compare(Match a, Match b){
                if(a.sum == b.sum){
                    return a.club.name.compareTo(b.club.name);
                }
                return Long.compare(b.sum, a.sum);
            }
        });
//         Collections.sort(arr, (a, b) -> {
//     if (a.sum == b.sum) {
//         return a.club.name.compareTo(b.club.name);
//     }
//     return Long.compare(b.sum, a.sum); // Giảm dần theo doanh thu
// });
        for(Match match : arr){
            System.out.printf("%s %s %d%n",match.match_id,match.club.name,match.sum);
        }
        sc.close();
    }
}