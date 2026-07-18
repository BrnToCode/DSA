class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=max(weights);
        int high=sum(weights);
        
        
        while(low<high){
            int mid=low+(high-low)/2;
            int currentLoad=0;
            int reqdays=1;
            for(int weight:weights){
                if((currentLoad+weight)>mid){
                    reqdays++;
                    currentLoad=weight;
                }else{
                    currentLoad+=weight;
                }
            }
            if(reqdays<=days){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }



     public static int max(int[] piles){
        int maxi=Integer.MIN_VALUE;
        for(int num:piles){
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }

     public static int sum(int[] piles){
        int sum=0;
        for(int num:piles){
           sum+=num;
        }
        return sum;
    }
}