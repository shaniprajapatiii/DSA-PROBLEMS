import java.util.LinkedList;
import java.util.Queue;

public class L81_BalancedBinaryTree {
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int val) {
         this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }

   public boolean isBalanced(TreeNode root) {
      return heightOrUnbalanced(root) != -1;
   }

   private int heightOrUnbalanced(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int leftHeight = heightOrUnbalanced(node.left);
      if (leftHeight == -1) {
         return -1;
      }

      int rightHeight = heightOrUnbalanced(node.right);
      if (rightHeight == -1) {
         return -1;
      }

      if (Math.abs(leftHeight - rightHeight) > 1) {
         return -1;
      }

      return Math.max(leftHeight, rightHeight) + 1;
   }

   private static TreeNode buildTreeFromLevelOrder(Integer[] values) {
      if (values == null || values.length == 0 || values[0] == null) {
         return null;
      }

      TreeNode root = new TreeNode(values[0]);
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      int i = 1;
      while (!queue.isEmpty() && i < values.length) {
         TreeNode current = queue.poll();

         if (i < values.length && values[i] != null) {
            current.left = new TreeNode(values[i]);
            queue.offer(current.left);
         }
         i++;

         if (i < values.length && values[i] != null) {
            current.right = new TreeNode(values[i]);
            queue.offer(current.right);
         }
         i++;
      }

      return root;
   }

   public static void main(String[] args) {
      L81_BalancedBinaryTree solver = new L81_BalancedBinaryTree();

      // Level-order input: null means the child at that position does not exist.
      // balancedInput = [3,9,20,null,null,15,7]
      //        3
      //      /   \
      //     9     20
      //          /  \
      //         15   7
      //
      // unbalancedInput = [1,2,null,3,null,4,null]
      //     1
      //    /
      //   2
      //  /
      // 3
      // /
      //4
      Integer[] balancedInput = {3, 9, 20, null, null, 15, 7};
      Integer[] unbalancedInput = {1, 2, null, 3, null, 4, null};

      TreeNode balanced = buildTreeFromLevelOrder(balancedInput);
      TreeNode unbalanced = buildTreeFromLevelOrder(unbalancedInput);

      System.out.println("Balanced tree: " + solver.isBalanced(balanced));
      System.out.println("Unbalanced tree: " + solver.isBalanced(unbalanced));
   }
}
