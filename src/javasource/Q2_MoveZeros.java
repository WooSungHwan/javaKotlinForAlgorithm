package javasource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 배열 num을 감안할 때 0이 아닌 요소의 상대적인 순서를 유지하면서 모든 0을 끝으로 이동시키는 함수를 작성하시오.
 */
public class Q2_MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 0, 8, 5};
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

        print(nums);
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
