package easy;

import java.util.Scanner;
/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. 

For example: 

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it. 

Follow up:
 Could you do it without any loop/recursion in O(1) runtime? 

 */

/**
 * @author summer
 */
public class AddDigits {
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int num = cin.nextInt();
		cin.close();
		while(num  > 9){
			int temp = num;
			int total = 0;
			while(temp > 0){
				total += temp % 10;
				temp = temp / 10;
			}
			num = total;
		}
		System.out.println(num);
	}
}
