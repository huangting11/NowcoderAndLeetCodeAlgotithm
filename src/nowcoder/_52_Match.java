package nowcoder;

/**
 * 正则表达式匹配
 * @author Huangting
 * @date 2020/1/11
 * @time 14:05
 */
public class _52_Match {
    ///模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
    // 字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
    public static void main(String[] args) {
        _52_Match match = new _52_Match();
        match.match(new char[]{'a','a','a'}, new char[]{'a','.','*','a','c','*','a'});
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //两个都到尾部了，模式匹配成功
        if (strIndex == str.length && pattern.length == patternIndex) {
            return true;
        }
        //pattern先到尾部,匹配的还没到。模式匹配失败
        if (pattern.length == patternIndex && strIndex < str.length) {
            return false;
        }
        //模式第二个是*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //字符串第一个跟模式第一个匹配
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                //1、模式后移两位，视为x*匹配0个字符，
                //2、字符串后移1位，模式后移两位，匹配一个字符
                //3、字符串后移1位，模式不后移，匹配一个，继续匹配后面的
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            }else {
                //匹配不上，这里模式后移两位，跟后面的继续匹配
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        //模式第二个不是*,且字符串第一个跟模式第一个匹配，则都后移两位，否则直接返回false
        if (strIndex != str.length && (pattern[patternIndex] == '.' || pattern[patternIndex] == str[strIndex])) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
