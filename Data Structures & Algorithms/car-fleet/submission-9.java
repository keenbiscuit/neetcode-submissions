class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Create 2D array to pair the speed
        double[][] pair = new double[position.length][2];

        // Intialize pairs
        for(int i = 0; i < position.length; i++)
        {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
            
        }

        // Pair arrays by position descending
        Arrays.sort(pair, (a,b) -> Double.compare(b[0], a[0]));

        // Stack to hold the times
        Stack<Double> times = new Stack<>();
        
        for(int i = 0; i < pair.length; i++)
        {
            // Calculate arrival time of current pair
            double arrivalTime = (target - pair[i][0]) / pair[i][1];

            // If the time is less than or equal to 
            // The arrival time of the position ahead of it
            // Don't push to stack
            if(times.isEmpty() || arrivalTime > times.peek())
                times.push(arrivalTime);
            // if(!times.isEmpty() && arrivalTime <= times.peek())
            // {
            //     continue;
            // }
            // // If arrival Time is slower than position ahead of it
            // // They dont catch up to become a fleet so add to stack
            // else{
            //     times.push(arrivalTime);
            // }
        }
        return times.size();
    }
}
