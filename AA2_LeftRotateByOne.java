// Rotate all elements of an array to their left by index 1

public class AA2_LeftRotateByOne {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 7 };

        leftRotateArrayByOne(arr);
        for (Integer num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void leftRotateArrayByOne(int[] arr) {
        if (arr.length == 0)
            return;

        int firstElement = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = firstElement;
    }

}
