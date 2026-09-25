class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int p : piles) {
            maxSpeed = Math.max(maxSpeed, p);
        }

        if(piles.length == h)
        return maxSpeed;

        int k = maxSpeed;
        int minSpeed = 1;
        while (minSpeed <= maxSpeed) {
            long hours = 0;
            // Safe mid = left + (right - left) / 2
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            // Calculate total hours to finish for currentSpeed
            for (int p : piles) {
                hours += Math.ceil((double)p / midSpeed);
            }

            if (hours > h) {
                minSpeed = midSpeed + 1;
            }
            else if(hours <= h)
            {
              k = midSpeed;
              maxSpeed = midSpeed - 1;
            }
        }
        return k;
    }
}
