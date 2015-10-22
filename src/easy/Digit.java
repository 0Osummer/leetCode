package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Digit {
	
	/**
	 * 将一个数字的个位数相加，直到只剩一位数
	 * @param num
	 * @return
	 */
	public int addDigits(int num) {
		while(num  > 9){
			int temp = num;
			int total = 0;
			while(temp > 0){
				total += temp % 10;
				temp = temp / 10;
			}
			num = total;
		}
		return num;
    }

	/**
	 * 将数组中的零元素移动到数组末尾
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
		 int j = 0;
		 for(int i : nums){
			 if(i != 0){
				 temp[j++] = i;
			 }
		 }
		 j=0;
		 for(int i:temp){
			 nums[j++]=i;
		 }
    }
	
	/**
	 * Write a function that takes an unsigned integer and returns the
	 *  number of ’1' bits it has (also known as the Hamming weight).
	 * @param n
	 * @return
	 */
    public int hammingWeight(int n) {
    	int total = 0;
    	while(n != 0){
    		//  & 运算 ：有且只有两个操作数最后一位都为1，结果才为1； 
    		if((n & 1) == 1) total ++;
    		//无符号向由右移动一位
    		n = n >>> 1;
    	}
        return total;
    }
    
    /**
     * 判断一个数组有没有重复的数组
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	for(int i : nums){
    		if(set.contains(i)) return true;
    		set.add(i);
    	}
        return false;
    }
    
    /**
     * Given a column title as appear in an Excel sheet, return its
     *  corresponding column number.
     * @param s excel column title
     * @return corresponding column number
     */
    //ASCII 码， A --> 65
    public int titleToNumber(String s) {
    	if(s == null) return 0;
    	s = s.trim();
    	int total = 0;
    	int length = s.length();
    	for(int i = 0; i < length; i++){
    		total = (int) (total + (s.charAt(i)-64)*Math.pow(26, length-i-1));
    	}
        return total;
    }
    /**
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element
     *  always exist in the array.
     *  
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i : nums){
    		int times = 0;
    		if(map.containsKey(i)){
    			times = map.get(i);
    			map.remove(i);
    		}
    		map.put(i, times+1);
    	}
    	
    	int majorkey = 0;;
    	int majorvalue = 0;
    	for(Integer tempKey:map.keySet()){
    		if(map.get(tempKey) > majorvalue){
    			majorkey = tempKey;
    			majorvalue = map.get(majorkey);
    		}
    	}
    	if(majorvalue > nums.length/2) return majorkey;
    	return 0;
    }
    
    /**
     * Given an array of integers, 
     * every element appears twice except for one. Find that single one
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
    	Set<Integer> a = new HashSet<>();
    	for(int i : nums){
    		if(a.contains(i))
    			a.remove(i);
    		else a.add(i);
    	}
    	int r = 0;
        for(int i :a){
        	r=i;
        }
        return r;
        /**
         * XOR运算
         * int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res = res ^ nums[i];

        return res;

         */
    }
    
    public int climbStairs(int n) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        for(int i = 2; i <= n; i++){
        	a.add(a.get(i-1)+a.get(i-2));
        }
        return a.get(n);
    }
    /**
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly while 14 is not ugly 
     * since it includes another prime factor 7. 
     * Note that 1 is typically treated as an ugly number. 
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
    	if(num <= 0) return false;
    	for(int i = 2; i<= 5 && num > 0; i++){
    		while(num % i == 0){
    			num = num/i;
    		}
    	}
    	return (num == 1);
    }
    
    /**
     * You are playing the following Nim Game with your friend:
     *  There is a heap of stones on the table, 
     *  each time one of you take turns to remove 1 to 3 stones. 
     *  The one who removes the last stone will be the winner. 
     *  You will take the first turn to remove the stones.
     *  Both of you are very clever and have optimal strategies for the game. 
     *  Write a function to determine whether you can win the game given 
     *  the number of stones in the heap.
     *  For example, if there are 4 stones in the heap, 
     *  then you will never win the game: no matter 1, 2, or 3 stones you remove, 
     *  the last stone will always be removed by your friend.
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
    	return n % 4 ==0;
        
    }
    
    /**
     * 一个数每位的平方的和相加，直到最后得1 为Happy
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
    	Set<Integer> a = new HashSet<Integer>();
    	while(n != 1 && !a.contains(n)){
    		a.add(n);
    		int temp = 0;
    		while(n > 0){
    			temp += Math.pow((n % 10), 2);
    			n = n/10;
    		}
    		n = temp;
    	}
    	return n == 1;
    }
    
    /**
     * 删除数组中的所有数字 val， 返回新长度，数组的顺序不重要
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
    	for(int i = length -1; i >= 0; i--){
    		if(nums[i] == val){
    			nums[i] = nums[--length];
    		}
    	}
    	return length;
    }
    /**
     * n 第一位1其他为0 n-1 所有为为1
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0) return false;
    	else return (n&(n-1)) == 0;
    }
    /**
     * Given a sorted array, remove the duplicates in place 
     * such that each element appear only once and return the new length
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
    	if(nums== null || nums.length == 0) return 0;
    	int length = nums.length;
    	for(int i = length -1; i > 0; i--){
    		if(nums[i] == nums[i-1] ){
    			//数组向前挪动
    			for(int j = i;j < length-1;j++){
    				nums[j] = nums[j+1];
    			}
    			length--;
    		}
    	}
    	return length;
    }
}
