package easy;

public class MoveZeros {
	
	 public static void moveZeroes(int[] nums) {
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
		 System.out.println(nums[0]);
    }
	 
	 public static void main(String args[]){
		 int[] nums = {0,1,0,3,12};
		 moveZeroes(nums);
		 for(int i : nums){
			 System.out.println(i);
		 }
		 
	 }

}
