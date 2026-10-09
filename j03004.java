import java.util.*;
public class j03004{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine();
            while(t-- >0){
                String s = sc.nextLine();
                s = s.trim();
                String [] word = s.split("\\s+");
                String name = "";
                for(String x : word){
                    name += Character.toUpperCase(x.charAt(0));
                    for(int i = 1; i < x.length();i++){
                        name += Character.toLowerCase(x.charAt(i));
                    }
                    name += " ";
                }
                System.out.print(name.trim());
                System.out.println();
            }
        }
    }
