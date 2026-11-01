class Solution {
    public int evalRPN(String[] tokens) {
        Map<String, String> map = new HashMap<>();
        map.put("+", "plus");
        map.put("-", "minus");
        map.put("*", "multiply");
        map.put("/", "divide");

        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (map.containsKey(c)) {
                int t2 = stack.pop(); // right
                int t1 = stack.pop(); // left

                switch (map.get(c)) {
                    case "plus":     stack.push(t1 + t2); break;
                    case "minus":    stack.push(t1 - t2); break;
                    case "multiply": stack.push(t1 * t2); break;
                    case "divide":   stack.push(t1 / t2); break;
                }
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }
}