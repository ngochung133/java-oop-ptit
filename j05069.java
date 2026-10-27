import java.util.*;

class Club{
    String code;
    String name;
    int price;
    public Club(String code, String name, Int price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

}

class Match{
    Long sum;
    Club club;
    String match_id;
    Int quantity;
    public Match(Club club, String match_id, Int quantity){
        this.club = club;
        this.match_id = match_id;
        this.quantity = quantity;
        this.sum = quantity * club.price;
    }
}

public class j05069{
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
        int m = Integer.pareseInt(sc.nextLine());
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
        for(Match m : arr){
            System.out.printf("%s %s %d%n",m.match_id,m.club.name,m.sum);
        }
        sc.close();
    }
}