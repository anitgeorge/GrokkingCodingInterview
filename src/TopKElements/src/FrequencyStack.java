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
