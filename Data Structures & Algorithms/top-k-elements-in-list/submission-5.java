class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        // Key: int n in nums
        // Value: the frequency of n in nums
        List<Integer>[] freq = new List[nums.length + 1];

        // Create list to hold numbers with frequency of i
        for(int i = 0; i <= nums.length; i++)
        {
            freq[i] = new ArrayList<>();
        }

        // Add all numbers and their frequencies to count
        for(int n : nums)
        {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // For each entry into the map go to the index that matches
        // The frequency of the key and add the key
        for(Map.Entry<Integer,Integer> entry : count.entrySet())
        {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        // now freq holds all lists of x frequency
        // Start at largest frequency which is at the end and move down

        for(int i = freq.length - 1; i > 0 && index < k; i--)
        {
            for(int n : freq[i])
            {
                result[index] = n;
                index++;
                if(index == k)
                return result;
            }
        }
        return result;

    }
}
