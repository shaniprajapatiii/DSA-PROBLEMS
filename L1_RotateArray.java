public class L1_RotateArray {
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateRight(arr, 3);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}