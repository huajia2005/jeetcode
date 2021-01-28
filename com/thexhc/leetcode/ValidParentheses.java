//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// {{[]()}}
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2119 👎 0


package thexhc.leetcode;

import sun.security.util.Length;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author thexhc
 * @title 20-有效的括号
 * @date 2021-01-27 13:48:50
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid2("{[{}]}"));
    }

    /**
     * @author thexhc
     * @date 2021-01-27 13:48:50
     */
    static class Solution {
        /**
         * 利用栈的后进先出特性
         * 做括号就压进去，有括号就弹出一个元素看看是否相等
         *
         * @author xuhongchun
         * @date 2021/1/27 14:21
         */
        public boolean isValid(String s) {
            Stack<Character> a = new Stack<>();
            int index = -1;
            for (int i = 0; i < s.length(); i++) {
                char aa = s.charAt(i);
                if (aa == '{' || aa == '(' || aa == '[') {
                    a.push(aa);
                    index ++;
                    continue;
                }
                if (aa == '}' || aa == ')' || aa == ']') {
                    if (a.isEmpty()) {
                        return false;
                    }
                    if (a.pop() != getReverse(aa)) {
                        return false;
                    }
                }
            }
            return a.isEmpty();
        }

        /**
         * 利用客栈的后进先出特性
         * 左括号就把对应的有括号压进栈，右括号则弹出看是否相等
         *
         * @author xuhongchun
         * @date 2021/1/27 14:27
         */
        public boolean isValid1(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char charAt = s.charAt(i);
                if (charAt == '{') {
                    stack.push('}');
                    continue;
                }
                if (charAt == '[') {
                    stack.push(']');
                    continue;
                }
                if (charAt == '(') {
                    stack.push(')');
                    continue;
                }
                if (stack.isEmpty() || stack.pop() != charAt) {
                    return false;
                }
            }
            return stack.isEmpty();
        }

        /**
         * 括号都是成对出现
         * 将成对括号替换为空
         *
         * @author xuhongchun
         * @date 2021/1/27 14:45
         */
        public boolean isValid2(String s) {
            int length = s.length()/2;
            for (int i = 0; i < length; i++) {
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
            }
            return s.length() == 0;
        }

        private char getReverse(char ch) {
            if (ch == '}') {
                return '{';
            }
            if (ch == ']') {
                return '[';
            }
            if (ch == ')') {
                return '(';
            }
            return ' ';
        }

    }

}