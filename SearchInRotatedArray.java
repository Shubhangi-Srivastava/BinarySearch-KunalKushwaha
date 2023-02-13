/**
 * Author: Shubhangi Srivastava
 * Leetcode problem 33: Search in a Rotated Array
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Explanation: The array is sorted. That means we need to apply BinarySearch. In such cases, we must keep a track of Left sorted 
 * array and check for target in it and a right sorted array and keep searching for target in it. That's the technique
 * Here everything is check between start and mid and mid and end.
 */

public class SearchInRotatedArray {

	public static void main(String args[]) {
		int nums[] = {5,1,3};
		int target= 5;
		SearchInRotatedArray obj = new SearchInRotatedArray();
		int ans = obj.search(nums,target);
		System.out.println(ans);
	}
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target) return mid; //if mid element is the target, return mid
            else if(nums[start] <= nums[mid]){ //left array is sorted, check in that
                if(nums[start] <= target && target < nums[mid]){
                    end = mid -1;
                } else {
                    start = mid+1;
                }
            }else if(target > nums[mid] && target <= nums[end]){ //right array is sorted
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }
}