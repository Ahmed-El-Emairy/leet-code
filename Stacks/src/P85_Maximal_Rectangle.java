import HelperFiles.StackObj;

public class P85_Maximal_Rectangle {

    public static void main(String[] args) {
        System.out.print(maximalRectangle(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        }));
    }

    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
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
