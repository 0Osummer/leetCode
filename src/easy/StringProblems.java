package easy;

import java.util.Map;
import java.util.TreeMap;

public class StringProblems {
	/**
	 * 这个方法在字符串超级长的时候，返回结果有错
	 * *****不太懂是为什么****
	 * 这个方法同样适用于中文输入
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		Map<Character,Integer> map1 = new TreeMap<Character, Integer>();
		Map<Character,Integer> map2 = new TreeMap<Character, Integer>();
		if(s.length() == t.length()){
			map1 = stringToMap(s);
			map2 = stringToMap(t);
			return map1.equals(map2);
			/**
				if(!(map2.containsKey(c) && map1.get(c) == map2.get(c))) return false;
			}
			for(Character c : map2.keySet()){
				if(!(map1.containsKey(c) && map2.get(c) == map1.get(c))) return false;
			}
			return true; **/
		}
		return false;
    }
	
	public Map<Character,Integer> stringToMap(String s){
		Map<Character,Integer> map = new TreeMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			int times = 0;
			if(map.containsKey(s.charAt(i))){
				times = map.get(s.charAt(i));
				map.remove(s.charAt(i));
			}
			map.put(s.charAt(i), times+1);
		}
		return map;
	}
	
	/**
	 * 26个字母出现次数的数组，遍历s时统计次数，遍历t时减去次数，如果出现次数为负数的则说明不是异构单词
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length() ) return false;
       int[] alphabet = new int[26];
       for(int i = 0; i< 26; i++) {
           alphabet[i] = 0;
       }
       for(int i = 0; i < s.length(); i++) {
           alphabet[s.charAt(i) - 'a']++;
       }
       for(int i = 0; i < t.length(); i++) {
           alphabet[t.charAt(i) - 'a']--;
           if(alphabet[t.charAt(i) -'a'] < 0) return false;
       }
       return true;

	}
	/**
	 * 罗马数字计数
	 * I（1）、V（5）、X（10）、L（50）、C（100）、D（500）、 M（1000）。
	 * 小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
	 * 小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int total = 0;
		for(int i = 0;i<s.length()-1;i++){
			if(getRomanNum(s.charAt(i))>=getRomanNum(s.charAt(i+1))){
				total += getRomanNum(s.charAt(i));
			}
			else{
				total -= getRomanNum(s.charAt(i));
			}
		}
		total += getRomanNum(s.charAt(s.length()-1));
		return total;
	}
	
	/**
	 * 此函数可以用Map代替
	 * @param a
	 * @return
	 */
	public int getRomanNum(Character a){
		switch (a) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}	
	}
	
	
	
}
