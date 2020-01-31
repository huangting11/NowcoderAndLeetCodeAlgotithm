package leetcode.排序;

import java.util.*;

/**
 * @Author Huangting
 * @Time 2020/1/19
 */
public class _347_前K个高频元素 {
    public static void main(String[] args) {
        _347_前K个高频元素 _347_ = new _347_前K个高频元素();
        _347_.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
    }

    //小顶堆排序
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numTimes = new HashMap<>();
        for (int a : nums) {
            numTimes.put(a, numTimes.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numTimes.get(o1) - numTimes.get(o2);
            }
        });

        for (Integer a : numTimes.keySet()) {
            priorityQueue.offer(a);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        ArrayList<Integer> topK = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            topK.add(priorityQueue.poll());
        }
        return topK;
    }

    //桶排序
/*    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numTimes = new HashMap<>();
        for (int a : nums) {
            numTimes.put(a, numTimes.getOrDefault(a, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : numTimes.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())){
                topK.addAll(buckets[i]);
            }else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }*/
}
