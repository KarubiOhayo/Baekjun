import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);


        String[] a = s.nextLine().split(" ");
        String[] b = s.nextLine().split(" ");
        String[] c = s.nextLine().split(" ");
        List<String> d = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if(a[i].equals(b[i])) d.add(c[i]);
            else if(a[i].equals(c[i])) d.add(b[i]);
            else if(b[i].equals(c[i])) d.add(a[i]);
        }

        String result = String.join(" ", d);
        System.out.println(result);
    }
}
