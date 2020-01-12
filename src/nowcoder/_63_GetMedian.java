import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * @author Huangting
 * @date 2020/1/10
 * @time 11:06
 */
public class _63_GetMedian {

/*    5先进入大顶堆，然后将大顶堆中最大值放入小顶堆中，此时min=[5],max=[无]，avg=[5.00]
    2先进入小顶堆，然后将小顶堆中最小值放入大顶堆中，此时min=[5],max=[2],avg=[(5+2)/2]=[3.50]
    3先进入大顶堆，然后将大顶堆中最大值放入小顶堆中，此时min=[3,5],max=[2],avg=[3.00]
    4先进入小顶堆，然后将小顶堆中最小值放入大顶堆中，此时min=[4,5],max=[3,2],avg=[(4+3)/2]=[3.50]
    1先进入大顶堆，然后将大顶堆中最大值放入小顶堆中，此时min=[3,4,5],max=[2,1]，avg=[3/00]
    6先进入小顶堆，然后将小顶堆中最小值放入大顶堆中，此时min=[4,5,6],max=[3,2,1],avg=[(4+3)/2]=[3.50]
    7先进入大顶堆，然后将大顶堆中最大值放入小顶堆中，此时min=[4,5,6,7],max=[3,2,1],avg=[4]=[4.00]
    0先进入小顶堆，然后将小顶堆中最大值放入小顶堆中，此时min=[4,5,6,7],max=[3,2,1,0],avg=[(4+3)/2]=[3.50]
    8先进入大顶堆，然后将大顶堆中最小值放入大顶堆中，此时min=[4,5,6,7,8],max=[3,2,1,0],avg=[4.00]*/

    public static void main(String[] args) {
        _63_GetMedian getMedian = new _63_GetMedian();
        getMedian.Insert(100);
        System.out.println(getMedian.GetMedian());
        getMedian.Insert(120);
        System.out.println(getMedian.GetMedian());
        getMedian.Insert(103);
        System.out.println(getMedian.GetMedian());
        getMedian.Insert(101);
        System.out.println(getMedian.GetMedian());
        getMedian.Insert(150);
        System.out.println(getMedian.GetMedian());
        getMedian.Insert(120);
        System.out.println(getMedian.GetMedian());
        getMedian.Insert(1021);
        System.out.println(getMedian.GetMedian());
        getMedian.Insert(1033);
        System.out.println(getMedian.GetMedian());
    }

    //默认小顶，前面减后面
    PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
    //大顶堆，后面减去前面
    PriorityQueue<Integer> bigQueue = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));

    //记录偶数个还是奇数个
    int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            bigQueue.offer(num);
            smallQueue.offer(bigQueue.poll());
        }else {
            smallQueue.offer(num);
            bigQueue.offer(smallQueue.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double(smallQueue.peek() + bigQueue.peek()) / 2;
        }else {
            return new Double(smallQueue.peek());
        }
    }
}
