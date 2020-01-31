import java.util.*;

/**
 * @author Huangting
 * @date 2020/1/9
 * @time 9:47
 */
public class Test {

    public static void main(String[] args) {
         float a = 1.1f;
        System.out.println(a);
        Test t = new Test();
        List<Integer[]> points = new ArrayList();
        points.add(new Integer[]{6,0});
        points.add(new Integer[]{7,4});
        points.add(new Integer[]{5,0});
        points.add(new Integer[]{8,2});

        t.reversePoint(points);
    }

    class Rectangle {
        int x0;
        int x1;
        int y1;
        Rectangle(Integer x0, Integer x1, Integer y1) {
            this.x0 = x0;
            this.x1 = x1;
            this.y1 = y1;
        }
    }

    public List<Integer[]> reversePoint(List<Integer[]> points) {
        //转换成对应的矩形对象之后存储的地方
        List<Rectangle> rectangles = new ArrayList<>();
        //去重复
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        //返回的结果
        List<Integer[]> retPoints = new ArrayList<>();
        //判断传入的是否非空或者只有一个矩形
        if (points == null || points.size() <= 2) {
            return null;
        }

        //将这些坐标转换成矩形对象
        for (int i = 0; i < points.size(); i+=2) {
            rectangles.add(new Rectangle(points.get(i)[0], points.get(i + 1)[0], points.get(i + 1)[1]));
        }
        //省略暴力解法，O（n^2）
        //按x0进行排序,偶数表示是矩形的起点，后面比如 x100 > x1,即左边大于前面的右边就不用比较了，后面的也就不用比较了，可以减少比较
        rectangles.sort(new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                if (o1.x0 < o2.x0) {
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle lef = rectangles.get(i);
            for (int j = i + 1; j < rectangles.size(); j++) {
                Rectangle rig = rectangles.get(j);
                //如果右边矩形的左边界大于左边矩形的有边界，则跳出循环，后面的都不用跟左边矩形进行比较了
                if (rig.x0 > lef.x1) {
                    break;
                }

                //求出相交点
                //包含的情况没有相交点
                if (rig.x0 > lef.x0 && rig.x1 < lef.x1 && rig.y1 < lef.y1) {
                    continue;
                }

                List<Integer[]> a = getIntersectPoints(rig.x0, 0, rig.x1, rig.y1, lef.x0, 0, lef.x1, lef.y1);
                for (Integer[] b : a) {
                    //将相交结果添加到矩形中
                    if (hashMap.containsKey(b[0])) {
                        if (!(hashMap.get(b[0]).contains(b[1]))) {
                            hashMap.get(b[0]).add(b[1]);
                        }
                    } else {
                        HashSet<Integer> hashSet = new HashSet<Integer>();
                        hashSet.add(b[1]);
                        hashMap.put(b[0], hashSet);
                    }
                }
            }
        }

        for(Map.Entry<Integer, HashSet<Integer>> entry: hashMap.entrySet())
        {
            Integer key = entry.getKey();
            for (Integer integer : entry.getValue()) {
                retPoints.add(new Integer[]{key, integer});
            }

        }
        return retPoints;
    }

    private static List<Integer[]> getIntersectPoints(int xa0, int ya0, int xa1, int ya1,
                                                      int xb0, int yb0, int xb1, int yb1) {
        List<Integer[]> ret = new ArrayList<>(2);
        Integer[] point1 = new Integer[2];
        Integer[] point2 = new Integer[2];
        int wa = xa1 - xa0;
        int ha = ya1 - ya0;

        int wb = xb1 - xb0;
        int hb = yb1 - yb0;

        int xa3 = (xa1 + xa0) / 2;
        int ya3 = (ya0 + ya1) / 2;
        int xb3 = (xb1 + xb0) / 2;
        int yb3 = (yb0 + yb1) / 2;

        if (Math.abs(xb3 - xa3) <= wa / 2 + wb / 2 && Math.abs(yb3 - ya3) <= ha / 2 + hb / 2) {
            int xc1 = Math.max(xa0, xb0);
            int xc2 = Math.min(xa1, xb1);
            int yc2 = Math.min(ya1, yb1);

            point1[0] = xc1;
            point1[1] = yc2;
            point2[0] = xc2;
            point2[1] = yc2;

            ret.add(point1);
            ret.add(point2);
        }
        return ret;
    }
}
