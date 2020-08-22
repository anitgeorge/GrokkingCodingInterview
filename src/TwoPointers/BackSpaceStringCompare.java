/**
 *
 * Given two strings S and T, return if they are equal when both are typed
 * into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty
 *
 * @author anitgeorge
 */

class BackSpaceStringCompare {
    public boolean backspaceCompare(String S, String T) {

        if(S.isEmpty())
            return T.isEmpty();
        if(T.isEmpty())
            return false;
        return helper(S).equals(helper(T));
    }

    private String helper(String str){

        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char ch: arr)
            if(ch == '#'){
                if(!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(ch);
        StringBuilder stb = new StringBuilder();
        while(!stack.isEmpty()){
            stb.append(stack.pop());
        }

        return stb.reverse().toString();
    }
}