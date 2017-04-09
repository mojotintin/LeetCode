package solution;

import java.util.Vector;

/**
 * Created by calabash on 2017/4/7.
 * The leetCode 155th
 */
public class MinStack_155 {

    int min = Integer.MAX_VALUE;
    Vector<Integer> stack = null;
    /** initialize your data structure here. */
    public MinStack_155() {
        stack = new Vector<>();
    }

    public void push(int x) {

        stack.add(x);
    }

    public void pop() {

        stack.remove(stack.size() - 1);
    }

    public int top() {

        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        for (int i = 0; i < stack.size(); i++){
            min = Math.min(min, stack.get(i));
        }
        return min;
    }
}
