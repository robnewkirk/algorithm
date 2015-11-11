package com.rnewkirk.Strings;

import java.util.Arrays;

public class StringTests {


    private static int ASCII_Length = 256; // Assume we're dealing with ASCII since each character is  1 byte in length


    // Given a string, determine if all of the characters are unique;
    public static boolean isUniqueIterate(String candidate) {
        boolean isUnique = true;
        if (isGreaterThanAscii(candidate)) {
            isUnique = false;
        } else {

            boolean[] char_set = new boolean[ASCII_Length];

            for (int i = 0; i < candidate.length(); i++) {
                int idx = candidate.charAt(i);
                if (char_set[idx]) {
                    isUnique = false;
                    break;
                } else {
                    char_set[idx] = true;
                }
            }
        }

        return isUnique;
    }

    public static boolean isUniqueSort(String candidate) {
        boolean isUnique = true;
        if (isGreaterThanAscii(candidate)) {
            isUnique = false;
        } else {
            char[] chars = candidate.toCharArray();
            Arrays.sort(chars);

            for (int i = 0; i < chars.length; i++) {
                if (i + 1 < chars.length) {
                    isUnique = !(chars[i] == chars[i + 1]);
                }
                if (!isUnique) break;
            }
        }

        return isUnique;
    }

    // Given two strings, determine if one is a permutation of the other
    public static boolean isPermutationSort(String candidate, String permutation) {
        return candidate.length() <= permutation.length() && sort(candidate).equals(sort(permutation));
    }

    public static boolean isPermutationBytes(String candidate, String permutation) {
        boolean isPermutation;

        if (candidate.length() > permutation.length()) {
            isPermutation = false;
        } else {

            byte[] candidateBytes = sort(candidate).getBytes();
            byte[] permutationBytes = sort(permutation).getBytes();
            isPermutation = sum(candidateBytes) == sum(permutationBytes);
        }

        return isPermutation;
    }


    // Write a method that replaces all whitespace within a string with %20

    public static String escapeSpaces(String toBeEscaped) {

        char[] originalChars = toBeEscaped.toCharArray();

        int spaceCount = spaceCount(originalChars);
        int newLength = (originalChars.length) + (spaceCount * 2);

        char[] newChars = new char[newLength];

        for (int i = originalChars.length - 1; i >= 0; i--) {
            if (originalChars[i] == ' ') {
                newChars[newLength - 1] = '0';
                newChars[newLength - 2] = '2';
                newChars[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                newChars[newLength - 1] = originalChars[i];
                newLength = newLength - 1;
            }
        }

        return new String(newChars);

    }


    /*
    * Write a method that performs basic string compression using counts of repeated characters
    * Example:
    *   a2b3c5d2
    *
    * If the 'compressed' string would not become smaller than the original string, your method should return the original string
    * */


    public static String compress(String toCompress) {
        String compressed;

        if (countDuplicateChars(toCompress) > toCompress.length()) {
            compressed = toCompress;
        } else {

            StringBuffer buffer = new StringBuffer();
            char last = toCompress.charAt(0);
            int count = 1;

            for (int i = 1; i < toCompress.length(); i++) {
                if (toCompress.charAt(i) == last) {
                    count++;
                } else {
                    buffer.append(last);
                    buffer.append(count);
                    last = toCompress.charAt(i);
                    count = 1;
                }
            }

            buffer.append(last);
            buffer.append(count);
            compressed = buffer.toString();
        }


        return compressed;
    }

    /*
    *  Privates
    * */

    private static int countDuplicateChars(String string) {
        char last = string.charAt(0);
        int count = 0;
        int length = 1;

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == last) {
                count++;
            } else {
                last = string.charAt(i);
                length += 1 + String.valueOf(count).length();
                count = 1;
            }
        }

        length += 1 + String.valueOf(count).length();

        return length;
    }

    private static int spaceCount(char[] chars) {
        int spaceCount = 0;

        for (char c : chars) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        return spaceCount;

    }

    private static boolean isGreaterThanAscii(String candidate) {
        return candidate.length() > ASCII_Length;
    }

    private static String sort(String toSort) {
        char[] chars = toSort.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static int sum(byte[] bytes) {
        int sum = 0;
        for (int i : bytes) {
            sum += i;
        }
        return sum;
    }
}
