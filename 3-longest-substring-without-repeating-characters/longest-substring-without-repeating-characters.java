class Solution {
    public int lengthOfLongestSubstring(String s) {
         int len = s.length();
        if (len == 0)
            return 0;
        int maxLen = 0;
        int left=0, right=0;
        Map<Character, Integer> map = new HashMap();
        while(right < len){
           
            char cur = s.charAt(right);
            int curExistingPos = map.getOrDefault(cur, -1);
            if (curExistingPos != -1 && curExistingPos>= left){
               
                maxLen = Math.max(maxLen, right - left);
              
                left = curExistingPos + 1;                
            }
            map.put(cur, right);
            right++;
        }
        return Math.max(maxLen, right - left);
    }
}