public class IntermediateArray {

   public static int[] rotate(int[] nums, int k) {
      
      if(k > nums.length) k = k % nums.length;

      int[] result = new int[nums.length];
      for(int i = 0; i < k; i++) {
         result[i] = nums[nums.length - k + i];
      }

      int j = 0;
      for(int i = k; i < nums.length; i++) {
         result[i] = nums[j];
         j++;
      }
      return result;
   }

   public static void main(String[] args) {
      int [] nums = {1, 2, 3, 4, 5, 6, 7};
      int k = 3;
      int[] rotated = rotate(nums, k);
      for(int x : rotated) {
         System.out.print(x + " ");
      }
   }
}
