class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        // If B is the smaller array swap them
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int left = 0;
        int right = A.length;
        while (left <= right) {
            // Cut index of A
            int i = (left + right) / 2;

            // Cut index of B
            int j = half - i;

            // Get the boarders of Both lists
            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            // Partition is valid when we are between Aleft & BRight and BLeft & ARight
            if (Aleft <= Bright && Bleft <= Aright) {
                // If odd length
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                // If even length
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            // Move the cut in A to the left
            else if(Aleft > Bright)
            {
                right = i -1;
            }
            // Move the cut in A to the right
            else
            {
                left = i + 1;
            }

        }
        return -1;
    }
}
