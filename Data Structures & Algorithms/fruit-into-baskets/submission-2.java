class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0;
        int left = 0;
        for(int i = 0; i< fruits.length; i++)
        {
            // Put fruit in window
            count.put(fruits[i], count.getOrDefault(fruits[i], 0) + 1);

            while (count.size() > 2)
            {
                count.put(fruits[left], count.get(fruits[left]) - 1);

                if(count.get(fruits[left]) ==0)
                {
                    count.remove(fruits[left]);
                }
                left++;
            }

            total = Math.max(total, i - left + 1);
        }
        return total;
    }
}