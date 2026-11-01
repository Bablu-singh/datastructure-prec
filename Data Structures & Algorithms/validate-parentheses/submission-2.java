class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> choseToOpen = new HashMap<>();
        choseToOpen.put(')','(');
        choseToOpen.put(']','[');
        choseToOpen.put('}','{');

        for(char c: s.toCharArray()){
            if(choseToOpen.containsKey(c)){
                if(!stack.isEmpty() 
                && stack.peek() == choseToOpen.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
