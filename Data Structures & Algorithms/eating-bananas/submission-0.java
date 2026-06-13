class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
            maxPile = Math.max(maxPile, pile);
        }
        int left = 1;
        int right = maxPile;
        int ans = maxPile;

        while(left <= right){
            int mid = left+(right - left) / 2;
            
            if(canEatAll(piles,mid,h)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canEatAll(int[] piles, int speed , int totalHrForKoko){
        int hr = 0;
        for(int pile: piles){
            hr += (pile + speed - 1) / speed;

            if(hr > totalHrForKoko){
                return false;
            }
        }
        return hr <= totalHrForKoko;
    }
}
