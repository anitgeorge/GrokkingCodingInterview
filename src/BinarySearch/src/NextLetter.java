/**
 *
 * Given an array of lowercase letters sorted in ascending order,
 * find the smallest letter in the given array greater than a
 * given ‘key’.
 *
 * Assume the given array is a circular list, which means that
 * the last letter is assumed to be connected with the first letter.
 * This also means that the smallest letter in the given array is
 * greater than the last letter of the array and is also the first
 * letter of the array.
 *
 * Write a function to return the next letter of the given ‘key’.
 *
 * @author anitgeorge
 */

class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
       if(letters == null || letters.length == 0)
           return 'z';
       if(key < letters[0] || key >= letters[letters.length - 1])
           return letters[0];
       int start = 0, end = letters.length - 1, mid = 0;
       while(start < end){

           mid = start + (end - start)/2;
           if(key == letters[mid])
               return letters[mid + 1];
           else if(key < letters[mid]){
               if(key >= letters[mid - 1])
                   return letters[mid];
               else
                   end = mid - 1;
           } else{
               start = mid + 1;
           }
       }
       return letters[0];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
