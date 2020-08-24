/**
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the
 * sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which this
 * process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * @author anitgeorge
 */


class HappyNumber {
    public boolean isHappy(int n) {
        if(n <= 0)
            return false;

        int slow = n, fast = n;
        do{
            slow = helper(slow);
            fast = helper(helper(fast));
        }while(slow != fast);

        return slow == 1;
    }

    private int helper(int n){

        int sum  = 0;
        int temp = 0;
        while(n > 0){
            temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }

        return sum;
    }
}