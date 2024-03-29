package PriorityQueue1;

import java.util.*;

public class Max_Heap_Implementation {
    // Complete this class
    private ArrayList<Integer> heap = new ArrayList<Integer>();

    boolean isEmpty() {
        // Implement the isEmpty() function here
        return heap.isEmpty();
    }

    int getSize() {
        // Implement the getSize() function here
        return heap.size();
    }

    int getMax() {
        // Implement the getMax() function here
        if(heap.isEmpty())
            return Integer.MIN_VALUE;
        return heap.get(0);
    }

    void insert(int element) {
        // Implement the insert() function here
        //Insert new element at the end of the arraylist
        heap.add(element);

        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;

        while(parentIndex>=0)
        {
            //Check if parent has lesser priority than the child. If it does, swap them
            if(heap.get(childIndex)>heap.get(parentIndex))
            {
                int temp=heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex,temp);

                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;

            }
            else
            {
                return;
            }
        }

    }

    int removeMax() {
        // Implement the removeMax() function here
        if(heap.isEmpty())
            return Integer.MIN_VALUE;

        //Remove the Max element and store it
        int maxEle=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //Start reinstating max. heap property from root to leaf
        int parentIndex=0;
        int leftChildIndex=2*parentIndex+1, rightChildIndex=2*parentIndex+2;

        while(leftChildIndex<heap.size())
        {
            int maxIndex=parentIndex;
            if(heap.get(maxIndex)<heap.get(leftChildIndex))
            {
                maxIndex=leftChildIndex;
            }


            if(rightChildIndex<heap.size() && heap.get(maxIndex)<heap.get(rightChildIndex))
            {
                maxIndex=rightChildIndex;
            }


            if(maxIndex==parentIndex)
            {
                return maxEle;
            }

            int temp=heap.get(maxIndex);
            heap.set(maxIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);

            parentIndex=maxIndex;
            leftChildIndex=2*parentIndex+1;
            rightChildIndex=2*parentIndex+2;
        }

        return maxEle;  
    }
}