class Solution {
    boolean valid(int rate, int[] piles, int h) {
        int time=0;
        for (int i=0; i<piles.length; i++) {
            time+=(piles[i]+rate-1)/rate;
            if (time > h){return false;}
        }return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {return (int) Math.ceil((double) piles[0] / (double) h);}
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) { max = Math.max(max, piles[i]);}
        int low=1;
        int high=max;
        int ans=0;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if (valid(mid, piles, h)) {
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }
}
