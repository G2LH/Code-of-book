package Stack0Queue;

public class SQ_P68_QueueWithTwoStacks {
    public static  void main(String[] args){
        SQueue<Integer> sQueue = new SQueue<>();
        System.out.println(sQueue.poll());
        sQueue.offer(1);
        sQueue.offer(2);
        System.out.println(sQueue.poll());
        sQueue.offer(3);
        System.out.println(sQueue.poll());
        System.out.println(sQueue.poll());
    }
}
