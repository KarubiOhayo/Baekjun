import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Document {
    int index;
    int priority;

    public  Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Document> queue = new LinkedList<>();

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.offer(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int temp = 0;
            int count = 0;

            while (!queue.isEmpty()) {
                Document current =  queue.poll();
                boolean hasHigher = false;

                for(Document doc: queue) {
                    if(doc.priority >  current.priority) {
                        hasHigher = true;
                        break;
                    }
                }
                if(hasHigher) {
                    queue.offer(current);
                } else {
                    count++;
                    if(current.index == m) break;
                }
            }
            System.out.println(count);
        }
    }
}
