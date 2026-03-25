import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sounds = br.readLine();

        List<String> soundsList = Arrays.stream(sounds.split(" "))
                .collect(Collectors.toCollection(ArrayList::new));
        List<String> sortedList = soundsList.stream().sorted().collect(Collectors.toList());
        List<String> reverseList =  soundsList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        if(soundsList.equals(sortedList)) System.out.println("ascending");
        else if(soundsList.equals(reverseList)) System.out.println("descending");
        else System.out.println("mixed");
    }
}
