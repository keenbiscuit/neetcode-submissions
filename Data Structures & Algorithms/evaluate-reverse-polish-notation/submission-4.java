class Solution {
    public int evalRPN(String[] tokens) {
       // Stack to hold the integers we will operate on
       Stack<Integer> s = new Stack<>();

        // For each string in tokens
        for(String str: tokens)
        { 
            // If the string is an operand
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                // Get operand and the two values for the operation
                String op = str;
                int val2 = s.pop();
                int val1 = s.pop();

                switch(op)
                {
                    case "+": 
                    s.push(val1+val2);
                    
                    break; 


                    case "-": s.push(val1-val2);
                    
                    break;

                    case "*": s.push(val1*val2);
                    
                    break;
                    
                    case "/": s.push(val1/val2);
                    
                    break;
                }
            }
            else
            {
                s.push(Integer.parseInt(str));
            }
        }

        return s.pop();

    }
}
