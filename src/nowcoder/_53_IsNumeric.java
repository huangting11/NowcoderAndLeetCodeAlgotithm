package nowcoder;

/**
 * 表示数值的表达式
 * @author Huangting
 * @date 2020/1/11
 * @time 9:26
 */
public class _53_IsNumeric {
    public static void main(String[] args) {
        _53_IsNumeric isNumeric = new _53_IsNumeric();
        String string = new String("+12e+4");
        isNumeric.isNumeric(string.toCharArray());
    }

    /*字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值
    但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。*/

    /*+-是符号位，只能出现在一次，要么在首字母，要么在e的后一位，其他地方都不能有，且后面必须至少跟一位数字
    e只能出现一次，后面只能接+-整数或者整数，不能再添加.即小数，后面必须有数值
    .只能出现一次，且一定在e前面
    不能有其他非法数字*/

    /*12e说明e的后面必须有数字，不能有两个e
    +-5说明符号位要么出现一次在首位，要么出现一次在e的后一位，其他地方都不能有
    12e4.3说明e的后面不能有小数，1.2.3说明不能有两个小数点
    1a3.14说明不能有其他的非法字符，比如这里的a*/

    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);

        //?匹配单个字符    *零次或多次匹配前面的字符或子表达式
        //"n"匹配字符"n"。"\n"匹配换行符。序列"\\\\"匹配"\\"，"\\("匹配"("。
        System.out.println(new String("1\n").matches("[\\+-]?[\\d]*[\\n]?"));
        System.out.println(new String("dsd32312").matches("[\\+-]?[[0-9] && [a-z]]*"));
        boolean a = string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
        // boolean a = string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
        // boolean a = string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
        System.out.println(a);
        return a;
    }
    /*
    以下对正则进行解释:
    [\\+\\-]?            -> 正或负符号出现与否
    \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
    (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                            否则一起不出现
    ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                            紧接着必须跟着整数；或者整个部分都不出现
    */

/*    private int index = 0;
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        boolean flag = scanInteger(str);
        // 如果出现'.'，接下来是数字的小数部分

        if (index < str.length && str[index] == '.') {
            index++;
            // 下面一行代码用||的原因：
            // 1. 小数可以没有整数部分，例如.123等于0.123；
            // 2. 小数点后面可以没有数字，例如233.等于233.0；
            // 3. 当然小数点前面和后面可以有数字，例如233.666
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            // 下面一行代码用&&的原因：
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            flag = flag && scanInteger(str);
        }
        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return start < index;
    }*/
}
