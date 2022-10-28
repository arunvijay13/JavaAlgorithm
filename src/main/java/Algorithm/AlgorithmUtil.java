package Algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class AlgorithmUtil implements Program {

    private HashSet<Integer> set;
    private final static PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);
    private final static PriorityQueue<Integer> minpq = new PriorityQueue<>();
    private static int count = 0;

    public static void insertHeap(int x) {
        if (maxpq.isEmpty() || x <= maxpq.peek()) {
            maxpq.offer(x);
        } else {
            minpq.offer(x);
        }
        count++;
        balanceHeaps();
    }

    //Function to balance heaps.
    public static void balanceHeaps() {
        if (maxpq.size() - minpq.size() == -1) {
            maxpq.offer(minpq.poll());
        } else if (maxpq.size() - minpq.size() == 2) {
            minpq.offer(maxpq.poll());
        }
    }

    //Function to return Median.
    public static double getMedian() {
        if (count % 2 == 0) {
            return (double) (maxpq.peek() + minpq.peek()) / 2d;
        } else {
            return (double) maxpq.peek();
        }
    }

    /*
              Bubble sort is a sorting algorithm that compares two adjacent
              elements and swaps them until they are not in the intended order.

              Best Case Complexity: O(n)
        */
    @Override
    public void bubbleSort(int[] arr) {
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++) {
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /*
        Input:
        N = 5, S = 12
        A[] = {1,2,3,7,5}
        Output: 2 4
        Explanation: The sum of elements from 2nd position to 4th position is 12.
     */
    @Override
    public boolean continuousSubarraySum(int[] nums, int k) {
        int left = 0, sum = 0;

        for(int i:nums){
            sum += i;
            while(sum > k) sum -= nums[left++];
            if(sum == k) return true;
        }

        return false;
    }

    /*
     sort arrays in O(N*logN) time complexity and O(1) space complexity
     */
    @Override
    public void shellsort(int[] arr) {
        int n = arr.length;
        for(int gap=n/2;gap>0;gap=gap/2){
            for(int j=gap;j<n;j++){
                for(int i=j-gap;i>=0;i=i-gap){
                    if(arr[i] < arr[i+gap]){
                        break;
                    } else {
                        int temp = arr[i+gap];
                        arr[i+gap] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
    }

    /*
            Input:
            N = 7
            Arr[] = {4, 3, 7, 8, 6, 2, 1}
            Output: 3 7 4 8 2 6 1
            Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1

            time complexity = O(N), space complexity = O(1)
         */
    @Override
    public void zigzagArray(int[] arr) {
        int n = arr.length;
        for(int i=1;i<n;i+=2) {
            if(arr[i-1] > arr[i]){
                swap(arr, i-1, i);
            }
            if(i+1 < n && arr[i] < arr[i+1]) {
                swap(arr, i, i+1);
            }
        }
    }

    /*
            Input: N = 6
            arr[] = {1,2,3,4,5,6}
            Output: 6 1 5 2 4 3
            Explanation: Max element = 6, min = 1, second max = 5, second min = 2, and so on...
            Modified array is : 6 1 5 2 4 3.

            To above operations in without extra space
            time complexity = O(N), space complexity = O(1)
         */
    @Override
    public void rearrangeArrayAlternatively(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt() + 1;
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int pos = 0;
        while(left <= right) {
            if(pos%2 == 0)
                arr[pos] = arr[pos] + ((arr[right--] % max) * max);
            else
                arr[pos] = arr[pos] + ((arr[left++] % max) * max);
            pos = pos + 1;
        }

        for(int i=0;i<n;i++) {
            arr[i] = arr[i] / max;
        }
    }

    /*
            Input:  ar1[] = {1, 4, 5, 7};
            ar2[] = {10, 20, 30, 40};
            x = 32
            Output:  1 and 30

            Time complexity = O(N)
            Space complexity = O(1)
         */
    @Override
    public String findPairInTwoSortedArrays(int[] arr1, int[] arr2, int target) {
        int left = 0;
        int right = arr2.length-1;
        int minDiff = Integer.MAX_VALUE;
        int pair1 = -1;
        int pair2 = -1;
        while(left < arr1.length && right>=0){
            int diff = arr1[left] + arr2[right] - target;
            if(Math.abs(diff) < minDiff){
                minDiff = Math.abs(diff);
                pair1 = arr1[left];
                pair2 = arr2[right];
            }

            if(diff < 0){
                left++;
            } else{
                right--;
            }
        }

        return pair1+" "+pair2;
    }

    /*
            we have to choose maximum activity performed by the user at single day.
            Input: N = 2
            start[] = {2, 1}
            end[] = {2, 2}

            Output: 1
            Explanation: A person can perform only one of the given activities.

            Time complexity = O(N * logN)
            Space complexity = O(N)
         */
    @Override
    public int activitySelection(int[] start, int[] end) {
        int n = start.length;
        Activity[] activity = new Activity[n];

        for(int i=0;i<n;i++) {
            activity[i] = new Activity(start[i], end[i]);
        }

        Arrays.sort(activity, Comparator.comparingInt(a -> a.end));

        int ends = activity[0].end;

        int count = 1;
        for(int i=1;i<n;i++) {
            if(ends < activity[i].start) {
                count++;
                ends = activity[i].end;
            }
        }

        return count;
    }

    /*
           Fun program, it will find a relationship between two user
        */
    @Override
    public String flamesFun(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        for(String i : str1.split("")) {
            map1.put(i, map1.getOrDefault(i,0)+1);
        }

        int count = 0;

        for(String i : str2.split("")) {
            if(map1.get(i) == null) {
                count++;
            } else{
                map1.compute(i, (k,v) -> v=v-1);
            }

            if(map1.get(i) != null  && map1.get(i) <= 0) {
                map1.remove(i);
            }
        }

        count = count + map1.size() - 1;

        StringBuffer builder = new StringBuffer("flames");

        int limit = builder.length();
        int start = 0;
        int index;

        while(builder.length() != 1) {
            index = (start + count) % limit;
            builder.deleteCharAt(index);
            limit = limit - 1;
            start = index;
        }

        return builder.toString();
    }

    /*
                Input:
                N = 7, K = 4

                A[] = {1,2,1,3,4,2,3}
                Output: 3 4 4 3

                Explanation: Window 1 of size k = 4 is
                1 2 1 3. Number of distinct elements in this window are 3.
                Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
                Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
                Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.

             */
    @Override
    public ArrayList<Integer> countDistinctWindow(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        for(;i<k;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int j = 0;
        for(;i<n;i++) {
            result.add(map.size());
            if(map.containsKey(arr[j])) {
                if(map.get(arr[j]) > 1) {
                    map.put(arr[j], map.get(arr[j])-1);
                } else {
                    map.remove(arr[j]);
                }
            }
            j++;
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        result.add(map.size());
        return result;
    }

    /*
        It uses memoziation, so time complexity reduced from (2^n) times to O(n) times.
        space complexity is O(H). Height of tree
     */
    @Override
    public long fibonacci(long n, HashMap<Long, Long> map) {

        if(n == 0 || n == 1) {
            return n;
        }

        if(map.containsKey(n))
            return map.get(n);

        long total = fibonacci(n-1, map) + fibonacci(n-2, map);
        map.putIfAbsent(n, total);

        return total;
    }

    /*
                      Insertion sort is a sorting algorithm that places an
                      unsorted element at its suitable place in each iteration.
            I           Insertion sort works similarly as we sort cards in our hand in a card game.

                      We assume that the first card is already sorted then, we select an unsorted card.
                      If the unsorted card is greater than the card in hand, it is placed on the right otherwise, to the left.
                      In the same way, other unsorted cards are taken and put in their right place.

                      Best Case Complexity: O(n)
                */
    @Override
    public void insertionSort(int[] arr) {
        int arrlength = arr.length;
        for (int i = 1; i < arrlength; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /*
    Input: str = geeksforgeeks
    patt = set

    Output: 1

    Explanation: e is the character which is present in given str "geeksforgeeks"
    and is also presen in patt "set". Minimum index of e is 1.
     */
    @Override
    public int minimumIndexCharacter(String str, String pat) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.putIfAbsent(str.charAt(i), i);
        }

        int max = Integer.MAX_VALUE;

        for (char i : pat.toCharArray()) {
            if (map.containsKey(i))
                max = Math.min(max, map.get(i));
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    /*
        Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
        some elements appear twice and others appear once.
        Find all the elements that appear twice in this array.

        Could you do it without extra space and in O(n) runtime?

        Input: [4,3,2,7,8,2,3,1]
        Output: [2,3]
     */
    @Override
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for(int i:arr) {
            if (arr[Math.abs(i) - 1] < 0) {
                result.add(Math.abs(i));
            } else {
                arr[Math.abs(i) - 1] *= -1;
            }
        }
        return result;
    }

    /*
        Input:
        N = 5
        Arr[] = {3, 30, 34, 5, 9}
        Output: 9534330

        Explanation: Given numbers are {3, 30, 34, 5, 9}
        the arrangement 9534330 gives the largest value.
     */
    @Override
    public String formLargestElement(String[] str) {
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));
        return String.join("",str);
    }

    /*
                Input:
                n = 5
                v1[] = {3, 4, 2, 2, 4}
                m = 4
                v2[] = {3, 2, 2, 7}

                Output: 2 2 3
                Explanation:  The common elements in sorted order are {2 2 3}
             */
    @Override
    public List<Integer> commonElements(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i:list1) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int i:list2) {
            if(map.containsKey(i)) {
                if(map.get(i) > 0) {
                    result.add(i);
                    map.put(i, map.get(i)-1);
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        return result;
    }

    /*
                If x == y, both stones are destroyed, and
                If x != y, the stone of weight x is destroyed,
                and the stone of weight y has new weight y - x.

                Input: stones = [2,7,4,1,8,1]
                Output: 1

                Explanation:
                We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
                we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
                we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
                we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
             */
    @Override
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i : stones) {
            pq.offer(i);
        }

        while (pq.size() > 1) {
            int largest1 = pq.poll();
            int largest2 = pq.poll();

            if (largest1 != largest2) {
                pq.offer(Math.abs(largest1 - largest2));
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    /*
              Selection sort is a sorting algorithm that selects the
              smallest element from an unsorted list in each iteration and
              places that element at the beginning of the unsorted list.

              Best Case Complexity: O(n2)
        */
    @Override
    public void selectionSort(int[] arr) {
        int arrLength = arr.length;
        int pos;
        for (int i = 0; i < arrLength; i++) {
            int min = arr[i];
            pos = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    pos = j;
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
        }
    }

    /*
          Quicksort is a sorting algorithm based on the divide and conquer approach

          Best Case Complexity [Big-omega]: O(n*log n)
    */
    @Override
    public void quickSort(int[] arr, int lb, int ub) {
        if (lb < ub) {
            int pos = quickPartition(arr, lb, ub);
            quickSort(arr, lb, pos - 1);
            quickSort(arr, pos + 1, ub);
        }
    }

    /*
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     */
    @Override
    public void mergeSortedArrayI(int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

      /*
            Merge Sort is one of the most popular sorting algorithms
            that is based on the principle of Divide and Conquer Algorithm.

            Best Case Complexity : O(n*log n)
            Space Complextity : O(n)
      */

    @Override
    public void mergeSort(int[] arr, int lb, int ub) {
        if (lb < ub) {
            int mid = (lb + ub) / 2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid + 1, ub);
            mergePartition(arr, lb, ub, mid);
        }
    }

    /*
          Counting sort is a sorting algorithm that sorts the elements of an array by counting the
          number of occurrences of each unique element in the array.
          The count is stored in an auxiliary array and the sorting is
          done by mapping the count as an index of the auxiliary array.

          Best Case Complexity: O(n+k)
    */
    @Override
    public void countingSort(int[] arr) {
        int max = arr[0];
        int arrLength = arr.length;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }

        int[] count = new int[max + 1];

        for (int i : arr) {
            count[i]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[arrLength + 1];

        for (int i = arrLength - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
        }

        System.arraycopy(result, 0, arr, 0, arrLength);
    }

    /*
        Given a sorted array arr[] of size N. Find the element that appears only once in the array.
        All other elements appear exactly twice.

        Input:
        N = 11
        arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
        Output: 4
        Explanation: 4 is the only element that appears exactly once.
     */
    @Override
    public int findOnce(int[] arr, int n) {
        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (arr[i] != arr[j]) {
                return arr[i];
            }
            i += 2;
            j += 2;
        }
        return arr[i];
    }

    /*
              find triplets whose sum is equal to zero
         */
    @Override
    public List<List<Integer>> triplets(int[] arr) {
        int arrLength = arr.length;
        int target;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arrLength; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] <= 0) {
                target = arr[i];
            } else {
                break;
            }
            int left = i + 1;
            int right = arrLength - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == Math.abs(target)) {
                    result.add(new ArrayList<>(List.of(arr[i], arr[left], arr[right])));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;
                } else if (sum < Math.abs(target)) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    /*
        Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
        For Example:
        ab: Number of insertions required is 1. bab or aba
        aa: Number of insertions required is 0. aa
        abcd: Number of insertions required is 3. dcbabcd

        Input: str = "abcd"
        Output: 3
        Explanation: Inserted character marked with bold characters in dcbabcd

        Time and space complexity = O(n^2)
     */
    @Override
    public int formPalindromeUsingMinimumInsertion(String str) {
        return str.length() - longestPalindromeSubsequence(str);
    }

    /*
            Input: s = "bbbab"
            Output: 4
            Explanation: One possible longest palindromic subsequence is "bbbb".

            Time and space complexity = O(n^2)
         */
    @Override
    public int longestPalindromeSubsequence(String s) {
        String text1 = s;
        String text2 = new StringBuffer(s).reverse().toString();

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    /*
              Dynamic program to merge the interval at O(n) time complexity
         */
    @Override
    public List<List<Integer>> mergeInterval(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0])
                return b[0];
            else
                return a[0] - b[0];
        });

        List<List<Integer>> result = new ArrayList<>();

        int min = arr[0][0];
        int max = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i][0]) {
                max = Math.max(arr[i][1], max);
            } else {
                result.add(new ArrayList<>(List.of(min, max)));
                min = arr[i][0];
                max = arr[i][1];
            }
        }

        result.add(new ArrayList<>(List.of(min, max)));

        return result;

    }

    /*
          used to find matched string in O(n) time complexity
     */
    @Override
    public List<List<Integer>> matchedString(String txt, String pat) {
        int n = txt.length();
        int i = 0;
        int j = 0;
        int m = pat.length();
        int[] lps = compute(pat);
        List<List<Integer>> result = new ArrayList<>();
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == m) {
                result.add(new ArrayList<>(List.of((i - j), (i - j + m))));
                j = lps[j - 1];
            }
        }
        return result;
    }

    @Override
    public void reverseArrayInGroup(ArrayList<Integer> arr, int n, int k) {
        if (k == 1) {
            return;
        }

        if (k > n) {
            reverse(arr, 0, n - 1);
            return;
        }

        // find the rotation
        int rotation = n / k;
        int j = 0;
        for (int i = 0; i < rotation; i++) {
            reverse(arr, j, j + k - 1);
            j = j + k;
        }

        if (j < n) {
            reverse(arr, j, n - 1);
        }
    }

    @Override
    public List<Integer> waveArray(ArrayList<Integer> list) {
        Collections.sort(list);
        int pointer1 = 0;
        int pointer2 = 1;
        int n = list.size();

        while (pointer1 < n && pointer2 < n) {
            Collections.swap(list, pointer1, pointer2);
            pointer1 += 2;
            pointer2 += 2;
        }

        return list;
    }

    /*
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    @Override
    public void permutationI(int[] nums, int l, int r, List<List<Integer>> result) {
        if(l == r) {
            List<Integer> list = new ArrayList<>();
            for(int i:nums) {
                list.add(i);
            }
            result.add(list);
        } else {
            for(int i=l;i<=r;i++) {
                swap(nums, l, i);
                permutationI(nums, l+1, r, result);
                swap(nums, l, i);
            }
        }
    }

    /*
            Input: N = 6, M = 4
            A[] = {4, 1, 2, 1, 1, 2}
            B[] = (3, 6, 3, 3)
            Output: 1
            Explanation: Sum of elements in A[] = 11
            Sum of elements in B[] = 15, To get same
            sum from both arrays, we can swap following
            values: 1 from A[] and 3 from B[]
         */
    @Override
    public long findSwapValues(long[] A, int n, long[] B, int m) {
        long sum1 = Arrays.stream(A).sum();
        long sum2 = Arrays.stream(B).sum();

        if(sum1 == sum2)
            return 1;

        if((sum1-sum2)%2 != 0)
            return -1;

        long target = (sum1-sum2)/2L;

        if(target == 0)
            return -1;

        Arrays.sort(A);
        Arrays.sort(B);

        int left = 0;
        int right = 0;
        while(left < n && right < m) {
            if(A[left]-B[right] == target) {
                return 1;
            } else if (A[left]-B[right] < target) {
                left++;
            } else {
                right++;
            }
        }

        return -1;
    }

    /*
        Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
        Output: true
        Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

        - Keep count of remainders of all elements of arr
        - frequency[0] keeps all elements divisible by k, and a divisible of k can only form a group with other divisible of k.
          Hence, total number of such divisibles must be even.
        - for every element with remainder of i (i != 0) there should be a element with remainder k-i.
        Hence, frequency[i] should be equal to frequency[k-i]
     */
    @Override
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for(int i:arr) {
            int rem = i%k;
            if(rem<0) rem+=k;
            freq[rem]++;
        }

        if(freq[0]%2 != 0)
            return false;

        for(int i=1;i<=k/2;i++) {
            if(freq[i] != freq[k-i])
                return false;
        }
        return true;
    }

    private int[] compute(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0;
        int j = 1;
        while (j < pat.length()) {
            if (pat.charAt(len) == pat.charAt(j)) {
                lps[j] = len + 1;
                len++;
                j++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps;
    }

    /*
        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6
        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
        In this case, 6 units of rain water (blue section) are being trapped.
     */
    @Override
    public int trap(int[] arr) {
        int res = 0;
        int n = arr.length;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n-1;

        while(left < right) {
            if(arr[left] <= arr[right]) {
                if(arr[left] > leftMax){
                    leftMax = arr[left];
                } else {
                    res += (leftMax-arr[left]);
                }
                left += 1;
            } else {
                if(rightMax < arr[right]) {
                    rightMax = arr[right];
                } else {
                    res += (rightMax-arr[right]);
                }
                right -= 1;
            }
        }

        return res;
    }

    /*
              You are given an array of integers nums, there is a sliding window of size k
              which is moving from the very left of the array to the very right.
              You can only see the k numbers in the window. Each time the sliding window moves right by one position.

              Return the max sliding window.

              Time complexity O(n)
         */
    @Override
    public List<Integer> maximumSlidingWindow(int[] arr, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        int i = 0;
        for (; i < k; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i])
                queue.removeLast();
            queue.addLast(i);
        }

        int j = 0;
        for (; i < arr.length; i++) {
            result.add(arr[queue.peekFirst()]);

            while (!queue.isEmpty() && queue.peekFirst() <= j) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            j++;
        }

        result.add(arr[queue.peekFirst()]);

        return result;
    }

    /*
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(String i:strs) {
            String[] temp = i.split("");
            Arrays.sort(temp);
            String str = String.join("", temp);
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(i);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    /*
        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]
     */
    @Override
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean isFirstColHaveZero = false;

        for(int i=0;i<rows;i++) {
            if(matrix[i][0] == 0) isFirstColHaveZero = true;
            for(int j=1;j<cols;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=rows-1;i>=0;i--) {
            for(int j=cols-1;j>=1;j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(isFirstColHaveZero)
                matrix[i][0] = 0;
        }

    }

    /*
            Input: words = ["i","love","leetcode","i","love","coding"], k = 2
            Output: ["i","love"]
            Explanation: "i" and "love" are the two most frequent words.
            Note that "i" comes before "love" due to a lower alphabetical order.
         */
    @Override
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String i: words) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Map.Entry<String, Integer>> list = map.entrySet()
                .stream()
                .sorted((a,b) -> {
                    if(a.getValue() == b.getValue())
                        return a.getKey().compareTo(b.getKey());
                    return b.getValue() - a.getValue();
                })
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> temp : list) {
            if(k-- > 0){
                result.add(temp.getKey());
            }
        }

        return result;
    }

    /*
            Input: [1,2,3,4,5],  k =2
            output: [5,4,1,2,3]
         */
    @Override
    public void rotateRight(int[] arr, int k) {
        int n = arr.length;
        rotateRightHelper(arr, 0, n-1);
        rotateRightHelper(arr, 0, k-1);
        rotateRightHelper(arr, k, n-1);
    }

    private void rotateRightHelper(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    @Override
    public boolean isAnagram(String a, String b) {
        if (a.length() == b.length()) {
            LinkedHashMap<Character, Integer> list1 = new LinkedHashMap<>();
            LinkedHashMap<Character, Integer> list2 = new LinkedHashMap<>();

            for (char i : a.toCharArray()) {
                list1.put(i, list1.getOrDefault(i, 0) + 1);
            }

            for (char i : b.toCharArray()) {
                list2.put(i, list2.getOrDefault(i, 0) + 1);
            }

            HashSet<Character> set = new HashSet<>();
            for (char i : a.toCharArray()) {
                set.add(i);
            }

            for (char element : set) {
                if (!list1.get(element).equals(list2.get(element))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /*
        Input:
        N = 11
        M = 4
        A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
        A2[] = {2, 1, 8, 3}
        Output:
        2 2 1 1 8 8 3 5 6 7 9
        Explanation: Array elements of A1[] are
        sorted according to A2[]. So 2 comes first
        then 1 comes, then comes 8, then finally 3
        comes, now we append remaining elements in
        sorted order.
     */
    @Override
    public int[] relativeSort(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = arr1.length;
        int m = arr2.length;

        for(int i:arr1) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        int[] result = new int[n];

        // elements are sorted based on another array
        int left = 0;
        for(int i:arr2) {
            if(map.containsKey(i)) {
                int count = map.get(i);
                while(count-- > 0) {
                    result[left++] = i;
                }
                map.remove(i);
            }
        }

        // remaining elements are should be arranged in ascending order
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            while(count-- > 0) {
                result[left++] = entry.getKey();
            }
        }

        return result;
    }

    /*
            Input: strs = ["flower","flow","flight"]
            Output: "fl"
         */
    @Override
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        if(strs.length == 1)
            return strs[0];

        StringBuilder prefix = new StringBuilder();

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        for(int i=0;i<strs[0].length();i++) {
            for(int j=1;j<strs.length;j++) {
                if(strs[0].charAt(i) != strs[j].charAt(i))
                    return prefix.toString();
            }
            prefix.append(strs[0].charAt(i));
        }

        return prefix.toString();
    }

    /*
            Input:
            5
            4 2 -3 1 6
            Output: Yes
            Explanation:
            2, -3, 1 is the subarray with sum 0.
         */
    @Override
    public boolean findsum(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i:arr) {
            sum = sum +i;

            if(set.contains(sum) || sum == 0 || i == 0) return true;
            set.add(sum);
        }
        return false;
    }

    /*
            Input:
            K = 3
            arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
            Output: 1 2 3 4 5 6 7 8 9
            Explanation:Above test case has 3 sorted
            arrays of size 3, 3, 3
            arr[][] = [[1, 2, 3],[4, 5, 6],
            [7, 8, 9]]
            The merged list will be
            [1, 2, 3, 4, 5, 6, 7, 8, 9].
         */
    @Override
    public ArrayList<Integer> mergeKSortedArrays(int[][] arr, int K) {
        int[] arr1 = arr[0];
        for(int i=1;i<arr.length;i++) {
            arr1 = merge(arr1, arr[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<arr1.length;i++) {
            result.add(arr1[i]);
        }

        return result;
    }

    /*
        You are given an m x n grid where each cell can have one of three values:

        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

        Return the minimum number of minutes that must elapse until no cell has a fresh orange.
        If this is impossible, return -1.
         */
    @Override
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                    //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }

    /*
            Input: prices = [7,1,5,3,6,4]
            Output: 7

            Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
            Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
            Total profit is 4 + 3 = 7.
         */
    @Override
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=1;i<prices.length;i++) {
            if(prices[i-1] < prices[i])
                profit += prices[i]-prices[i-1];
        }

        return profit;
    }

    /*
            Input: rowIndex = 3
            Output: [1,3,3,1]
         */
    @Override
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int[] A = new int[rowIndex+1];
        A[0] = 1;

        for(int i=1;i<=rowIndex;i++) {
            for(int j=i;j>=1;j--) {
                A[j] += A[j-1];
            }
        }
        for(int i:A){
            result.add(i);
        }
        return result;
    }

    /*
        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    @Override
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> sublist = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j == 0 || j == i){
                    sublist.add(1);
                }else{
                    sublist.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(sublist);
        }
        return list;
    }

    /*
            Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
            Input: n = 3
            Output: ["((()))","(()())","(())()","()(())","()()()"]
         */
    @Override
    public void backtrack(List<String> result, String current_str, int open, int close, int max) {
        if(current_str.length() == max*2) {
            result.add(current_str);
            return;
        }

        if(open < max) backtrack(result, current_str+"(",open+1, close, max);
        if(close < open) backtrack(result, current_str+")",open, close+1, max);
    }

    /*
                Input:
                N = 7
                a[] = {2,6,1,9,4,5,3}
                Output: 6

                Explanation:
                The consecutive numbers here are 1, 2, 3, 4, 5, 6.
                These 6 numbers form the longest consecutive subsquence.
                 */
    @Override
    public int findLongestConseqSubseq(int[] arr, int n) {
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < n; i++) {

            if (arr[i] - arr[i - 1] == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                if (arr[i] - arr[i - 1] != 0) {
                    count = 1;
                }
            }
        }
        return Math.max(max, count);
    }

    /*
        Input: n = 6
        arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
        dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
        Output: 3

        Explanation:
        Minimum 3 platforms are required to safely arrive and depart all trains.

        Expected Time Complexity: O(nLogn)
        Expected Auxiliary Space: O(n)
     */
    @Override
    public int minimumPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformNeeded = 1;
        int result = 1;
        int j = 0;
        int i=1;
        int n = arr.length;

        while(i<n && j<n) {
            if(dep[j] >= arr[i]){
                platformNeeded += 1;
                i++;
            } else {
                platformNeeded -= 1;
                j++;
            }

            result = Math.max(result, platformNeeded);
        }

        return result;
    }

    /*
        Input: nums = [1,1,1], k = 2
        Output: 2

        Time Complexity = O(N)
        Space Complexity = O(N)
     */
    @Override
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);

        for(int i:nums) {
            sum += i;
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);

        }

        return count;
    }

    /*
                Input:
                N = 8
                A[] = {15,-2,2,-8,1,7,10,23}
                Output: 5
                Explanation: The largest subarray with sum 0 will be -2 2 -8 1 7.

                Expected Time Complexity: O(N).
                Expected Auxiliary Space: O(N).
             */
    @Override
    public int largestSubarrayZeroSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        int n = arr.length;
        for(int i=0;i<n;i++) {
            sum += arr[i];
            if(sum == 0){
                result = i+1;
            } else {
                if(map.containsKey(sum)) {
                    result = Math.max(result, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return result;
    }

    /*
            Input:
            N = 9
            A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
            key = 10
            Output: 5
            Explanation: 10 is found at index 5.

            Expected Time Complexity: O(log N).
            Expected Auxiliary Space: O(1).
         */
    @Override
    public int searchSortedArray(int[] A, int key) {
        int low = 0;
        int high = A.length-1;
        while(low <= high){
            int mid = (low+high)/2;

            if(A[mid] == key){
                return mid;
            } else if(A[low] <= A[mid]) {
                if(A[low] <= key && key <= A[mid]){
                    high=mid-1;
                } else {
                    low=mid+1;
                }
            } else {
                if(A[mid] <= key && key <= A[high]){
                    low = mid+1;
                } else {
                    high=mid-1;
                }
            }
        }

        return -1;
    }

    /*
                Input:
                n = 4, arr1[] = [1 3 5 7]
                m = 5, arr2[] = [0 2 6 8 9]

                Output:
                arr1[] = [0 1 2 3]
                arr2[] = [5 6 7 8 9]

                Explanation:
                After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
             */
    @Override
    public void mergeSortedArrayII(int[] arr1, int[] arr2) {
        int i = 0;
        int n = arr1.length;

        while (arr1[n - 1] > arr2[0]) {
            if (i >= n) {
                break;
            }
            if (arr1[i] > arr2[0]) {
                int temp = arr1[0];
                arr1[0] = arr2[i];
                arr2[i] = temp;
                Arrays.sort(arr2);
            }
            i++;
        }
    }

    /*
             Used do find longest substring in O(n) time complexity
         */
    @Override
    public int longestNonRepeatedSubString(String txt) {
        int i = 0;
        int j = 0;
        int n = txt.length();
        int max = Integer.MIN_VALUE;
        HashSet<Character> result = new HashSet<>();
        while (j < n) {
            if (result.add(txt.charAt(j))) {
                max = Math.max(result.size(), max);
                j++;
            } else {
                result.remove(txt.charAt(i));
                i++;
            }
        }
        return max;
    }

    /*
          Given an integer array nums sorted in non-decreasing order,
          return an array of the squares of each number sorted in non-decreasing order.

          Time complexity = O(n)
     */
    @Override
    public int[] squaredSortedArray(int[] arr) {
        int[] results = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (Math.abs(arr[left]) < Math.abs(arr[right])) {
                results[i] = arr[right] * arr[right];
                right--;
            } else {
                results[i] = arr[left] * arr[left];
                left++;
            }
        }
        return results;
    }

    /*
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.
     */
    @Override
    public int coinChangeI(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i == 0)
                    dp[i][j] = Integer.MAX_VALUE-1;
                else if(j == 0)
                    dp[i][j] = 0;
                else if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }

        return dp[n][m] == Integer.MAX_VALUE-1 ? -1 : dp[n][m];
    }

    /*
        Input: amount = 5, coins = [1,2,5]
        Output: 4
        Explanation: there are four ways to make up the amount:
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1

        Return the number of combinations that make up that amount.
        If that amount of money cannot be made up by any combination of the coins, return 0.
     */
    @Override
    public int coinChangeII(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i == 0)
                    dp[i][j] = 0;
                else if(j == 0)
                    dp[i][j] = 1;
                else if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }

        return dp[n][m];
    }


    /*
        Input: S1 = "ABCDGH",
        S2 = "ACDGHR",
        n = 6, m = 6
        Output: 4
        Explanation: The longest common substring is "CDGH" which has length 4.

        Time Complexity = O(n*m)
        space complexity = O(n*m)
     */
    @Override
    public int longestCommonSubstring(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        int max = 0;

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }

    /*
            Input: text1 = "abcde", text2 = "ace"
            Output: 3
            Explanation: The longest common subsequence is "ace" and its length is 3.

            Time complexity = O(n1 * n2)   n1 and n2 are length of the string
         */
    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        int x = text1.length();
        int y = text2.length();

        int[][] dp = new int[x+1][y+1];


        for(int i=0;i<=x;i++) {
            for(int j=0;j<=y;j++) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[x][y];
    }

    /*
            Input:
            N = 3
            W = 4
            values[] = {1,2,3}
            weight[] = {4,5,1}
            Output: 3

            You cannot break an item, either pick the complete item or dont pick it (0-1 property)
         */
    @Override
    public int knapsack0by1(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];
        Pair[] pair = new Pair[n];

        for(int i=0;i<n;i++){
            pair[i] = new Pair(val[i], wt[i]);
        }

        Arrays.sort(pair, Comparator.comparingInt(a -> a.weight));

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=W;j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (pair[i-1].weight > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], pair[i-1].profit+dp[i-1][j - pair[i-1].weight]);
            }
        }

        return dp[n][W];
    }

    /*
            Input: candidates = [2,3,6,7], target = 7
            Output: [[2,2,3],[7]]
            Explanation:
            2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
            7 is a candidate, and 7 = 7. These are the only two combinations.
         */
    @Override
    public void combinationI(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if(target == 0)
            result.add(new ArrayList<>(list));
        if(target < 0)
            return;

        for(int i=start;i<candidates.length;i++) {
            list.add(candidates[i]);
            combinationI(candidates, i, target-candidates[i], list, result);
            list.remove(list.size()-1);
        }
    }

    /*
        Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
        Output: 7
        Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     */
    @Override
    public int minPathSum(int[][] grid, int r, int c, HashMap<String, Integer> map) {
        if(r == grid.length-1 && c == grid[0].length-1)
            return grid[r][c];

        if(r >= grid.length || c >= grid[0].length)
            return Integer.MAX_VALUE;

        String key = r+" "+c;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int result = grid[r][c] + Math.min(minPathSum(grid, r+1, c, map), minPathSum(grid, r, c+1, map));
        map.put(key, result);

        return result;
    }

    /*
                    Robot initially placed at (0,0) location, it should be moved to right end of the grid.
                    we have to return all the possible combinations in grid.

                    Base condition:
                    if robot moves right, col will reduce. similarly if moves down row will reduce.
                    robot will move either right or down.

                    if both row and col are 1, it will return 1
                    if either of them are zero, then it won't react the rightmost corner

                    time complexity  = O(n+m) (using memoziation)
                    space  complexity = O(n+m)

                 */
    @Override
    public int gridTraveller(int r, int c, HashMap<String, Integer> map) {
        if(r == 1 && c == 1)
            return 1;
        if(r == 0 || c == 0)
            return 0;

        String key = r+" "+c;
        if(map.containsKey(key))
            return map.get(key);

        int total = gridTraveller(r-1, c, map) + gridTraveller(r, c-1, map);
        map.putIfAbsent(key, total);
        return total;
    }

    /*
           Kadane's algorithm is able to find the
           maximum sum of a contiguous subarray in an array with a runtime of O(n)
         */
    @Override
    public int maxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i : arr) {
            currSum += i;
            currSum = Math.max(currSum, i);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    /*
          moore voting algorithm 1 used to find single majority element
          whose count should be greater than n/2
          time complexity = O(n)
          space complexity = O(1)
     */
    @Override
    public int mooreI(int[] arr) {
        int candidate = -1;
        int count = 0;
        int size = arr.length;
        for (int i : arr) {
            if (count == 0) {
                candidate = i;
            }

            if (candidate == i) count++;
            else count--;
        }

        count = 0;
        boolean valid = false;
        for (int i : arr) {
            if (candidate == i) count++;
            if (count > (size / 2)) {
                valid = true;
                break;
            }
        }

        return valid ? candidate : -1;
    }

    /*
           moore voting algorithm 1 used to find two majority element
          whose count should be greater than n/3
          time complexity = O(n)
          space complexity = O(1)
     */
    @Override
    public int[] mooreII(int[] arr) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        int size = arr.length / 3;
        int[] result = new int[2];
        Arrays.fill(result, -1);

        for (int i : arr) {
            if (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }


        count1 = 0;
        count2 = 0;
        for (int i : arr) {
            if (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            }
        }

        if (count1 > size) result[0] = candidate1;
        if (count2 > size) result[1] = candidate2;

        return result;

    }

    /*
          maximum profit finding algorithm
          time complexity  = O(n)
     */
    @Override
    public int bestTimeToSellStock(int[] arr) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            if (min > i) {
                min = i;
            } else if ((i - min) > profit) {
                profit = i - min;
            }
        }
        return profit;
    }

    @Override
    public int findInsertPosition(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] < element) {
                low = mid + 1;
            } else if (arr[mid] > element) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return high + 1;
    }

    /*
          Binary search is an efficient searching algorithm.
          search elements in O(log n)
     */
    @Override
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /*
          Given an array arr[] of size n, find the first repeating element.
          The element should occurs more than once and the
          index of its first occurrence should be the smallest.

          n = 7
          arr[] = {1, 5, 3, 4, 3, 5, 6}
          Output: 2

          Explanation:
          5 is appearing twice and its first appearence is at index 2 which is
          less than 3 whose first occuring index is 3.
     */
    @Override
    public int firstRepeatingElement(int[] arr, int n) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int element = -1;

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                element = entry.getKey();
                break;
            }
        }

        // find the index position of repeated element
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                return i + 1;
            }
        }

        return -1;
    }

    /*
        Given an array A of positive integers. Your task is to find the leaders in the array.
        An element of array is leader if it is greater than or
        equal to all the elements to its right side.
        The rightmost element is always a leader.

        Input:
        n = 6
        A[] = {16,17,4,3,5,2}
        Output: 17 5 2

        Explanation: The first leader is 17 as it is greater than all the elements to its right.
        Similarly, the next leader is 5.
        The right most element is always a leader so it is also included.
     */
    @Override
    public ArrayList<Integer> leadersInAnArray(int[] arr, int n) {
        if (n == 1) {
            return new ArrayList<>(List.of(arr[0]));
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= result.get(result.size() - 1)) {
                result.add(arr[i]);
            }
        }

        Collections.reverse(result);
        return result;
    }

    /*
                KthLargest method used to find kth largest element in array.
                priorityqueue is used which sort the element in descending order
                and return element from maximum to minimum.
           */
    @Override
    public int kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : arr) {
            pq.offer(i);
        }
        int count = 1;
        while (count != k) {
            pq.poll();
            count++;
        }
        try {
            return pq.poll();
        } catch (NullPointerException E) {
            return -1;
        }

    }

    /*
    Input:
        a1[] = {11, 1, 13, 21, 3, 7}
        a2[] = {11, 3, 7, 1}
    Output:
        Yes
    Explanation:
        a2[] is a subset of a1[]
     */
    @Override
    public boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr2) set.add(i);
        for (int i : arr1) set.remove(i);
        return set.isEmpty();
    }

    /*
        Input:
        A = geeksforgeeks
        B = geeksquiz
        Output: fioqruz
        Explanation:
        The characters 'f', 'i', 'o', 'q', 'r', 'u','z'
        are either present in A or B, but not in both.
    */
    @Override
    public String unCommonCharacters(String A, String B) {
        TreeSet<String> set1 = new TreeSet<>();
        HashSet<String> set2 = new HashSet<>();
        for (String i : A.split("")) {
            set1.add(i);
        }
        for (String i : B.split("")) {
            set2.add(i);
        }
        Iterator<String> it = set2.iterator();
        while (it.hasNext()) {
            String element = it.next();
            if (!set1.add(element)) {
                set1.remove(element);
            }
        }
        return set1.isEmpty() ? "-1" : String.join("", set1);
    }

    @Override
    public int removeDuplicatesInSortedArray(int[] arr) {
        int j = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[j] != arr[i]) {
                j++;
            }
            arr[j] = arr[i];
        }
        return j + 1;
    }

    @Override
    public String removeDuplicatesString(String S) {
        String[] temp = S.split("");
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(temp));
        return String.join("", set);
    }

    @Override
    public String reverseWord(String S) {
        String[] str = S.split("\\.");
        int start = 0;
        int end = str.length - 1;
        while (start < end) {
            String temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.join(".", str);
    }

    @Override
    public int firstElementKTime(int[] a, int n, int k) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        if (k == 1) {
            return a[0];
        }
        for (int i : a) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                if (map.get(i) >= k) {
                    return i;
                }
            } else {
                map.put(i, 1);
            }
        }
        return -1;
    }

    /*
         There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

         You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the
         ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

         Given two integer arrays gas and cost, return the starting gas station's index
          if you can travel around the circuit once in the clockwise direction, otherwise ret
     */
    @Override
    public int gasStation(List<Integer> gas, List<Integer> cost) {
        int[] diff = new int[gas.size()];

        for (int i = 0; i < gas.size(); i++) {
            diff[i] = gas.get(i) - cost.get(i);
        }
        int sum = Arrays.stream(diff).sum();

        if (sum < 0) {
            return -1;
        } else {
            int starting = 0;
            int tank = 0;
            for (int i = 0; i < gas.size(); i++) {
                tank = tank + gas.get(i) - cost.get(i);
                if (tank < 0) {
                    starting = i + 1;
                    tank = 0;
                }
            }

            return starting;
        }
    }

    /*
     There are n children standing in a line. Each child is assigned a rating value
     given in the integer array ratings.

     You are giving candies to these children subjected to the following requirements:

         Each child must have at least one candy.
         Children with a higher rating get more candies than their neighbors.

     Return the minimum number of candies you need to have to distribute the candies to the children.
     */
    @Override
    public int candyDistribution(int[] studentsRating) {
        int[] result = new int[studentsRating.length];
        Arrays.fill(result, 1);

        // forward check eg: condition1: if rating are in ascending order
        // rating = [1,2,3,4,5]  ---> chocalate calculated =  [1,2,3,4,5]
        for (int i = 1; i < result.length; i++) {
            if (studentsRating[i] > studentsRating[i - 1])
                result[i] = result[i - 1] + 1;
        }

        // reverse check eg: condition2:  if rating are in descending order
        // rating = [5,4,3,2,1] ---> chocalate calculated = [5,4,3,2,1]
        for (int i = result.length - 1; i > 0; i--) {
            if (studentsRating[i - 1] > studentsRating[i] && result[i] >= result[i - 1])
                result[i - 1] = result[i] + 1;
        }

        return Arrays.stream(result).sum();
    }

    /*
          it will left shift the array without using inbuilt function or
          collections method

          Time complexity = O(n)
     */
    @Override
    public void jagglingLeftSift(int[] arr, int k) {
        int j;
        int temp;
        int d;
        int n = arr.length;
        for (int i = 0; i < gcd(k, n); i++) {
            j = i;
            temp = arr[i];
            while (true) {
                d = (j + k) % n;
                if (i == d) break;
                arr[j] = arr[d];
                j = d;
            }
            arr[j] = temp;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(a, a % b);
        }
    }

    /*
        Input: {([])}
        Output:  true
        Explanation:  { ( [ ] ) }.
        Same colored brackets can form balaced pairs, with 0 number of unbalanced bracket.
     */
    @Override
    public boolean parenthesisChecker(String str) {
        Stack<Character> stack = new Stack<>();
        for (char i : str.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else if ((!stack.isEmpty()) && ((stack.peek() == '(' && i == ')') ||
                    (stack.peek() == '[' && i == ']') ||
                    (stack.peek() == '{' && i == '}'))) {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        return stack.isEmpty();
    }

    /*
        HeapSort:
        Best Time Complexity : O(n log(n))
        Best Space Complexity : O(1)

        Applications:
        Systems concerned with security and embedded systems such as Linux Kernel
     */
    @Override
    public void heapSort(int[] arr, int n) {
        // heap should be build
        buildHeap(arr, n);

        // swap the last and first element
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    /*
                Input: nums = [1,1,0,1,1,1]
                Output: 3
                Explanation: The first two digits or the last three digits are consecutive 1s.
                The maximum number of consecutive 1s is 3.
             */
    @Override
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count; // set the maximum count value
                }
                count = 0;  // reset the count to zero always
            }
        }

        return Math.max(max, count);
    }

    /*
              This method used to rotate array in 90
              time complexity = O(n)
              space complexity = O(1)
         */
    @Override
    public void rotateArray90(int[][] arr) {
        int row = arr.length - 1;
        int column = arr.length - 1;

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j <= column; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i <= row; i++) {
            int start = 0;
            int end = column;
            while (start < end) {
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }
        }

    }

    /*
          sort the array having 0,1,2 without using any sorting algorithm
          time complexity = O(n)
          space complexity = O(1)
     */
    @Override
    public void sort0s1s2s(int[] arr) {
        int count0 = 0;
        int count1 = 0;

        for (int i : arr) {
            if (0 == i) count0++;
            else if (1 == i) count1++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (count0 != 0) {
                arr[i] = 0;
                count0--;
            } else if (count1 != 0) {
                arr[i] = 1;
                count1--;
            } else {
                arr[i] = 2;
            }
        }

    }

    private void mergePartition(int[] arr, int lb, int ub, int mid) {
        int[] result = new int[lb + ub + 1];
        int left = lb;
        int right = mid + 1;
        int k = lb;

        while (left <= mid && right <= ub) {
            if (arr[left] < arr[right]) {
                result[k] = arr[left];
                left++;
            } else {
                result[k] = arr[right];
                right++;
            }
            k++;
        }

        while (left <= mid) {
            result[k] = arr[left];
            left++;
            k++;
        }

        while (right <= ub) {
            result[k] = arr[right];
            right++;
            k++;
        }

        if (ub + 1 - lb >= 0) System.arraycopy(result, lb, arr, lb, ub + 1 - lb);
    }

    private int quickPartition(int[] arr, int lb, int ub) {
        int pivot = arr[ub];
        int start = lb;

        for (int i = lb; i < ub; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, start);
                start++;
            }
        }
        swap(arr, start, ub);
        return start;
    }

    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    /*
    Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N.
    Find the missing element.

    Input:
    N = 5
    A[] = {1,2,3,5}
    Output: 4
 */
    @Override
    public int missingNumber(int[] arr, int n) {
        int actualSum = 0;
        for (int i : arr) {
            actualSum += i;
        }
        int expectedSum = (n * (n + 1)) / 2;
        return expectedSum - actualSum;
    }

    private void reverse(ArrayList<Integer> arr, int pos1, int pos2) {
        while (pos1 < pos2) {
            Collections.swap(arr, pos1, pos2);
            pos1++;
            pos2--;
        }
    }

    //Function to build a Heap from array.
    private void buildHeap(int arr[], int n) {
        // no need to take leaf elements
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

    }

    //Heapify function to maintain heap property.
    private void heapify(int arr[], int n, int i) {
        int largest = i;
        // left child
        int leftchild = (2 * i) + 1;
        // right child
        int rightchild = (2 * i) + 2;

        if (leftchild < n && arr[largest] < arr[leftchild]) {
            largest = leftchild;
        }

        if (rightchild < n && arr[largest] < arr[rightchild]) {
            largest = rightchild;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int left = 0;
        int right = 0;
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[n+m];
        int k = 0;

        while(left < n && right < m) {
            if(arr1[left] <= arr2[right]){
                result[k] = arr1[left];
                left += 1;
            } else {
                result[k] = arr2[right];
                right += 1;
            }
            k += 1;
        }

        while(left < n) {
            result[k] = arr1[left];
            k += 1;
            left += 1;
        }

        while(right < m) {
            result[k] = arr2[right];
            k+=1;
            right += 1;
        }

        return result;
    }
}


class Pair {
    int profit;
    int weight;

    public Pair (int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

class Activity
{
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString(){
        return start+" "+end;
    }
}