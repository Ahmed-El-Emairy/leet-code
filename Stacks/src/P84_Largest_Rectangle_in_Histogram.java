import HelperFiles.StackObj;

public class P84_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        StackObj stack = new StackObj(heights.length);

        int leftBound;
        int rightBound;
        int area;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[i] < heights[(int) stack.top()]) {
                int poppedIndex = (int) stack.pop();

                leftBound = stack.isEmpty() ? -1 : (int) stack.top();
                rightBound = i;
                area = (rightBound - leftBound - 1) * heights[poppedIndex];
                if (area > maxArea)
                    maxArea = area;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int poppedIndex = (int) stack.pop();

            leftBound = stack.isEmpty() ? -1 : (int) stack.top();
            rightBound = heights.length;
            area = (rightBound - leftBound - 1) * heights[poppedIndex];
            if (area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }
}
