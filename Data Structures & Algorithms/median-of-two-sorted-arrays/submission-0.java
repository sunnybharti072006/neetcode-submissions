class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums2.length;
        int m = nums1.length;
        int low = 0;
        int high = m;

        while(low <= high) {

            int x = (low + high) / 2;
            int y = (m + n + 1) / 2 - x; 

            
            int maxLeftX = (x == 0) ? Integer.MIN_VALUE : nums1[x - 1];
            int minRightX = (x == m) ? Integer.MAX_VALUE : nums1[x];

            int maxLeftY = (y == 0) ? Integer.MIN_VALUE : nums2[y - 1];
            int minRightY = (y == n) ? Integer.MAX_VALUE : nums2[y];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX ){
                if((m + n) % 2 == 1){
                    return Math.max(maxLeftX, maxLeftY);
                }else{
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
            }else if(maxLeftX > minRightY){
                high = x - 1;
            }else{
                low = x + 1;
            }
        } 
        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}