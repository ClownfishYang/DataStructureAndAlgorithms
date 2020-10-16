package io.clownfishyang.leetcode;

import java.util.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 15:11<br>
 */
public class Brackets {

    /**
     *
     * 功能描述:
     *
     * 使用重复替换 闭合括号对( (),{},[] ) 直到不包含为止，若最后字符串为空则说明有效。
     *
     * @param s
     * @return 是否有效
     * @auther ClownfishYang
     * created on 2020-08-11 15:22:16
     */
    public boolean replaceCheck(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }

    /**
     *
     * 功能描述:
     *
     * 使用栈的特点进行校验，左括号加入对应闭合的右括号到栈顶(push)，右括号时从栈底(pop)取出比较。
     *
     * @param s
     * @return 是否有效
     * @auther ClownfishYang
     * created on 2020-08-11 15:22:16
     */
    public boolean stackCheck(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
        /*Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();*/
    }


    /**
     *
     * 功能描述:
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例：
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 16:31:00
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return Collections.EMPTY_LIST;
        List<String> ans = new LinkedList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == (n << 1)) {
            ans.add(sb.toString());
            return;
        }
        // 如果左括号数量不大于 nn，我们可以放一个左括号。
        if (open < n) {
            sb.append('(');
            backtrack(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 如果右括号数量小于左括号的数量，我们可以放一个右括号。
        if (close < open) {
            sb.append(')');
            backtrack(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     *
     * 功能描述:
     * 任何一个括号序列都一定是由 ( 开头，并且第一个 ( 一定有一个唯一与之对应的 )。
     * 这样一来，每一个括号序列可以用 (a)b 来表示，其中 a 与 b 分别是一个合法的括号序列（可以为空）。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 16:25:23
     */
    ArrayList[] cache = new ArrayList[100];
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            // 遍历 a 与 b 的所有可能性并拼接
            for (int c = 0; c < n; ++c)
                // 计算 a 的所有可能性；
                for (String left: generate(c))
                    // 计算 b 的所有可能性；
                    for (String right: generate(n - 1 - c))
                        // (a)b
                        ans.add("(" + left + ")" + right);
        }
        cache[n] = ans;
        return ans;
    }


}
