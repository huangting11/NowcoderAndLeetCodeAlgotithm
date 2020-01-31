package leetcode.双指针;

import javax.lang.model.type.ArrayType;

/**
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,4,5,6,0};
        int[] num2 = new int[]{3};
        _88_合并两个有序数组 _88_ = new _88_合并两个有序数组();
        _88_.merge(num1, 5, num2, 1);
    }


    //从最后一个开始
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = m - 1;
//        int j = n - 1;
//        int indexMerge = m + n - 1;
//        while (i >= 0 || j >= 0) {
//            if (i < 0) {
//                nums1[indexMerge--] = nums2[j--];
//            }else if (j < 0) {
//                nums1[indexMerge--] = nums1[i--];
//            }else if (nums1[i] < nums2[j]) {
//                nums1[indexMerge--] = nums2[j--];
//            }else {
//                nums1[indexMerge--] = nums1[i--];
//            }
//        }
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int i = n;
        int j = 0;
        int index = 0;
        while (i < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[index++] = nums1[i++];
            }else {
                nums1[index++] = nums2[j++];
            }
        }
        if (i == m + n) {
            for (; j < n; j++) {
                nums1[index++] = nums2[j];
            }
        }
    }
}
