package leetcode.二分查找;

/**
 * @Author Huangting
 * @Time 2020/1/22
 */
public class _69_x的平方根 {
    public static void main(String[] args) {
        _69_x的平方根 _69_ = new _69_x的平方根();
        _69_.mySqrt(9);
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return sqrt;
            }else if (mid >  sqrt) {
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return h;
    }
}
