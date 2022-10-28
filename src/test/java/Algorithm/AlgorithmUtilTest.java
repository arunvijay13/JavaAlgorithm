package Algorithm;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AlgorithmUtilTest {

    private final AlgorithmUtil source;

    public AlgorithmUtilTest() {
        source = new AlgorithmUtil();
    }

    public static void main(String[] args) {
        AlgorithmUtilTest test = new AlgorithmUtilTest();

        test.bubbleSortTest();
        test.insertionSortTest();
        test.selectionSortTest();
        test.quickSortTest();
        test.mergeSortTest();
        test.countingSortTests();
        test.binarySearchTest();
        test.maxSumTest();
        test.kthLargestElementTest();
        test.sort0s1s2sTest();
        test.mooreITest();
        test.mooreIITest();
        test.sellStockTest();
        test.findInsertPositionTest();
        test.candyDistributionTest();
        test.gasStationTest();
        test.maximumSlindingTest();
        test.rotate90Test();
        test.jagglingLeftShiftTest();
        test.longestNonRepeatedSubStringTest();
        test.matchedStringTest();
        test.tripletsTest();
        test.waveArrayTest();
        test.findFirstRepeatingElementTest();
        test.leadersArrayTest();
        test.reverseArrayInGroupTest();
        test.missingNumberTest();
        test.firstElementKTimeTest();
        test.reverseWordTest();
        test.removeDuplicatesTest();
        test.isSubsetTest();
        test.removeDuplicatesInSortedArrayTest();
        test.findMaxConsecutiveOnesTest();
        test.parenthesisCheckerTest();
        test.findOnceTest();
        test.mergeSortedArrayITest();
        test.mergeSortedArrayIITest();
        test.isAnagramTest();
        test.heapSortTest();
        test.laststoneweightTest();
        test.minimumIndexedCharacterTest();
        test.commonElementsTest();
        test.formLargestElementTest();
        test.countDistinctWindowTest();
        test.fibonacciTest();
        test.gridTravellerTest();
        test.coinChangeITest();
        test.coinChangeIITest();
        test.combinationITest();
        test.knapsack0by1Test();
        test.longestCommonSubsequenceTest();
        test.longestCommonSubstringTest();
        test.longestPalindromeSubsequenceTest();
        test.formPalindromeUsingMinimumInsertionTest();
        test.continuousSubarraySumTest();
        test.activitySelectionTest();
        test.findPairInTwoSortedArraysTest();
        test.zigzagTest();
        test.shellsortTest();
        test.searchSortedArray();
        test.largestSubarrayZeroSumTest();
        test.subarraySumTest();
        test.generateParenthesisTest();
        test.generateTest();
        test.getRowTest();
        test.orangesRottingTest();
        test.mergeKSortedArraysTest();
        test.maxProfitTest();
        test.findsumTest();
        test.longestCommonPrefixTest();
        test.relativeSortTest();
        test.rotateRightTest();
        test.topKFrequentTest();
        test.setMatrixTest();
        test.groupAnagramTest();
        test.rainTrapTest();
        test.canArrangeTest();
        test.findSwapValuesTest();
        test.permutationITest();
    }

    @Test
    public void bubbleSortTest() {

        int[] actualArr1 = {5, 4, 3, 2, 1};
        int[] actualArr2 = {4, 32, 9, 4, 0, 0, 2, 32};
        source.bubbleSort(actualArr1);
        source.bubbleSort(actualArr2);
        int[] expectedArr1 = {1, 2, 3, 4, 5};
        int[] expectedArr2 = {0, 0, 2, 4, 4, 9, 32, 32};
        assertArrayEquals(expectedArr1, actualArr1);
        assertArrayEquals(expectedArr2, actualArr2);
    }

    @Test
    public void insertionSortTest() {
        int[] actualArr1 = {5, 4, 3, 2, 1};
        int[] actualArr2 = {4, 32, 9, 4, 0, 0, 2, 32};
        source.insertionSort(actualArr1);
        source.insertionSort(actualArr2);
        int[] expectedArr1 = {1, 2, 3, 4, 5};
        int[] expectedArr2 = {0, 0, 2, 4, 4, 9, 32, 32};
        assertArrayEquals(expectedArr1, actualArr1);
        assertArrayEquals(expectedArr2, actualArr2);
    }

    @Test
    public void selectionSortTest() {
        int[] actualArr1 = {5, 4, 3, 2, 1};
        int[] actualArr2 = {4, 32, 9, 4, 0, 0, 2, 32};
        source.selectionSort(actualArr1);
        source.selectionSort(actualArr2);
        int[] expectedArr1 = {1, 2, 3, 4, 5};
        int[] expectedArr2 = {0, 0, 2, 4, 4, 9, 32, 32};
        assertArrayEquals(expectedArr1, actualArr1);
        assertArrayEquals(expectedArr2, actualArr2);
    }

    @Test
    public void quickSortTest() {
        int[] actualArr1 = {5, 4, 3, 2, 1};
        int[] actualArr2 = {4, 32, 9, 4, 0, 0, 2, 32};
        source.quickSort(actualArr1, 0, actualArr1.length - 1);
        source.quickSort(actualArr2, 0, actualArr2.length - 1);
        int[] expectedArr1 = {1, 2, 3, 4, 5};
        int[] expectedArr2 = {0, 0, 2, 4, 4, 9, 32, 32};
        assertArrayEquals(expectedArr1, actualArr1);
        assertArrayEquals(expectedArr2, actualArr2);
    }

    @Test
    public void mergeSortTest() {
        int[] actualArr1 = {5, 4, 3, 2, 1};
        int[] actualArr2 = {4, 32, 9, 4, 0, 0, 2, 32};
        source.mergeSort(actualArr1, 0, actualArr1.length - 1);
        source.mergeSort(actualArr2, 0, actualArr2.length - 1);
        int[] expectedArr1 = {1, 2, 3, 4, 5};
        int[] expectedArr2 = {0, 0, 2, 4, 4, 9, 32, 32};
        assertArrayEquals(expectedArr1, actualArr1);
        assertArrayEquals(expectedArr2, actualArr2);
    }

    @Test
    public void countingSortTests() {
        int[] actualArr1 = {5, 4, 3, 2, 1};
        int[] actualArr2 = {4, 32, 9, 4, 0, 0, 2, 32};
        source.countingSort(actualArr1);
        source.countingSort(actualArr2);
        int[] expectedArr1 = {1, 2, 3, 4, 5};
        int[] expectedArr2 = {0, 0, 2, 4, 4, 9, 32, 32};
        assertArrayEquals(expectedArr1, actualArr1);
        assertArrayEquals(expectedArr2, actualArr2);
    }

    @Test
    public void maxSumTest() {
        int[] arr1 = {1, -2, 0, 1, 2, 2, 4, 5};
        int expectedValue = 14;
        assertEquals(expectedValue, source.maxSum(arr1));
    }

    @Test
    public void kthLargestElementTest() {
        int[] arr = {4, 32, 9, 4, 0, 0, 2, 32};
        int expectedValue1 = 9;
        int expectedValue2 = 2;
        int expectedValue3 = 32;
        int expectedValue4 = -1;

        assertEquals(expectedValue1, source.kthLargestElement(arr, 3));
        assertEquals(expectedValue2, source.kthLargestElement(arr, 6));
        assertEquals(expectedValue3, source.kthLargestElement(arr, 1));
        assertEquals(expectedValue4, source.kthLargestElement(arr, -1));
    }

    @Test
    public void binarySearchTest() {
        int[] test = {1, 24, 56, 78, 90, 100};
        int expectedValue1 = 1;
        int expectedValue2 = -1;
        int expectedValue3 = 5;

        assertEquals(expectedValue1, source.binarySearch(test, 24));
        assertEquals(expectedValue2, source.binarySearch(test, 57));
        assertEquals(expectedValue3, source.binarySearch(test, 100));
    }

    @Test
    public void sort0s1s2sTest() {
        int[] arr = {0, 1, 2, 2, 1, 1, 0, 2, 1, 0, 0, 0, 0};
        int[] expectedValue = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2};
        source.sort0s1s2s(arr);
        assertArrayEquals(expectedValue, arr);
    }

    @Test
    public void mooreITest() {
        int[] arr1 = {1, 2, 2, 2, 2, 4};
        int[] arr2 = {1, 2, 3, 2, 2, 4};
        int candidate1 = source.mooreI(arr1);
        int candidate2 = source.mooreI(arr2);

        assertEquals(2, candidate1);
        assertEquals(-1, candidate2);
    }

    @Test
    public void mooreIITest() {
        int[] arr1 = {20, 30, 10, 10, 5, 4, 20, 1, 2};
        int[] arr2 = {10, 10, 20, 30, 10, 10};

        int[] expected1 = {-1, -1};
        int[] expected2 = {10, -1};

        assertArrayEquals(expected1, source.mooreII(arr1));
        assertArrayEquals(expected2, source.mooreII(arr2));
    }

    @Test
    public void sellStockTest() {
        int[] arr = {7, 1, 3, 4, 6, 2};
        assertEquals(5, source.bestTimeToSellStock(arr));
    }

    @Test
    public void findInsertPositionTest() {
        int[] arr = {1, 2, 3, 5};

        assertEquals(4, source.findInsertPosition(arr, 6));
        assertEquals(0, source.findInsertPosition(arr, 0));
        assertEquals(3, source.findInsertPosition(arr, 4));
    }

    @Test
    public void candyDistributionTest() {
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {5, 4, 3, 2, 1};

        assertEquals(10, source.candyDistribution(arr1));
        assertEquals(15, source.candyDistribution(arr2));
        assertEquals(15, source.candyDistribution(arr3));
    }

    @Test
    public void gasStationTest() {
        List<Integer> gas1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> cost1 = new ArrayList<>(List.of(3, 4, 5, 1, 2));

        List<Integer> gas2 = new ArrayList<>(List.of(2, 3, 4));
        List<Integer> cost2 = new ArrayList<>(List.of(3, 4, 3));

        assertEquals(3, source.gasStation(gas1, cost1));
        assertEquals(-1, source.gasStation(gas2, cost2));
    }

    @Test
    public void maximumSlindingTest() {
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr2 = {1};
        List<Integer> result1 = new ArrayList<>(List.of(3, 3, 5, 5, 6, 7));

        assertEquals(result1, source.maximumSlidingWindow(arr1, 3));
        assertEquals(new ArrayList<>(List.of(1)), source.maximumSlidingWindow(arr2, 1));
    }

    @Test
    public void squareSortedArrayTest() {
        int[] arr1 = {-4, -1, 0, 3, 10};
        int[] arr2 = {-7, -3, 2, 3, 11};

        int[] expected1 = {0, 1, 9, 16, 100};
        int[] expected2 = {4, 9, 9, 49, 121};

        assertArrayEquals(expected1, source.squaredSortedArray(arr1));
        assertArrayEquals(expected2, source.squaredSortedArray(arr2));
    }

    @Test
    public void rotate90Test() {
        int[][] arr1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] expected1 = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};

        source.rotateArray90(arr1);
        assertArrayEquals(expected1, arr1);
    }

    @Test
    public void jagglingLeftShiftTest() {
        int[] arr1 = {1, 2, 3, 4, 5, 6}; // 4 5 6 1 2 3
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8}; //  5 6 7 8 1 2 3 4

        int[] expected1 = {4, 5, 6, 1, 2, 3};
        int[] expected2 = {5, 6, 7, 8, 1, 2, 3, 4};

        source.jagglingLeftSift(arr1, 3);
        source.jagglingLeftSift(arr2, 4);

        assertArrayEquals(expected1, arr1);
        assertArrayEquals(expected2, arr2);
    }

    @Test
    public void longestNonRepeatedSubStringTest() {
        assertEquals(3, source.longestNonRepeatedSubString("dvdf"));
        assertEquals(3, source.longestNonRepeatedSubString("apple"));
        assertEquals(4, source.longestNonRepeatedSubString("title"));
    }

    @Test
    public void matchedStringTest() {
        String txt1 = "onionsplonions";
        String pat1 = "onion";

        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(new ArrayList<>(List.of(0, 5)));
        expected1.add(new ArrayList<>(List.of(8, 13)));

        assertEquals(expected1, source.matchedString(txt1, pat1));
    }

    @Test
    public void mergeIntervalTest() {

        int[][] arr1 = {{3, 4}, {5, 6}, {8, 10}, {2, 5}};
        int[][] arr2 = {{8, 10}, {15, 18}, {2, 3}, {1, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 6}};

        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(new ArrayList<>(List.of(2, 5)));
        expected1.add(new ArrayList<>(List.of(5, 6)));
        expected1.add(new ArrayList<>(List.of(8, 10)));

        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(new ArrayList<>(List.of(1, 6)));
        expected2.add(new ArrayList<>(List.of(8, 10)));
        expected2.add(new ArrayList<>(List.of(15, 18)));

        assertEquals(expected1, source.mergeInterval(arr1));
        assertEquals(expected2, source.mergeInterval(arr2));
    }

    @Test
    public void tripletsTest() {

        int[] arr1 = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(new ArrayList<>(List.of(-1, -1, 2)));
        expected1.add(new ArrayList<>(List.of(-1, 0, 1)));

        assertEquals(expected1, source.triplets(arr1));
    }

    @Test
    public void waveArrayTest() {
        ArrayList<Integer> test1 = new ArrayList<>(List.of(2, 3, 4, 1));
        ArrayList<Integer> test2 = new ArrayList<>(List.of(2, 3, 4, 1, 9, 99));

        List<Integer> expected1 = new ArrayList<>(List.of(2, 1, 4, 3));
        List<Integer> expected2 = new ArrayList<>(List.of(2, 1, 4, 3, 99, 9));

        assertEquals(expected1, source.waveArray(test1));
        assertEquals(expected2, source.waveArray(test2));
    }

    @Test
    public void findFirstRepeatingElementTest() {
        int[] test1 = {1, 5, 3, 4, 3, 5, 6};
        int[] test2 = {1, 2, 3, 4};

        assertEquals(2, source.firstRepeatingElement(test1, test1.length));
        assertEquals(-1, source.firstRepeatingElement(test2, test2.length));
    }

    @Test
    public void leadersArrayTest() {
        int[] test1 = {16, 17, 4, 3, 5, 2};
        int[] test2 = {1, 2, 3, 4, 0};

        ArrayList<Integer> expected1 = new ArrayList<>(List.of(17, 5, 2));
        ArrayList<Integer> expected2 = new ArrayList<>(List.of(4, 0));

        assertEquals(expected1, source.leadersInAnArray(test1, test1.length));
        assertEquals(expected2, source.leadersInAnArray(test2, test2.length));
    }

    @Test
    public void reverseArrayInGroupTest() {
        ArrayList<Integer> test1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ArrayList<Integer> test2 = new ArrayList<>(List.of(5, 6, 8, 9));

        ArrayList<Integer> expected1 = new ArrayList<>(List.of(3, 2, 1, 5, 4));
        ArrayList<Integer> expected2 = new ArrayList<>(List.of(8, 6, 5, 9));

        source.reverseArrayInGroup(test1, test1.size(), 3);
        source.reverseArrayInGroup(test2, test2.size(), 3);

        assertEquals(expected1, test1);
        assertEquals(expected2, test2);
    }

    @Test
    public void missingNumberTest() {
        int[] test1 = {1, 2, 3, 5};
        int[] test2 = {6, 1, 2, 8, 3, 4, 7, 10, 5};

        assertEquals(source.missingNumber(test1, 5), 4);
        assertEquals(source.missingNumber(test2, 10), 9);
    }

    @Test
    public void firstElementKTimeTest() {
        int[] test1 = {1, 7, 4, 3, 4, 8, 7};
        assertEquals(source.firstElementKTime(test1, test1.length, 2), 4);
    }

    @Test
    public void reverseWordTest() {
        String str1 = "i.like.this.program.very.much";
        String result = "much.very.program.this.like.i";

        assertEquals(result, source.reverseWord(str1));
    }

    @Test
    public void removeDuplicatesTest() {
        String test = "zvvo";
        assertEquals(source.removeDuplicatesString(test), "zvo");
    }

    @Test
    public void isSubsetTest() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5};

        assertTrue(source.isSubset(arr1, arr2));
    }

    @Test
    public void removeDuplicatesInSortedArrayTest() {
        int[] arr1 = {1,1};
        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};

        assertEquals(source.removeDuplicatesInSortedArray(arr1), 1);
        assertEquals(source.removeDuplicatesInSortedArray(arr2), 5);
    }

    @Test
    public void unCommonElementTest() {
        assertEquals(source.unCommonCharacters("arunvijay","arunvj"), "iy");
        assertEquals(source.unCommonCharacters("test","test"), "-1");
    }

    @Test
    public void findMaxConsecutiveOnesTest() {
        assertEquals(source.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}), 3);
        assertEquals(source.findMaxConsecutiveOnes(new int[]{1,1,1,1,1,1}), 6);
        assertEquals(source.findMaxConsecutiveOnes(new int[]{0}), 0);
    }

    @Test
    public void parenthesisCheckerTest() {
        assertFalse(source.parenthesisChecker("[({[([{}])]})}"));
        assertTrue(source.parenthesisChecker("[{}]"));
        assertTrue(source.parenthesisChecker("{([])}"));
        assertFalse(source.parenthesisChecker("}]){(["));
    }

    @Test
    public void findOnceTest() {
        int[] arr1 = {1,2,2,3,3};
        int[] arr2 = {1,1,2,2,3};
        int[] arr3 = {1,1,2,3,3};
        assertEquals(source.findOnce(arr1, arr1.length), 1);
        assertEquals(source.findOnce(arr2, arr2.length), 3);
        assertEquals(source.findOnce(arr3, arr3.length), 2);
    }

    @Test
    public void mergeSortedArrayITest() {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        int[] arr3 = {1};
        int[] arr4 = {};
        source.mergeSortedArrayI(arr1, arr2, 3, 3);
        source.mergeSortedArrayI(arr3, arr4, 1, 0);
        assertArrayEquals(arr1,new int[]{1,2,2,3,5,6});
        assertArrayEquals(arr3, new int[]{1});
    }

    @Test
    public void mergeSortedArrayIITest() {
        int[] arr1 = {4,5,6};
        int[] arr2 = {1,2,3};

        source.mergeSortedArrayII(arr1, arr2);
        assertArrayEquals(arr1, new int[]{1,2,3});
        assertArrayEquals(arr2, new int[]{4,5,6});
    }

    @Test
    public void findLongestConseqSubseqTest() {
        int[] arr1 = {2,6,1,9,4,5,3};
        int[] arr2 = {1,9,3,10,4,20,2};
        int[] arr3 = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 8, 9};

        assertEquals(source.findLongestConseqSubseq(arr1, arr1.length), 6);
        assertEquals(source.findLongestConseqSubseq(arr2, arr2.length), 4);
        assertEquals(source.findLongestConseqSubseq(arr3, arr3.length), 9);
    }

    @Test
    public void isAnagramTest() {
        assertTrue(source.isAnagram("geeksforgeek", "geekforgeeks"));
        assertFalse(source.isAnagram("test","testt"));
    }

    @Test
    public void heapSortTest() {
        int[] arr = {5,4,3,2,1};
        source.heapSort(arr, arr.length);
        assertArrayEquals(arr, new int[]{1,2,3,4,5});
    }

    @Test
    public void laststoneweightTest() {
        int[] arr = {2,7,4,1,8,1};
        assertEquals(source.lastStoneWeight(arr), 1);
        assertEquals(source.lastStoneWeight(new int[]{1}), 1);
    }

    @Test
    public void minimumIndexedCharacterTest() {
        assertEquals(source.minimumIndexCharacter("geeksforgeeks", "set"), 1);
        assertEquals(source.minimumIndexCharacter("adcffaet", "onkl"), -1);
    }

    @Test
    public void commonElementsTest() {
        assertEquals(source.commonElements(new ArrayList<>(List.of(3, 4, 2, 2, 4)),
                new ArrayList<>(List.of(3,2,2,7))), new ArrayList<>(List.of(2,2,3)));

        assertEquals(source.commonElements(new ArrayList<>(List.of(2, 2, 2, 2, 2)),
                new ArrayList<>(List.of(3,3))), new ArrayList<>(List.of()));
    }

    @Test
    public void findDuplicatesTest() {
        assertEquals(source.findDuplicates(new int[]{4,3,2,7,8,2,3,1}), new ArrayList<>(List.of(2,3)));
    }

    @Test
    public void formLargestElementTest() {
        String[] str1 = {"3", "30", "34", "5", "9"};
        String[] str2 = {"54", "546", "548", "60"};
        assertEquals(source.formLargestElement(str1), "9534330");
        assertEquals(source.formLargestElement(str2), "6054854654");
    }

    @Test
    public void countDistinctWindowTest() {
        int[] num1 =  {1,2,1,3,4,2,3};
        int k1 = 4;
        ArrayList<Integer> result1 = new ArrayList<>(List.of(3,4,4,3));

        int[] num2 = {4,1,1};
        int k2 = 2;
        ArrayList<Integer> result2 = new ArrayList<>(List.of(2, 1));

        assertEquals(source.countDistinctWindow(num1, num1.length, k1), result1);
        assertEquals(source.countDistinctWindow(num2, num2.length, k2), result2);
    }

    @Test
    public void fibonacciTest() {
        assertEquals(source.fibonacci(5, new HashMap<>()), 5);
        assertEquals(source.fibonacci(50, new HashMap<>()), 12586269025L);
        assertEquals(source.fibonacci(3, new HashMap<>()), 2);
    }

    @Test
    public void gridTravellerTest() {
        assertEquals(source.gridTraveller(30, 30, new HashMap<>()), 51542064);
        assertEquals(source.gridTraveller(2, 3, new HashMap<>()), 3);
    }

    @Test
    public void coinChangeITest() {
        int[] coins1 = {1,2,5};
        int[] coins2 = {2};
        int[] coins3 = {1};

        assertEquals(source.coinChangeI(coins1, 11), 3);
        assertEquals(source.coinChangeI(coins1, 100), 20);
        assertEquals(source.coinChangeI(coins2, 3), -1);
        assertEquals(source.coinChangeI(coins3, 0), 0);
    }

    @Test
    public void coinChangeIITest() {
        int[] coins1 = {1,2,5};
        int[] coins2 = {2};
        int[] coins3 = {10};

        assertEquals(source.coinChangeII(coins1, 5), 4);
        assertEquals(source.coinChangeII(coins2, 3), 0);
        assertEquals(source.coinChangeII(coins3, 10), 1);
    }

    @Test
    public void combinationITest() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        source.combinationI(candidates, 0, target, new ArrayList<>(), result);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of(2,2,3)));
        expected.add(new ArrayList<>(List.of(7)));
        assertEquals(result, expected);
    }

    @Test
    public void knapsack0by1Test() {
        int[] values1 = {1,2,3};
        int[] weight1 = {4,5,1};

        int[] values2 = {1,2,3};
        int[] weight2 = {4,5,6};

        assertEquals(source.knapsack0by1(4, weight1, values1, 3), 3);
        assertEquals(source.knapsack0by1(3, weight2, values2, 3), 0);
    }

    @Test
    public void longestCommonSubsequenceTest() {
        assertEquals(source.longestCommonSubsequence("ABCDGH", "AEDFHR"), 3);
        assertEquals(source.longestCommonSubsequence("ABC", "AC"), 2);
    }

    @Test
    public void longestCommonSubstringTest() {
        assertEquals(source.longestCommonSubstring("ABCDGH", "ACDGHR"), 4);
        assertEquals(source.longestCommonSubstring("ABC", "ACB"), 1);
    }

    @Test
    public void minPathSumTest() {
        int[][] grid1 = {{1,3,1}, {1,5,1}, {4,2,1}};
        int[][] grid2 = {{1,2,3},{4,5,6}};
        assertEquals(source.minPathSum(grid1, 0,0,new HashMap<>()), 7);
        assertEquals(source.minPathSum(grid2, 0,0,new HashMap<>()), 12);
    }

    @Test
    public void longestPalindromeSubsequenceTest() {
        assertEquals(source.longestPalindromeSubsequence("bbbab"), 4);
        assertEquals(source.longestPalindromeSubsequence("cbbd"), 2);
    }

    @Test
    public void formPalindromeUsingMinimumInsertionTest() {
        assertEquals(source.formPalindromeUsingMinimumInsertion("abcd"), 3);
        assertEquals(source.formPalindromeUsingMinimumInsertion("aa"), 0);
    }

    @Test
    public void flamesProgramTest() {
        assertEquals(source.flamesFun("arun", "vijay"), "e");
    }

    @Test
    public void continuousSubarraySumTest(){
        int[] arr1 = {1,2,3,7,5};
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};

        assertEquals(source.continuousSubarraySum(arr1, 12), true);
        assertEquals(source.continuousSubarraySum(arr2, 15), true);
        assertEquals(source.continuousSubarraySum(arr1, 9), false);
    }

    @Test
    public void activitySelectionTest() {
        int[] start1 = {2,1};
        int[] end1 = {2,2};
        int[] start2 = {1,3,2,5};
        int[] end2 = {2,4,3,6};

        assertEquals(source.activitySelection(start1, end1), 1);
        assertEquals(source.activitySelection(start2, end2), 3);
    }

    @Test
    public void findPairInTwoSortedArraysTest() {
        int[] arr1 = {1, 4, 5, 7};
        int[] arr2 = {10, 20, 30, 40};
        int target1 = 32;
        int target2 = 50;

        assertEquals(source.findPairInTwoSortedArrays(arr1, arr2, target1), "1 30");
        assertEquals(source.findPairInTwoSortedArrays(arr1, arr2, target2), "7 40");
    }

    @Test
    public void rearrangeArrayAlternatively() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5,6};

        source.rearrangeArrayAlternatively(arr1);
        source.rearrangeArrayAlternatively(arr2);

        assertArrayEquals(arr1, new int[]{5,1,4,2,3});
        assertArrayEquals(arr2, new int[]{6,1,5,2,4,3});
    }

    @Test
    public void zigzagTest() {
        int[] arr1 = {4, 3, 7, 8, 6, 2, 1};
        int[] arr2 = {1, 4, 3, 2};
        source.zigzagArray(arr1);
        source.zigzagArray(arr2);
        assertArrayEquals(arr1, new int[]{3,7,4,8,2,6,1});
        assertArrayEquals(arr2, new int[]{1,4,2,3});
    }

    @Test
    public void shellsortTest(){
        int[] arr1 = {5,4,3,2,1};
        source.shellsort(arr1);
        assertArrayEquals(arr1, new int[]{1,2,3,4,5});
    }

    @Test
    public void searchSortedArray() {
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] arr2 = {3, 5, 1, 2};
        assertEquals(source.searchSortedArray(arr1,10), 5);
        assertEquals(source.searchSortedArray(arr2, 6), -1);
    }

    @Test
    public void largestSubarrayZeroSumTest() {
        int[] arr1 = {15,-2,2,-8,1,7,10,23};
        int[] arr2 = {0,0,0,0,1,1,1};
        assertEquals(source.largestSubarrayZeroSum(arr1), 5);
        assertEquals(source.largestSubarrayZeroSum(arr2),4);
    }

    @Test
    public void minimumPlatformTest() {
        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};

        int[] arr2 = {900, 1100, 1235};
        int[] dep2 = {1000, 1200, 1240};

        assertEquals(source.minimumPlatform(arr1, dep1), 3);
        assertEquals(source.minimumPlatform(arr2, dep2), 1);
    }

    @Test
    public void subarraySumTest(){
        int[] arr1 = {1,1,1};
        int[] arr2 = {1,2,3};

        assertEquals(source.subarraySum(arr1, 2), 2);
        assertEquals(source.subarraySum(arr2, 3), 2);
    }

    @Test
    public void generateParenthesisTest() {
        List<String> list = new ArrayList<>();
        source.backtrack(list,"",0,0,3);
        assertEquals(list, new ArrayList<>(List.of("((()))", "(()())", "(())()", "()(())", "()()()")));
    }

    @Test
    public void getRowTest() {
        assertEquals(source.getRow(3), new ArrayList<>(List.of(1,3,3,1)));
        assertEquals(source.getRow(0), new ArrayList<>(List.of(1)));
    }

    @Test
    public void generateTest() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(List.of(1)));
        result.add(new ArrayList<>(List.of(1,1)));
        result.add(new ArrayList<>(List.of(1,2,1)));
        result.add(new ArrayList<>(List.of(1,3,3,1)));

        assertEquals(source.generate(4), result);
    }

    @Test
    public void maxProfitTest() {
        int[] arr1 = {7,1,5,3,6,4};
        int[] arr2 = {1,2,3,4,5};

        assertEquals(source.maxProfit(arr1), 7);
        assertEquals(source.maxProfit(arr2), 4);
    }

    @Test
    public void orangesRottingTest() {
        int[][] arr1 =  {{2,1,1},{1,1,0},{0,1,1}};
        int[][] arr2 =  {{2,1,1},{0,1,1},{1,0,1}};

        assertEquals(source.orangesRotting(arr1), 4);
        assertEquals(source.orangesRotting(arr2), -1);
    }

    @Test
    public void mergeKSortedArraysTest() {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> result = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        assertEquals(source.mergeKSortedArrays(arr, 3), result);
    }

    @Test
    public void findsumTest() {
        int[] arr1 = {4,2,-3,1,6};
        int[] arr2 = {4,2,0,1,6};

        assertTrue(source.findsum(arr1, 5));
        assertTrue(source.findsum(arr2, 5));
    }

    @Test
    public void longestCommonPrefixTest() {
        String[] str1 = {"flower","flow","flight"};
        String[] str2 = {"dog","racecar","car"};

        assertEquals(source.longestCommonPrefix(str1), "fl");
        assertEquals(source.longestCommonPrefix(str2), "");
    }

    @Test
    public void relativeSortTest() {
        int[] arr1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] arr2 = {2, 1, 8, 3};
        int[] result = {2,2,1,1,8,8,3,5,6,7,9};
        assertArrayEquals(source.relativeSort(arr1, arr2), result);
    }

    @Test
    public void rotateRightTest() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5,6};
        int[] result1 = {4,5,1,2,3};
        int[] result2 = {4,5,6,1,2,3};
        source.rotateRight(arr1, 2);
        source.rotateRight(arr2,3);

        assertArrayEquals(arr1, result1);
        assertArrayEquals(arr2, result2);
    }

    @Test
    public void topKFrequentTest() {
        String[] str1 = {"i","love","leetcode","i","love","coding"};
        List<String> result1 = new ArrayList<>(List.of("i","love"));
        String[] str2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> result2 = new ArrayList<>(List.of("the","is","sunny","day"));
        assertEquals(source.topKFrequent(str2, 4), result2);
    }

    @Test
    public void setMatrixTest() {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        source.setZeroes(matrix);
        int[][] result = {{1,0,1},{0,0,0},{1,0,1}};
        assertArrayEquals(matrix, result);
    }

    @Test
    public void groupAnagramTest() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>(List.of("eat", "tea", "ate")));
        result.add(new ArrayList<>(List.of("bat")));
        result.add(new ArrayList<>(List.of("tan", "nat")));

        assertEquals(source.groupAnagrams(strs), result);
    }

    @Test
    public void rainTrapTest() {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};
        assertEquals(source.trap(height1), 6);
        assertEquals(source.trap(height2), 9);
    }

    @Test
    public void findSwapValuesTest() {
       long[] A = {4, 1, 2, 1, 1, 2};
       long[] B = {3, 6, 3, 3};
       assertEquals(source.findSwapValues(A, A.length, B, B.length), 1);
    }

    @Test
    public void canArrangeTest() {
        int[] arr1 = {1,2,3,4,5,10,6,7,8,9};
        int[] arr2 = {1,2,3,4,5,6,7};
        assertTrue(source.canArrange(arr1, 5));
        assertFalse(source.canArrange(arr2, 7));
    }

    @Test
    public void permutationITest() {
        int[] nums1 = {1,2,3};
        List<List<Integer>> actual = new ArrayList<>();
        source.permutationI(nums1, 0, nums1.length-1, actual);
        System.out.println(actual);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(List.of(1,2,3)));
        result.add(new ArrayList<>(List.of(1,3,2)));
        result.add(new ArrayList<>(List.of(2,1,3)));
        result.add(new ArrayList<>(List.of(2,3,1)));
        result.add(new ArrayList<>(List.of(3,2,1)));
        result.add(new ArrayList<>(List.of(3,1,2)));

        assertEquals(actual, result);
    }
}