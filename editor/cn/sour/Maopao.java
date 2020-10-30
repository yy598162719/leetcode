package cn.sour;

public class Maopao {
    /**
     * 冒泡 两两比较与交换，每次得出最大位置
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    /**
     * 插入 与左边排好序的数组一一进行比较交换，当自己小于数组的值时，交换
     *
     * @param nums
     */
    public static void sort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
            }
        }
    }

    /**
     * 选择 寻找右边最小值的下标，每一轮找到最小值跟i++交换
     *
     * @param nums
     */
    public static void sort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
//            最小值的下标
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[j] < nums[minIndex] ? j : minIndex;
            }
            swap(nums, i, minIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 4, 9};
//        sort(nums);
//        sort1(nums);
        sort2(nums);
        System.out.println("停止");
    }
}
