class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Find largest pile and initialize k
        int maxSpeed = Arrays.stream(piles).max().getAsInt();;
        int k = maxSpeed;

        // If piles is the same as hours then return largest pile
        if(piles.length == h)
        return k;

        // Binary Search for k
        int minSpeed = 1;
        while (minSpeed <= maxSpeed) {
            
            long hours = 0;
            
            // Safe mid = left + (right - left) / 2
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            // Calculate total hours to finish for currentSpeed
            for (int p : piles) {
                hours += Math.ceil((double)p / midSpeed);
            }

            // If speed is too slow move minSpeed up to midSpeed
            if (hours > h) {
                minSpeed = midSpeed + 1;
            }

            // If a valid speed update k and move maxSpeed down to try and find a more efficient speed
            else if(hours <= h)
            {
              k = midSpeed;
              maxSpeed = midSpeed - 1;
            }
        }
        return k;
    }
}
