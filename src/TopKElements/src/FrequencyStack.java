/**
 *
 * Design a class that simulates a Stack data structure,
 * implementing the following two operations:
 *
 *     push(int num): Pushes the number ‘num’ on the stack.
 *     pop(): Returns the most frequent number in the stack. If there is a tie,
 *     return the number which was pushed later.
 *
 *     After following push operations:
 *     push(1), push(2), push(3), push(2), push(1), push(2), push(5)
 *
 *     1. pop() should return 2, as it is the most frequent number
 *     2. Next pop() should return 1
 *     3. Next pop() should return 2
 *
 * @author anitgeorge
 */

import java.util.*;

class Element{
    int number;
    int frequency;
    int sequenceNumber;

    Element(int num, int fre, int time){
        number = num;
        frequency = fre;
        sequenceNumber = time;
    }
}


class FrequencyStack {

    Map<Integer, Integer> map;
    PriorityQueue<Element> queue;
    int time;

    FrequencyStack(){
        map = new HashMap<>();
        queue = new PriorityQueue<>(
                (a, b) -> b.frequency == a.frequency ?
                          b.sequenceNumber - a.sequenceNumber :
                          b.frequency - a.frequency
        );
        time = 0;
    }
    public void push(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        queue.offer(new Element(num, map.get(num), ++time));
    }

    public int pop() {
        if(queue.isEmpty())
           return -1;
        Element obj = queue.poll();
        if(obj.frequency > 1)
            map.put(obj.number, obj.frequency - 1);
        else
            map.remove(obj.number);
        return obj.number;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
