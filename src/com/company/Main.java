package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        //reverseString(s);
        String str = "Let's take LeetCode contest";
        reverseString(str);
    }

    private static void reverseString(String s) {
        String[] words = s.split(" ");
        int index = 0;
        for (String word : words) {
            char[] letters = word.toCharArray();
            StringBuilder wordBuilder = new StringBuilder();
            for (int i = letters.length - 1; i >= 0; i--) {
                wordBuilder.append(letters[i]);
            }
            word = wordBuilder.toString();
            words[index] = word;
            index++;
        }
        String finalS = String.join(" ", words);
        System.out.println("Reversed: "+finalS);
        System.out.println("Expected: s'teL ekat edoCteeL tsetnoc");
    }

    private static void reverseString(char[] s) {
        int right = s.length - 1;
        for (int left = 0; left < right; left++, right--) {
            // Swap values of left and right
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        System.out.println("Reversed: " + Arrays.toString(s));
        System.out.println("Expected: olleh");
    }

    private static void moveZeroes(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                if (count != i) {
                    nums[i] = 0;
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        int gcd = gcd(k, nums.length);
        int temp, j, kk;
        for (int i = 0; i < gcd; i++) {
            temp = nums[i];
            j = i;
            while (true) {
                kk = j + k;
                if (kk >= nums.length) {
                    kk = kk - nums.length;
                }
                if (kk == i) {
                    break;
                }
                nums[j] = nums[kk];
                j = kk;
            }
            nums[j] = temp;
        }
        return nums;
    }

    private static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
