class Solution {
    public int maxArea(int[] height) {
          int left=0, right=height.length-1;
        int max=0;
        while ( left < right ) {
            int ans = Math.min(height[left], height[right]) * ( right - left );
            max = Math.max(max, ans);
            if ( height[right] > height[left] ) left++;
            else right--;
        }
        return max;
    }
}