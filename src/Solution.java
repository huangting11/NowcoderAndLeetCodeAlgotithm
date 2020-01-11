import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import sun.security.krb5.internal.PAData;

import java.awt.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
/*        int a$b = 1;
        String a = "a" + "b";
        String b = "ab";
        String c = a + "";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println("ddd".hashCode());
        System.out.println(c==b);
        System.out.println(a==b);*/
//        Pattern pattern = Pattern.compile("[\u4e00 - \u9fa5]");
//        Matcher matcher = pattern.matcher("Hello 你好");
//        while (matcher.find()) {
//            System.out.println(matcher.group(0) + "");
//        }
        int[] nums = new int[]{1,8,7,6,4,9,13};
        int m = 3;
        Solution solution = new Solution();
        solution.splitArray(nums, m);

    }


    public boolean guess(int[] nums, int mid, int m) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                m--;
                sum = nums[i];
                if (nums[i] > mid) {
                    return false;
                }
            } else {
                sum += nums[i];
            }
        }
        return m == 1;
    }

    public int splitArray(int[] nums, int m) {

        int low = 0;
        int high = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            high += nums[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (guess(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode head = pHead;
        ListNode slowNode = pHead;
        ListNode quickNode = pHead;
        while (quickNode.next != null && quickNode.next.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if (slowNode == quickNode) {
                //相交点
                break;
            }
        }
        if (quickNode.next == null || quickNode.next.next == null) {
            return null;
        }
        slowNode = head;
        while (slowNode != quickNode){
            slowNode = slowNode.next;
            quickNode = quickNode.next;
        }
        return slowNode;
    }

    LinkedHashSet<Character> linkedHashSet = new LinkedHashSet();
    HashSet<Character> hashSet = new HashSet();
    public void Insert(char ch) {
        if(!hashSet.contains(ch)) {
            if (linkedHashSet.contains(ch)) {
                linkedHashSet.remove(ch);
                hashSet.add(ch);
            }else {
                linkedHashSet.add(ch);
            }
        }
    }

    public char FirstAppearingOnce() {
        if (linkedHashSet.size() != 0) {
            return linkedHashSet.iterator().next();
        }else {
            return '#';
        }
    }

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length != 0) {
            B[0] = 1;
            for (int i = 1; i < A.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            for (int i = A.length - 2; i >= 0; i--){
                temp *= A[i + 1];
                B[i] *= temp;
            }
        }
        return B;
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++){
            int a = numbers[i] % length;
            if (numbers[a] >= length){
                duplication[0] = a;
                return true;
            }else {
                numbers[a] += length;
            }
        }
        return false;
    }

    public int StrToInt(String str) {
        if (str == null || str.equals("") || str.length() == 0) {
            return 0;
        }
        char[] c = str.toCharArray();
        int fuhao = 0;
        if (c[0] == '-' || c[0] == '+'){
           fuhao = 1;
        }
        double sum = 0;
        for (int i = fuhao; i < c.length; i++) {
            if (c[i] < 48 || c[i] > 57) {
                return 0;
            }else {
                sum = sum * 10 -48 + c[i];

            }
        }
        sum = c[0] == '-' ? sum * -1 : sum;
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) sum;
    }

    public int Add(int num1,int num2) {
        int a = num1 ^ num2;        //异或不同为1，相同为0
        int b = (num1 & num2) << 1;    //与表示进位
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }

    int Sum_Solution(int n) {
        int ans = n;
        boolean c = (ans > 0) && ((ans += Sum_Solution(n - 1)) > 0);
        return ans;
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }

        int index = 0;
        while (arrayList.size() > 1) {
            index = (index + (m - 1)) % arrayList.size();
            arrayList.remove(index);
        }
        return arrayList.get(0);
    }

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int k = 0;
        int m = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                k++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            m += numbers[i + 1] - numbers[i] - 1;
        }

        if (k >= m) {
            return true;
        }
        return false;
    }

    public String ReverseSentence(String str) {
        if (str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            stringBuilder.append(a[i]).append(" ");
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    public String LeftRotateString(String str,int n) {
        if (str.equals("") || str.isEmpty()){
            return str;
        }
        int length = str.length();
        //左移几位数
        int k = n % length;
        String a = str.substring(0, k);
        str = str.substring(k, length);
        return str + a;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int max = Integer.MAX_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (array.length <= 1) {
            return arrayList;
        }
        int left = 0, right = array.length - 1;
        int a = 0, b = 0;
        while (left < right){
            int he = array[left] + array[right];
            if (he == sum) {
                if (array[left] * array[right] < max) {
                    max = array[left] * array[right];
                    a = array[left];
                    b = array[right];
                }
                left++;
                right--;
            }else if (he < sum) {
                left++;
            }else {
                right--;
            }
        }
        if (a != 0 || b != 0){
            arrayList.add(a);
            arrayList.add(b);
        }
        return arrayList;
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        for (int i = (int)Math.sqrt(2 * sum); i >= 2; i--) {
            float a = sum * 2 / (float)i;
            if (a - (int)a != 0) { continue; }
            a = (a + 1 - i) / 2;
            if (a - (int)a != 0) { continue;}
            int b = (int)a;
            ArrayList<Integer> s = new ArrayList<>();
            for (int k = 0; k < i; k ++) {
                s.add(b + k);
            }
            arrayList.add(s);
            //说明可以
        }
        return arrayList;
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[1] = array[1];
        }
        int bitResult = 0;
        for (int i = 0; i < array.length; i++) {
            bitResult ^= array[i];
        }
        int index = finFirst1(bitResult);
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    private int finFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index ++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

/*    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }*/

    public int GetNumberOfK(int [] array , int k) {
        //折半
        if (array.length == 0 || array[0] > k || array[array.length - 1] < k){
            return 0;
        }
        int left = 0;
        int right = array.length;
        int mid = 0;
        while (left <= right){
            mid = (right + left) >> 1;
            if (array[mid] == k){
                break;
            }
            if (array[mid] > k){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        int a = 0;
        right = mid + 1;
        left = mid - 1;
        if (array[mid] == k){
            //前后找
            a += 1;
            while (right < array.length && array[right] == array[mid]){
                right++;
                a++;
            }
            while (left >= 0 && array[left] == array[mid]){
                left--;
                a++;
            }
        }else if (array[mid] > k){
            while (left >= 0 && array[left] >= k){
                if (array[left--] == k){
                    a++;
                }
            }
            //往前找
        }else {
            //往后面找
            while (right < array.length && array[right] <= k){
                if (array[right++] == k){
                    a++;
                }
            }
        }
        return a;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int alen = getLength(pHead1);
        int blen = getLength(pHead2);
        if (alen > blen){
            for (int i = 0; i < alen - blen; i++) {
                pHead1 = pHead1.next;
            }
        }else if (alen < blen){
            for (int i = 0; i < blen - alen; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public int getLength(ListNode listNode){
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairCore(array, copy, 0, array.length - 1);
        return count;
    }

    private int InversePairCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {return 0;}
        int mid = (low + high) >> 1;
        int leftcount = InversePairCore(array, copy, low, mid) % 1000000007;
        int rightcount = InversePairCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;  //mid->low
        int j = high; //high->mid+1
        int loccopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]){
                count += j - mid;
                copy[loccopy--] = array[i--];
                if (count >= 1000000007) {count %= 1000000007;}
            }else {
                copy[loccopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[loccopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[loccopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftcount + rightcount + count) % 1000000007;
    }

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap();
        LinkedHashMap<Character, Integer> linkedHashMap1 = new LinkedHashMap();
        for (int i = 0; i < str.length(); i++) {
            linkedHashMap.put(str.charAt(i), linkedHashMap.getOrDefault(str.charAt(i),0) + 1);
            if (!linkedHashMap1.containsKey(str.charAt(i))){
                linkedHashMap1.put(str.charAt(i), i);
            }
        }
        for (Character a : linkedHashMap.keySet()) {
            if (linkedHashMap.get(a) == 1){
                return linkedHashMap1.get(a);
            }
        }
        return -1;
    }

//    该思路： 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {return 0;}
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        //i2, i3, i5是下标
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index){
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2) {i2++;}
            if (min == m3) {i3++;}
            if (min == m5) {i5++;}
        }
        return list.get(list.size() - 1);
    }

    public String PrintMinNumber(int [] numbers) {
        String[] string = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            string[i] = String.valueOf(numbers[i]);
        }
        //Arrays.sort默认从小到大，需要从大到小则在实现比较器大时候将返回结果乘以-1即可
        Arrays.sort(string, (a,b)->((a+b).compareTo(b+a)));
        StringBuilder stringBuilder = new StringBuilder();
        for (String a : string) {
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        return NumberOf1Between1AndN_Solution(n, 1);
    }

    public int NumberOf1Between1AndN_Solution(int n,int x) {
        if (n < 0 || x < 1 || x > 9) {
            return 0;
        }
        int high, low, curr, tmp, i = 1;
        high = n;
        int total = 0;
        while (high != 0){
            high = n / (int) Math.pow(10, i);   //获取第i位的高位
            tmp = n % (int) Math.pow(10, i);    //余数
            curr = tmp / (int) Math.pow(10, i - 1); //获取第i位的值
            low = tmp % (int) Math.pow(10,i - 1);  //获取第i位的低位数值
            if (curr == x){
                total += high * (int) Math.pow(10, i - 1) + low + 1;
            }else if (curr < x){
                total += high * (int) Math.pow(10, i - 1);
            }else {
                total += (high + 1) * (int) Math.pow(10, i - 1);
            }
            i ++;
        }
        return total;
    }


    public static class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;
         }
     }

    public int MoreThanHalfNum_Solution(int [] array) {
        int lenth = array.length;
        int halfLenth = array.length / 2;
        if (lenth == 1){
            return array[0];
        }
        Arrays.sort(array);
        int a = array[0];
        int num = 1;
        for (int i = 1; i < lenth; i++){
            if (array[i] == a){
                num ++;
                if (num > halfLenth){
                    return a;
                }
            }else {
                a = array[i];
                num = 1;
            }
        }
        return 0;
    }
}