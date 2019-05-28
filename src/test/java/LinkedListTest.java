import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhwanwan
 * @create 2019-05-29 4:25 AM
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);

        System.out.println(deque.pop() + ", " + deque);
        System.out.println(deque.pop() + ", " + deque);
        System.out.println(deque.pop() + ", " + deque);
        System.out.println(deque.pop() + ", " + deque);
    }
}
