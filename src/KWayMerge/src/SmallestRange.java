/**
 *
 * Given ‘M’ sorted arrays, find the smallest range that
 * includes at least one number from each of the ‘M’ lists.
 *
 * Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
 * Output: [4, 7]
 * Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
 *
 * @author anitgeorge
 */

import java.util.*;

class Element{
    int aIdx;
    int eIdx;

    Element(int a, int b){
        aIdx = a;
        eIdx = b;
    }
}

class SmallestRange {

    public static int[] findSmallestRange(List<Integer[]> list) {
        if(list.isEmpty())
            return new int[] { -1, -1 };

        PriorityQueue<Element> queue = new PriorityQueue<>(
                (a, b)-> list.get(a.aIdx)[a.eIdx] - list.get(b.aIdx)[b.eIdx]
        );
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            queue.offer(new Element(i, 0));
            max = Math.max(max, list.get(i)[0]);
        }

        while(queue.size() == list.size()){
            Element ele = queue.poll();
            if(end - start > max - list.get(ele.aIdx)[ele.eIdx]){
                start = list.get(ele.aIdx)[ele.eIdx];
                end   = max;
            }
            ele.eIdx++;
            if(ele.eIdx < list.get(ele.aIdx).length){
                queue.offer(ele);
                max = Math.max(max, list.get(ele.aIdx)[ele.eIdx]);
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
