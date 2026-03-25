import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        Map<Integer, Integer> frequency = new TreeMap<>();
        int count = 1;

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
            if(!frequency.containsKey(numbers.get(i))){
                frequency.put(numbers.get(i), 1);
            } else {
                frequency.put(numbers.get(i), frequency.get(numbers.get(i)) + 1);
            }
        }

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(Math.round((double) sum / numbers.size()));

        Collections.sort(numbers);
        System.out.println(numbers.get(numbers.size() / 2));

        int maxValue = Collections.max(frequency.values());
        List<Integer> maxKeys = frequency.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if(maxKeys.size() > 1) System.out.println(maxKeys.get(1));
        else System.out.println(maxKeys.get(0));

        int range = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) - numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
        System.out.println(range);
    }
}
