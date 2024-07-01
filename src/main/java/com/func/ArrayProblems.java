package com.func;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] arr = new int[] {3,2,4};

        int [] ans = twoSum(arr,6);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        int [] ans=new int[2];

        /*HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int reqVal = target-nums[i];
            if(map.get(reqVal)!=null){
                ans[0] = i;
                ans[1] = (int)map.get(reqVal);
            }
            map.put(nums[i],i);
        }*/
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int i=0;
        int j=n-1;
        while(i<j){
            int curSum = nums[i] +nums[j];
            if(curSum == target){
                ans[0] = map.get(nums[i]);
                ans[1] = map.get(nums[j]);
                break;
            }
            if(curSum>target) j--;
            if(curSum<target) i++;
            map.put(nums[i],i);
            map.put(nums[j],j);
        }
        return ans;
    }
}
