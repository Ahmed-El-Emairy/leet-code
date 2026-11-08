
import HelperFiles.StackObj;
import HelperFiles.TreeNode;

public class P114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        StackObj stack = new StackObj(2000);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = (TreeNode) stack.pop();
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
            if (!stack.isEmpty())
                curr.right = (TreeNode) stack.top();
            curr.left = null;
        }
    }
}
