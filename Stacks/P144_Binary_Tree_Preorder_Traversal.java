package HelperFiles;

import java.util.ArrayList;
import java.util.List;

public class P144_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        StackObj stack = new StackObj(100);
        stack.push(root);
        List<Integer> answer = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode crr = (TreeNode) stack.pop();
            while (crr != null) {
                answer.add(crr.val);
                if (crr.right != null)
                    stack.push(crr.right);
                crr = crr.left;
            }
        }

        return answer;
    }
}
