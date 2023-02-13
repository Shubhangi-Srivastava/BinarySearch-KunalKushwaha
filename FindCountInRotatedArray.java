/**
 * Author: Shubhangi Srivastava
 * This is a follow up question to Search in Rotated Array where finding how many times the array has been rotated is asked.
 * basically check if the mid is lesser than prev and also lesser than next, if yes, return mid
 * if not, check if the mid is less than end, if yes, move end to mid -1
 * if mid greater than start, move start to mid +1
 * Source: Geeks for Geeks
 */

public class FindCountInRotatedArray {
    public static void main(String args[]) {
		int nums[] = {15, 18, 2, 3, 6, 12};
        int n = nums.length;
		FindCountInRotatedArray obj = new FindCountInRotatedArray();
		int ans = obj.count(nums, n);
		System.out.println(ans);
	}
    public int count(int[] nums, int n) {
        int start = 0, end = n-1;
        while(start <= end){
          int mid = start + (end - start)/2;
          int previous = (mid -1+n)%n;
          int next = (mid +1)%n;

          if(nums[mid] <= nums[previous] && nums[mid] <= nums[next]){
            return mid;
          } else if(nums[mid] <= nums[end]){
            end = mid -1;
          } else if(nums[mid] >= nums[start]){
            start = mid +1;
          }
        }
        return 0;
    }
}
