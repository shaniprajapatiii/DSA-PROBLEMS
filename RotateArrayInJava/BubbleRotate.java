public class BubbleRotate {

   private static void rotate(int[] nums, int order) {

      for(int i = 0; i < order; i++) {
         for(int j = nums.length - 1; j > 0; j--) {
            int temp = nums[j];
            nums[j] = nums[j - 1];
            nums[j - 1] = temp;
         }
      }
   }

   public static void main(String[] args) {
      int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
      int k = 3;
      rotate(nums, k);
      for(int num : nums) {
         System.out.print(num + " ");
      }
   }
}
