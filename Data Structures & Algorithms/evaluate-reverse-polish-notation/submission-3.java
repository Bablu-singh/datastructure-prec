class Solution {
    public int evalRPN(String[] tokens) {
        Map<String,String> map = new HashMap<>();

        map.put("+","plus");
        map.put("-","minus"); 
        map.put("*","multiply");
        map.put("/","devide");

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String c = tokens[i];
            if(map.containsKey(c)){
                int t2 = stack.pop();
                int t1 = stack.pop();
                switch(map.get(c)){
                    case "plus": stack.push(t1+t2); break;
                    case "minus": stack.push(t1-t2);break;
                    case "multiply": stack.push(t1*t2);break;
                    case "devide": stack.push(t1/t2);break;
                }
            }else{  
                int t = Integer.parseInt(tokens[i]);
                stack.push(t);
            }
            
        }
        if(stack.size()>0){
            return stack.pop();
        }
        return -1;
    }
}
