
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i]) && !stack.isEmpty()) {
                    stack.push(doCalc(stack.pop(), stack.pop(), tokens[i].charAt(0)));
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int doCalc(int a, int b, char operator) {
        int num1 = a;
        int num2 = b;
        switch (operator) {
            case '+': return num2 + num1;
            case '-': return num2 - num1;
            case '*': return num2 * num1;
            case '/': return num2 / num1;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}