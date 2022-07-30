package Recursion_Advance;


public class ReturnSubsetOfSumK {

    // Return a 2D array that contains all the subsets which sum to k
    public static int[][] subsetsSumK(int input[], int k) {

        return subsetsSumKHelper(input,k,0);
    }

    public static int[][] subsetsSumKHelper(int input[],int k,int startIndex) {
        //Base case - If startIndex == input.length
        //We can have two cases in the base condition
        //1. If k==0 - This means the desired sum has been achieved by including the last element of the input array
        //2. If k!=0 - Desired sum has not been achieved even when last element is included
        if (startIndex==input.length)
        {
            int arr[][];
            if (k==0)
            {
                arr = new int[1][0];
            }
            else
            {
                arr = new int[0][0];
            }
            return arr;
        }

        //Considering recursive hypothesis where we have the subsets of two cases
        //1. Subsets containing current input[startIndex] element - temp1--Inclusion Principle
        //2. Subsets not containing current input[startIndex] element - temp2 - exclusion Principle

        int temp1[][] = subsetsSumKHelper(input,k-input[startIndex],startIndex+1);
        int temp2[][] = subsetsSumKHelper(input,k,startIndex+1);

        //Now, we simply need to combine temp1 and temp2 and return to the calling function
        //When copying temp1 into output, we need to ensure 
        //we also include current input[startIndex] as the first element of that row
        //first copy all the data from temp2(exclusion call) then from temp1 by including the current input[si]
        int output[][] = new int[temp1.length+temp2.length][];

        //directly copy from temp2 to output 2D array
        for (int i=0;i<temp2.length;i++)
        {
            //creating output 1D array to use it while dealing with temp1
            output[i] = new int[temp2[i].length];
            
            for (int j=0;j<temp2[i].length;j++)
            {
                output[i][j]=temp2[i][j];
            }
        } 

        for (int i=0;i<temp1.length;i++)
        {
            output[i+temp2.length] = new int[temp1[i].length+1];
            output[i+temp2.length][0] = input[startIndex];
            
            for (int j=1;j<output[i+temp2.length].length;j++)
            {
                output[i+temp2.length][j]=temp1[i][j-1];
            }
        }

        return output;


    }


}


