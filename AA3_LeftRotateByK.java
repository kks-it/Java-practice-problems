
// Rotate an array to it's left by K indexes

public class AA3_LeftRotateByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8 , 9};
        int k = 3;

        leftRotateByK(arr, k);

        for(int num: arr){
            System.out.print(num + "\t");
        }
    }

    public static void leftRotateByK(int[] arr, int k){
        k %= arr.length;
        k = k < 0? k + arr.length: k;

        reverse(arr, 0, k -1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int low, int high){
        
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

}
