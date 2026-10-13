import HelperFiles.StackObj;

public class P42_Trapping_Rain_Water {

    public static StackObj reverseStack(StackObj s) {
        StackObj temp = new StackObj(s.size());

        while (!s.isEmpty())
            temp.push(s.pop());
        return temp;
    }

    public static int getMax(StackObj s) {
        StackObj temp = new StackObj(s.size());
        int max = -1;
        while (!s.isEmpty()) {
            int currentNumber = (int) s.pop();
            if (currentNumber > max)
                max = currentNumber;
            temp.push(currentNumber);
        }
        while (!temp.isEmpty())
            s.push(temp.pop());
        return max;
    }

    public int trap(int[] height) {

        StackObj stack = new StackObj(height.length);

        for (int i = height.length - 1; i >= 0; i--) {
            stack.push(height[i]);
        }

        StackObj tempStack = new StackObj(height.length);

        int max = getMax(stack);
        int totalWater = 0;

        while (!stack.isEmpty()) {
            int currentHeight = (int) stack.pop();

            if (currentHeight == max) {
                stack.push(currentHeight);
                stack = reverseStack(stack);
                currentHeight = (int) stack.pop();
            }

            int movedDistance = 0;
            int sumOfCoveredHeights = 0;
            int gained = 0;
            boolean beReFilled = true;

            while (!stack.isEmpty()) {
                int nextHeight = (int) stack.top();
                if (nextHeight >= currentHeight) {
                    gained = movedDistance * currentHeight - sumOfCoveredHeights;
                    beReFilled = false;
                    break;
                } else {
                    movedDistance++;
                    sumOfCoveredHeights += nextHeight;
                    tempStack.push(stack.pop());
                }
            }
            totalWater += gained;

            if (!beReFilled)
                while (!tempStack.isEmpty())
                    tempStack.pop();

            while (!tempStack.isEmpty())
                stack.push(tempStack.pop());
        }

        return totalWater;
    }
}
