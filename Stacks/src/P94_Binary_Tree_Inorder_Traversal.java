import java.util.ArrayList;
import java.util.List;

import HelperFiles.StackObj;
import HelperFiles.TreeNode;

public class P94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        StackObj stack = new StackObj(1000);
        List<Integer> answer = new ArrayList<Integer>();
        inorderTraversalHelper(root, stack, answer);
        return answer;
    }

    public List<Integer> inorderTraversalHelper(TreeNode root, StackObj stack, List<Integer> answer) {

        if (root == null)
            return answer;

        if (root.left == null)
            answer.add(root.val);
        else {
            stack.push(root.val);
            inorderTraversalHelper(root.left, stack, answer);
            answer.add((int) stack.pop());
        }
        if (root.right == null) {
            return answer;
        }
        inorderTraversalHelper(root.right, stack, answer);
        return answer;
    }
}
