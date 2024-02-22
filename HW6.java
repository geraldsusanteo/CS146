import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] nums = { -10000, -5, 0, 5, 10, -10, 0, 10000 };

        Arrays.sort(nums);

        if (nums.length < 3 || nums.length > 3000) {
            System.out.println("Invalid length");
        } else if (nums[0] < -10000 || nums[nums.length - 1] > 10000) {
            System.out.println("Invalid size for input");
        } else {
            List<List<Integer>> triplets = threeSum(nums);
            System.out.println(triplets);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // Skip duplicates
                continue;
            
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == 0) {
                    solution.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    
                    while (j < k && nums[j] == nums[j - 1]) // Skip duplicates
                        j++;
                    while (j < k && nums[k] == nums[k + 1]) // Skip duplicates
                        k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return solution;
    }
}
