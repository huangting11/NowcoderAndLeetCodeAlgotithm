package leetcode.分治;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/24
 */
public class _241_为运算表达式设计优先级 {
    public static void main(String[] args) {
        _241_为运算表达式设计优先级 _241_ = new _241_为运算表达式设计优先级();
        _241_.diffWaysToCompute("2-1-1");
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftIntegers = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightIntegers = diffWaysToCompute(input.substring(i + 1));
                for (int l : leftIntegers) {
                    for (int r : rightIntegers) {
                        switch (c) {
                            case '+':
                                integers.add(l + r);
                                break;
                            case '-':
                                integers.add(l - r);
                                break;
                            case '*':
                                integers.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (integers.size() == 0) {
            integers.add(Integer.valueOf(input));
        }
        return integers;
    }
}
