//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1370 👎 0


package thexhc.leetcode;

/**
 * @author thexhc
 * @title 9-回文数
 * @date 2021-01-27 09:34:53
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(2000000096));
    }

    /**
     * @author thexhc
     * @date 2021-01-27 09:34:53
     */
    static class Solution {
        /**
         * 取余法反转整数在比较
         *
         * @author xuhongchun
         * @date 2021/1/27 10:15
         */
        public boolean isPalindrome(int x) {
            int x1 = x;
            if (x < 0) {
                return false;
            }
            if (x % 10 == 0 && x != 0) {
                return false;
            }
            long reverse = 0;
            while (x != 0) {
                reverse = reverse * 10 + x % 10;
                x = x / 10;
            }
            return x1 == reverse;
        }

        /**
         * 去掉尾数为0判断 去掉long
         * int 溢出返回false
         *
         * @author xuhongchun
         * @date 2021/1/27 10:53
         */
        public boolean isPalindrome1(int x) {
            if (x < 0) {
                return false;
            }
            int x1 = x;
            int reverse = 0;
            while (x != 0) {
                reverse = reverse * 10 + x % 10;
                x = x / 10;
            }
            return x1 == reverse;
        }
    }
}