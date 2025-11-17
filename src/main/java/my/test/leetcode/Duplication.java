package my.test.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Duplication {
    public static void main(String[] args) {
        runScenario1();
        //runScenario2();;
    }

    private static void runScenario1(){
        Solution sol =  new Solution();
        int[] test =  {1,2,3,1,4,7,1,2,4};
        int distance = 2;
        boolean result = sol.containsNearbyDuplicate(test, distance);
        System.out.println("result - " +result);
    }

    private static void runScenario2(){
        Solution sol =  new Solution();
        int[] test =  {1,2,3,1,2,3};
        int distance = 2;
        boolean result = sol.containsNearbyDuplicate(test, distance);
        System.out.println("result - " +result);
    }
}

class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean containsNearbyDuplicate = false;

        Map<Integer, Integer> indexMap = new HashMap<>(1000);
        for(int i=0; i < nums.length; i++){
            Integer duplicateIndex = indexMap.get(nums[i]);
            if(duplicateIndex == null){
                indexMap.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
            } else{
                int calculatedDistance = Math.abs((duplicateIndex.intValue() -i));
                if(calculatedDistance <= k){
                    containsNearbyDuplicate = true;
                    break;
                }else{
                    indexMap.put(Integer.valueOf(nums[i]),Integer.valueOf(i));
                }
            }
        }

        return containsNearbyDuplicate;
    }
}
