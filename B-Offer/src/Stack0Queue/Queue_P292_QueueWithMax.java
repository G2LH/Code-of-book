package Stack0Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//队列的最大值:双端队列 第二个队列中是递减队列 不可以出现递增
public class Queue_P292_QueueWithMax {
    public static class QueueWithMax<T extends Comparable> {
        private  static Queue<Integer> q;
        private  static Deque<Integer> q1;
        public QueueWithMax(){
            this.q = new LinkedList<>();
            this.q1 = new ArrayDeque<>();
        }

        public static int max_value() {
            if(q1.isEmpty()){
                return -1;
            }
            return q1.peek();
        }

        public static void push_back(int value) {
            while(!q1.isEmpty() && value>q1.getLast()){
                q1.removeLast();
            }
            q.offer(value);
            q1.offer(value);
        }

        public static int pop_front() {
            if (q.isEmpty())
                return -1;
            int ans = q.peek();
            if (ans == q1.peek()) {
                q1.poll();
            }
            q.poll();
            return ans;
        }
    }
    public static void main(String[] args) {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
    }
}

