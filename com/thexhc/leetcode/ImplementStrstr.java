//实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 686 👎 0


package thexhc.leetcode;

import sun.security.util.Length;

/**
 * TODO kmp算法实现，暂未通过
 *
 * @author thexhc
 * @title 28-实现 strStr()
 * @date 2021-01-27 16:26:02
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("mississippi", "issipi"));
        System.out.println("mississippi".indexOf("issip"));
    }

    /**
     * @author thexhc
     * @date 2021-01-27 16:26:02
     */
    static class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) {
                return 0;
            }
            int j = 0;
            int num = 0;
            int index = 0;
            for (int i = 0; i < haystack.length();i++) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    if (haystack.charAt(i) == needle.charAt(0)) {
                        index = i;
                        num ++;
                    }
                    if (j == needle.length()-1) {
                        return i-j;
                    }
                    j ++;
                } else {
                    j = 0;
                    if (num > 1) {
                        i = index-1;
                        num = 1;
                    }
                }
            }
            return -1;
        }
    }

}