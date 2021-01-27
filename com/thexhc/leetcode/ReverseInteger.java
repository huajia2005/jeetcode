//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// 👍 2486 👎 0


package thexhc.leetcode;

/**
 * @author thexhc
 * @title 7-整数反转
 * @date 2021-01-26 16:41:23
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 1568123825;
        System.out.println(solution.reverse1(x));
    }

    /**
     * @author thexhc
     * @date 2021-01-26 16:41:23
     */
    static class Solution {
        /**
         * 转为字符串然后截取判断，在反转
         * 效率较差，应该有更好的方法，暂时先通过
         *
         * @author thexhc
         * @date 2021-01-26 16:41:23
         */
        public int reverse(int x) {
            if (0 == x) {
                return 0;
            }
            String str = String.valueOf(x);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                char charAt = str.charAt(i);
                if (i == 0) {
                    if (charAt == '-') {
                        stringBuilder.insert(0, charAt);
                        continue;
                    }
                }
                if (charAt == '0' && stringBuilder.length()==0) {
                    continue;
                }
                stringBuilder.append(charAt);
            }
            int result;
            try {
                result = Integer.parseInt(stringBuilder.toString());
            } catch (NumberFormatException e) {
                result = 0;
            }
            return result;
        }

        /**
         * 数学取余(判断是否溢出使用long有取巧成分)
         *
         *
         * @author xuhongchun
         * @date 2021/1/27 08:52
         */
        public int reverse1(int x) {
            long result = 0L;
            while (x != 0) {
                result = result*10 + x%10;
                x = x/10;
            }
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            return (int)result;
        }
    }

}