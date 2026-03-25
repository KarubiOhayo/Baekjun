import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");

            switch (split[0]) {
                case "push":
                    queue.offer(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    if (!queue.isEmpty()) System.out.println(queue.poll());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if (!queue.isEmpty()) System.out.println(queue.peek());
                    else System.out.println(-1);
                    break;
                default: // "back"
                    if (!queue.isEmpty()) System.out.println(((LinkedList<Integer>) queue).getLast());
                    else System.out.println(-1);
            }
        }
    }
}
