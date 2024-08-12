// from the given sorted array no element should appear more than twice
// Without using extra space(extra space can be used to store result) and O(n) time complexity

import java.util.ArrayList;
import java.util.List;

public class AA4_NotMoreThanTwice {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 3, 3, 4, 4, 5, 6, 6, 6, 6, 7, 7, 8 };

        List<Integer> result = notMoreThanTwice(nums);

        for (Integer res : result) {
            System.out.print(res + "\t");
        }

    }

    public static List<Integer> notMoreThanTwice(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int current = nums[0], count = 1;
        result.add(current);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != current) {
                current = nums[i];
                count = 1;
            }

            if (count <= 2) {
                result.add(current);
                count++;
            }
        }

        return result;

    }
}
