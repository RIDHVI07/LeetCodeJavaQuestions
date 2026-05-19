class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1;
                int r = n - 1;

                while (r > l) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ArrayList<Integer> k = new ArrayList<>();
                        k.add(nums[i]);
                        k.add(nums[j]);
                        k.add(nums[l]);
                        k.add(nums[r]);
                        ans.add(k);
                        l += 1;
                        r -= 1;
                        while (l < r && nums[l] == nums[l - 1])
                            l += 1;
                        while (l < r && nums[r] == nums[r + 1])
                            r -= 1;
                    }
                    else if(target > sum)
                        l += 1;
                    else
                        r -= 1;
                }
            }
        }
        return ans;
    }
}