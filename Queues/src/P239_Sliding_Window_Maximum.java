import HelperFiles.QueueObj;
import HelperFiles.StackObj;

public class P239_Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] maximums = new int[nums.length - k + 1];

        QueueObj queue = new QueueObj(nums.length);

        for (int i = 0; i < nums.length; i++) {
            queue.enqueue(nums[i]);
        }

        for (int i = 0; i < maximums.length; i++) {
            int max = (int) queue.dequeue();
            for (int j = 0; j < k - 1; j++) {
                int element = (int) queue.dequeue();
                max = Math.max(max, element);
                queue.enqueue(element);
            }
            maximums[i] = max;
            for (int j = 0; j < nums.length - k - i; j++)
                queue.enqueue(queue.dequeue());
        }

        return maximums;
    }
}
