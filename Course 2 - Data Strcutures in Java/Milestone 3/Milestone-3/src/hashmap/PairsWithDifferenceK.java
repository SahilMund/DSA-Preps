package hashmap;


import java.util.HashMap;

public class PairsWithDifferenceK {

    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here

        HashMap<Integer,Integer> map = new HashMap<>();
        // Store all the elements of the array in hashmap as key and it's frequencies as value
        for(int key:arr)
        {	
            if(map.containsKey(key))
            {
                map.put(key,map.get(key)+1);
            }
            else
            {
                map.put(key,1);
            }   
        }

        
        int countPairs=0;
        if (k==0)
        {
            for (Integer i: map.keySet())
            {
                int val=map.get(i);
                countPairs=countPairs+(val*(val-1))/2;
            }
            return countPairs;
        }

        for (Integer i: map.keySet())
        {
            //System.out.println("Current element: "+i);
            //System.out.println("Need to find: "+(i-k)+", "+(i+k));
            if (map.containsKey(k+i))
            {
                //System.out.println("Found " + (k+i));
                countPairs=countPairs+(map.get(i)*map.get(k+i));   
                //System.out.println("Current count of pairs: "+countPairs);
            }
            if (map.containsKey(i-k))
            {
                //System.out.println("Found " + (i-k));
                countPairs=countPairs+(map.get(i)*map.get(i-k));   
                //System.out.println("Current count of pairs: "+countPairs);
            }
            //System.out.println();
        }
        
        //to remove duplication we need to divide it by 2
        countPairs=countPairs/2;
        return countPairs;

    }
}
