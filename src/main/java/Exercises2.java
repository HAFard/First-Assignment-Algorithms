import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public static int[] twoSum(int[] nums, int target) {

        int[] indexes = new int[2] ;

        for(int i = 0 ; i < nums.length ; i++)
        {
            for (int j = i+1 ; j < nums.length; j++)
            {
                if (nums[i]+nums[j] == target)
                {
                    indexes[0] = i ;
                    indexes[1] = j ;
                    break;
                }
            }
        }

        return indexes;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public static int romanToInt(String s) {
        int IntVal = 0 ;
        String currentChar = "";

        for (int i = 1 ; i <= s.length() ; i++ )
        {

            currentChar = s.substring(i-1 , i);

            switch (currentChar)
            {
                case "I" :
                    if (i<=s.length()-1)
                    {
                        if (s.substring(i,i+1).equals("V") || s.substring(i,i+1).equals("X")) {
                            IntVal -= 1;
                            break;
                        }
                    }
                    IntVal += 1;
                    break;
                case "V" : IntVal += 5 ;break;
                case "X" :
                    if (i<=s.length()-1)
                    {
                        if (s.substring(i,i+1).equals("L") || s.substring(i,i+1).equals("C")) {
                            IntVal -= 10;
                            break;
                        }
                    }
                    IntVal += 10;
                    break;
                case "L" : IntVal += 50 ;break;
                case "C" :
                    if (i<=s.length()-1)
                    {
                        if (s.substring(i,i+1).equals("D") || s.substring(i,i+1).equals("M")) {
                            IntVal -= 100;
                            break;
                        }
                    }
                    IntVal += 100;
                    break;
                case "D" : IntVal += 500 ;break;
                case "M" : IntVal += 1000 ;break;
                default: IntVal += 0 ;break;
            }
        }

        return IntVal;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> allPermutation = new ArrayList<>();
        List<Integer> newNums = new ArrayList<>();

        //copy nums array to a list of integers
        for (int i = 0; i < nums.length; i++) {
            newNums.add(nums[i]);
        }


        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = 0;
        }

        allPermutation.add(newNums);

        int i = 0;
        while (i < nums.length) {
            if (indexes[i] < i) {
                if (i % 2 == 0){
                    swap(newNums, 0 , i);
                }
                else swap(newNums, indexes[i] , i);

                allPermutation.add(newNums);
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }

        return allPermutation;
    }

    private static void swap(List<Integer> elements, int firstIndex, int secondIndex) {
        int tmp = elements.get(firstIndex);
        elements.set(firstIndex,elements.get(secondIndex)) ;
        elements.set(secondIndex,tmp) ;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,8};
        int[] index = twoSum(nums,7);
        System.out.println(romanToInt("III"));
        System.out.printf("%d %d",index[0],index[1]);
        System.out.println(permute(nums));
    }
}