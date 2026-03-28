import java.util.LinkedList;
import java.util.Queue;

public class L82_SymmetricTree {
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

   public boolean isSymmetric(TreeNode root) {
      if (root == null) {
         return true;
      }
      return isMirror(root.left, root.right);
   }

   private boolean isMirror(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
         return true;
      }
      if (left == null || right == null) {
         return false;
      }
      if (left.val != right.val) {
         return false;
      }
      return isMirror(left.left, right.right) && isMirror(left.right, right.left);
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
      L82_SymmetricTree solver = new L82_SymmetricTree();

      // Level-order input: null means the child at that position does not exist.
      // symmetricInput = [1,2,2,3,4,4,3]
      //         1
      //      /     \
      //     2       2
      //    / \     / \
      //   3   4   4   3
      //
      // notSymmetricInput = [1,2,2,null,3,null,3]
      //         1
      //      /     \
      //     2       2
      //      \       \
      //       3       3
      Integer[] symmetricInput = {1, 2, 2, 3, 4, 4, 3};
      Integer[] notSymmetricInput = {1, 2, 2, null, 3, null, 3};

      TreeNode symmetric = buildTreeFromLevelOrder(symmetricInput);
      TreeNode notSymmetric = buildTreeFromLevelOrder(notSymmetricInput);

      System.out.println("Symmetric tree: " + solver.isSymmetric(symmetric));
      System.out.println("Not symmetric tree: " + solver.isSymmetric(notSymmetric));
   }
}
