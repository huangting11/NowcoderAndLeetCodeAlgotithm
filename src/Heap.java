import java.util.ArrayList;
import java.util.List;

/**
 * @author Huangting
 * @date 2020/1/10
 * @time 13:50
 */
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(23);
        heap.add(32);
        heap.add(34);
        heap.add(21);
        heap.pop();
        heap.pop();
    }

    public List<Integer> list = null;
    public static final boolean isMaxHeap = true;
    public static final boolean isMinHeap = false;
    private boolean flag = true;  //true表示最大堆，false表示最小堆
    public Heap(){
        this.list = new ArrayList<>();
    }
    public Heap(boolean flag){
        this.list = new ArrayList<Integer>();
        this.flag = flag;
    }
    //获取堆大小
    public int size(){
        return this.list.size();
    }
    //获取堆顶元素
    public int peek(){
        if(list.size() == 0) return 0;
        return list.get(0);
    }
    //插入元素，从插入点开始向上调整堆
    public void add(int val){
        this.list.add(val);
        int i = list.size() - 1, index, parent, cur;
        while(i > 0){
            index = (i - 1) / 2;
            parent = list.get(index);
            cur = list.get(i);
            if(flag == true && parent < cur){
                swap(index, i);
            }else if(flag == false && parent > cur){
                swap(index, i);
            }
            i = index;
        }
    }
    /**
     * 将堆顶元素取出,并重新调整堆。
     * 1>取出堆顶元素
     * 2>将最后一个元素放到堆顶
     * 3>向下调整堆
     */
    public int pop(){
        if(list.size() == 0) return -1;
        int res = list.get(0);
        list.set(0,list.get(list.size() - 1));
        list.remove(list.size()-1);
        int len = list.size() - 1 , i = 0;
        int left , right;
        while(i < len){
            left = (i << 1) + 1;
            right= (i << 1) + 2;
            int maxIndex = i;
            if(flag == true){
                if(left < len && list.get(left) > list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)> list.get(maxIndex)) maxIndex = right;
            }else{
                if(left < len && list.get(left) < list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)< list.get(maxIndex)) maxIndex = right;
            }
            if(maxIndex != i){
                swap(maxIndex,i);
                i = maxIndex;
            }else break;
        }
        return res;
    }
    //交换list中两个位置的元素
    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,temp);
    }
}
