import java.util.*;

class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits,
                                         int numberOfProjects, int initialCapital) {
       if(capital == null || capital.length == 0
          || profits == null || profits.length == 0
          || numberOfProjects <= 0
          || capital.length != profits.length
       )
           return initialCapital;
       int length = profits.length;
       int availableCapital = initialCapital;
       PriorityQueue<Integer> minCapital = new PriorityQueue<Integer>(
               (a, b) -> capital[a] - capital[b]
       );
       PriorityQueue<Integer> maxProfit = new PriorityQueue<>(
               (a, b) -> profits[b] - profits[a]
       );
       for(int i = 0; i < length; i++)
           minCapital.offer(i);
       for(int i = 0 ; i < numberOfProjects; i++){

           while(!minCapital.isEmpty() &&
                   capital[minCapital.peek()] <= availableCapital){
               maxProfit.offer(minCapital.poll());
           }
           if(maxProfit.isEmpty())
               break;
           availableCapital += profits[maxProfit.poll()];
       }
       return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}