class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
    Stack<Integer> stack=new Stack<>();
    ArrayList<Integer> list=new ArrayList<>();
    for(int i=arr.length-1;i>=0;i--)
    {
            while(!stack.isEmpty() && stack.peek()<=arr[i])
              stack.pop();// remove all which are less then current 
            
            if (st.isEmpty()) res[i] = -1;
            // Else top of stack is the answer
            else res[i] = st.peek();
            stack.push(arr[i]);
    }
    Collections.reverse(list);
     return list;   
    }
}
