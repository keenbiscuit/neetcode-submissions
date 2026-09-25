class Solution {
    public int findMin(int[] nums) {
      int n = nums.length - 1;
      int left = 0, right = n;
      int min = Arrays.stream(nums).max().getAsInt();

      while(left < right)
      {
        int mid = left + ((right - left) / 2);
        System.out.println(nums[mid]);

        if(nums[mid] > nums[left] && nums[mid] > nums[right] && nums[right] < nums[left])
        {
          left = mid + 1;
        }
        else if(nums[mid] > nums[left] && nums[mid] > nums[right] && nums[left] < nums[right])
        {
          right = mid - 1;
        }

        else if(nums[mid] < nums[left] && nums[mid] < nums[right] && nums[right] > nums[left])
        {
          left = mid + 1;
        }
        else if(nums[mid] < nums[left] && nums[mid] < nums[right] && nums[left] > nums[right])
        {
          right = mid - 1;
        }
        else if(nums[mid] > nums[left] && nums[mid] < nums[right] && nums[left] < nums[right])
        {
          right = mid - 1;
        }
        else if(nums[mid] > nums[right] && nums[left] < nums[right] && nums[right] < nums[left])
        {
          left = mid + 1;
        }
        if(mid == left || mid == right || left==right)
        { System.out.println("Made it");
          min = Math.min(min, nums[left]);
          min = Math.min(min, nums[right]);
          left++;
        }
        
        min = Math.min(min, nums[mid]);
      }
      return min;
    }
}
