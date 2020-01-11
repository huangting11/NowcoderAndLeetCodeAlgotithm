package nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * @author Huangting
 * @date 2020/1/10
 * @time 14:04
 */
public class _64_MaxInWindows {
    public static void main(String[] args) {
        _64_MaxInWindows maxInWindows = new _64_MaxInWindows();
        maxInWindows.maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3);
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (num == null || num.length < size || size < 1) {
            return arrayList;
        }

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size - 1; i++) {
            while (!linkedList.isEmpty() && num[i] > num[linkedList.getLast()]) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
        }
        for (int i = size - 1; i < num.length; i++) {
            while (!linkedList.isEmpty() && num[i] > num[linkedList.getLast()]) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
            if (i - linkedList.getFirst() > size - 1) {
                linkedList.removeFirst();
            }
            arrayList.add(num[linkedList.getFirst()]);
        }
        return arrayList;
    }
}
