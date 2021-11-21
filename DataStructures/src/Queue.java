import java.util.LinkedList;
import java.util.Queue;

class QueueBasics {
     public static void main(String[] args) {
         Queue<Integer> queue = new LinkedList<>();
         int ppl = 31;
         int skips = 5;

         for (int i = 1; i <= ppl; i++) {
             queue.add(i);
         }

         while (!queue.isEmpty()) {
             for (int i = 0; i < ppl; i++) {
                 for (int j = 1; j < skips; j++) {
                     queue.add(queue.remove());
                 }
                 System.out.println(queue.remove());
             }
         }
     }
}
