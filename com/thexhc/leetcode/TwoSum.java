//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10150 👎 0


package thexhc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @title 1-两数子和
 * @author thexhc
 * @date 2021-01-26 15:54:21
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = solution.twoSum1(new int[]{1, 4, 5, 2, 8}, 10);
        for (int j : a) {
            System.out.println(j);
        }
    }

    /**
     * @author thexhc
     * @date 2021-01-26 15:54:21
     */
    static class Solution {
        /**
         * 暴力破解法
         *
         * @author xuhongchun
         * @date 2021/1/26 16:28
         */
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }

        /**
         * 利用map存放，首先判断target - 当前下标值的值是否在map中
         * 如果存在，则返回，不存在把当前值以及下标存入map
         *
         * @author xuhongchun
         * @date 2021/1/26 16:32
         */
        public int[] twoSum1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(16);
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.containsKey(target - num)) {
                    result[0] = map.get(target - num);
                    result[1] = i;
                    return result;
                }
                map.put(num, i);
            }
            return result;
        }
    }
}