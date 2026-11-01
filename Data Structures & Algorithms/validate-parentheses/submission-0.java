class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()){
            if(c=='(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if (!validPara(stack.peek(),c)){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }

    public boolean validPara(Character cin,Character cout){
        return (cin=='(' && cout ==')') ||
        (cin=='[' && cout ==']') ||
        (cin=='{' && cout =='}') ;
    }
}
