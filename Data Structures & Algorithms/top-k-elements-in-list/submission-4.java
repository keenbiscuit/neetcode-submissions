class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        // Create frequency buckets
        for(int i = 0; i<=nums.length; i++)
        {
            freq[i] = new ArrayList<>();
        }

        for(int n : nums)
        {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // For every pair in count put that value in the bucker for the correct frequency
         for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        // int array to return results
        int[] res = new int[k];
        int index = 0;
        // Start at highest number and move down
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            // Add every number in a bucket
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;

    }
}
