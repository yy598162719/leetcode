//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2693 👎 0

package cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
public class 三数之和_15 {
    public static void main(String[] args) {
        Solution solution = new 三数之和_15().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> ans = new ArrayList();
            int len = nums.length;
            if (len < 3) return ans;
            Arrays.sort(nums); // 排序

            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
                int left = i + 1, right = len - 1;
                while (left < right) {
                    int sum=nums[i] + nums[left] + nums[right];
                    if (sum== 0) {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                        while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                        left++;
                        right--;
                    }
                    else if (sum < 0) left++;
                    else if (sum > 0) right--;
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}