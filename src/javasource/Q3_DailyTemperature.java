package javasource;

import java.util.Stack;

/**
 * [73, 74, 75, 71, 69, 72, 76, 73] 의 배열이 있을 경우
 *   1   1   4   2   1   2   0   0 을 구하는 문제
 *   73은 1번 이동하자마자 74가 나와서 자신보다 큰 숫자가 나왔다.
 *   75는 71, 69, 72를 지나 4번만에 76이 나와서 자신보다 큰 숫자가 나왔다.
 */
public class Q3_DailyTemperature {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(nums);

        System.out.println("=======result========");
        for (int i : res) {
            System.out.println(i+ " ");
        }
    }

    private static int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = 0; i < result.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

}
