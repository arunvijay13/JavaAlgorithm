package Algorithm;

import java.util.*;

public class AlgorithmUtil implements Program {

      /*
            Bubble sort is a sorting algorithm that compares two adjacent
            elements and swaps them until they are not in the intended order.

            Best Case Complexity: O(n)
      */
      @Override
      public void bubbleSort(int[] arr) {
            int arrLength = arr.length;
            for(int i=0;i<arrLength;i++){
                  for(int j=i+1;j<arrLength;j++){
                        if(arr[i] > arr[j]){
                              swap(arr,i,j);
                        }
                  }
            }
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
            for(int i=1;i<arrlength;i++){
                  int temp = arr[i];
                  for(int j=i-1;j>=0;j--){
                        if(temp < arr[j]){
                              arr[j+1] = arr[j];
                              arr[j] = temp;
                        }
                  }
            }
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
            for(int i=0;i<arrLength;i++){
                  int min = arr[i];
                  pos = i;
                  for(int j=i+1;j<arrLength;j++){
                        if(min > arr[j]){
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
      public void quickSort(int[] arr,int lb,int ub) {
            if(lb < ub){
                  int pos = quickPartition(arr,lb,ub);
                  quickSort(arr,lb,pos-1);
                  quickSort(arr,pos+1,ub);
            }
      }

      /*
            Merge Sort is one of the most popular sorting algorithms
            that is based on the principle of Divide and Conquer Algorithm.

            Best Case Complexity : O(n*log n)
      */

      @Override
      public void mergeSort(int[] arr,int lb,int ub) {
            if(lb < ub){
                  int mid = (lb+ub)/2;
                  mergeSort(arr,lb,mid);
                  mergeSort(arr,mid+1,ub);
                  mergePartition(arr,lb,ub,mid);
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
            for(int i:arr){
                  if(max < i){
                        max = i;
                  }
            }

            int[] count = new int[max+1];

            for(int i:arr){
                  count[i]++;
            }

            for(int i=1;i<=max;i++){
                  count[i] += count[i-1];
            }

            int[] result = new int[arrLength+1];

            for(int i=arrLength-1;i>=0;i--){
                  result[--count[arr[i]]] = arr[i];
            }

            System.arraycopy(result, 0, arr, 0, arrLength);
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
            for(int i=0;i<arrLength;i++){
                  if(i != 0 && arr[i] == arr[i-1]){
                        continue;
                  }
                  if(arr[i] <= 0){
                        target = arr[i];
                  }else{
                        break;
                  }
                  int left = i+1    ;
                  int right = arrLength-1;
                  while(left <  right){
                        int sum = arr[left] + arr[right];
                        if(sum == Math.abs(target)){
                              result.add(new ArrayList<>(List.of(arr[i],arr[left],arr[right])));
                              left++;
                              right--;
                              while(left < right && arr[left] == arr[left-1]) left++;
                              while(left < right && arr[right] == arr[right+1]) right--;
                        } else if(sum < Math.abs(target)){
                              left++;
                        } else{
                              right--;
                        }
                  }
            }
            return result;
      }

      /*
            Dynamic program to merge the interval at O(n) time complexity
       */
      @Override
      public List<List<Integer>> mergeInterval(int[][] arr) {
            Arrays.sort(arr, (a,b) -> {
                  if(a[0] == b[0])
                        return b[0];
                  else
                        return a[0]-b[0];
            });

            List<List<Integer>> result = new ArrayList<>();

            int min = arr[0][0];
            int max = arr[0][1];

            for(int i=1;i<arr.length;i++){
                  if(max > arr[i][0]){
                       max =  Math.max(arr[i][1],max);
                  }else{
                        result.add(new ArrayList<>(List.of(min,max)));
                        min = arr[i][0];
                        max = arr[i][1];
                  }
            }

            result.add(new ArrayList<>(List.of(min,max)));

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
            while(i < n){
                  if(txt.charAt(i) == pat.charAt(j)){
                        i++;
                        j++;
                  } else {
                        if(j != 0){
                              j = lps[j-1];
                        }else{
                              i++;
                        }
                  }
                  if(j == m){
                        result.add(new ArrayList<>(List.of((i-j),(i-j+m))));
                        j  = lps[j-1];
                  }
            }
            return result;
      }

      private int[] compute(String pat) {
            int[] lps = new int[pat.length()];
            int len = 0;
            int j = 1;
            while(j < pat.length()){
                  if(pat.charAt(len) == pat.charAt(j)){
                        lps[j] = len+1;
                        len++;
                        j++;
                  }else{
                        if(len != 0){
                              len = lps[len-1];
                        } else{
                              lps[j] = 0;
                              j++;
                        }
                  }
            }
            return lps;
      }

      /*
            You are given an array of integers nums, there is a sliding window of size k
            which is moving from the very left of the array to the very right.
            You can only see the k numbers in the window. Each time the sliding window moves right by one position.

            Return the max sliding window.

            Time complexity O(n)
       */
      @Override
      public List<Integer> maximumSlidingWindow(int[] arr,int k) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            List<Integer> result =  new ArrayList<>();

            int i = 0;
            for(;i<k;i++){
                  while(!queue.isEmpty() && arr[queue.peekLast()] < arr[i])
                        queue.removeLast();
                  queue.addLast(i);
            }

            int j=0;
            for(;i<arr.length;i++){
                  result.add(arr[queue.peekFirst()]);

                  while(!queue.isEmpty() && queue.peekFirst() <= j){
                        queue.removeFirst();
                  }

                  while(!queue.isEmpty() && arr[queue.peekLast()] < arr[i]){
                        queue.removeLast();
                  }
                  queue.addLast(i);
                  j++;
            }

            result.add(arr[queue.peekFirst()]);

            return result;
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
            while(j < n){
                  if(!result.contains(txt.charAt(j))){
                        result.add(txt.charAt(j));
                        max = Math.max(result.size(),max);
                        j++;
                  }else{
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
            int right = arr.length-1;

            for(int i= arr.length-1;i>=0;i--){
                  if(Math.abs(arr[left]) < Math.abs(arr[right])){
                        results[i] = arr[right] * arr[right];
                        right--;
                  }else{
                        results[i] = arr[left] * arr[left];
                        left++;
                  }
            }
            return results;
      }

      /*
         Kadane's algorithm is able to find the
         maximum sum of a contiguous subarray in an array with a runtime of O(n)
       */
      @Override
      public int maxSum(int[] arr) {
            int maxSum = Integer.MIN_VALUE;
            int currSum = 0;
            for(int i:arr){
                  currSum += i;
                  currSum = Math.max(currSum,i);
                  maxSum = Math.max(currSum,maxSum);
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
            for(int i:arr){
                  if(count == 0){
                        candidate = i;
                  }

                  if(candidate == i) count++;
                  else count--;
            }

            count = 0;
            boolean valid = false;
            for(int i:arr){
                  if(candidate == i) count++;
                  if(count > (size / 2)) {
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
            Arrays.fill(result,-1);

            for(int i:arr) {
                  if(candidate1 == i) {
                        count1++;
                  } else if(candidate2 == i) {
                        count2++;
                  } else if(count1 == 0) {
                        candidate1 = i;
                        count1 = 1;
                  } else if(count2 == 0) {
                        candidate2 = i;
                        count2 = 1;
                  } else {
                        count1--;
                        count2--;
                  }
            }


            count1 = 0;
            count2 = 0;
            for(int i:arr){
                  if(candidate1 == i){
                       count1++;
                  }else if(candidate2 == i){
                        count2++;
                  }
            }

            if(count1 > size) result[0] = candidate1;
            if(count2 > size) result[1] = candidate2;

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

            for(int i:arr){
                  if(min > i){
                        min = i;
                  }else if((i-min) > profit){
                        profit = i-min;
                  }
            }
            return profit;
      }

      @Override
      public int findInsertPosition(int[] arr, int element) {
            int low = 0;
            int high = arr.length-1;

            while(low <= high){
                  int mid = (low + high) / 2;

                  if(arr[mid] <  element){
                        low = mid+1;
                  } else if(arr[mid] >  element) {
                        high = mid-1;
                  } else{
                        return mid;
                  }
            }
            return high+1;
      }

      /*
            Binary search is an efficient searching algorithm.
            search elements in O(log n)
       */
      @Override
      public int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length-1;
            while(low <= high){
                  int mid = (low + high) / 2;
                  if(arr[mid] < target){
                        low = mid+1;
                  } else if(arr[mid] > target) {
                        high = mid-1;
                  } else{
                        return mid;
                  }
            }
            return  -1;
      }

      /*
            KthLargest method used to find kth largest element in array.
            priorityqueue is used which sort the element in descending order
            and return element from maximum to minimum.
       */
      @Override
      public int kthLargestElement(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
            for(int i:arr){
                  pq.offer(i);
            }
            int count = 1;
            while(count != k) {
                  pq.poll();
                  count++;
            }
            try{
                  return pq.poll();
            } catch (NullPointerException E){
                  return -1;
            }

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

            for(int i=0;i<gas.size();i++){
                  diff[i] = gas.get(i) - cost.get(i);
            }
            int sum = Arrays.stream(diff).sum();

            if(sum < 0){
                  return -1;
            } else {
                  int starting = 0;
                  int tank = 0;
                  for(int i=0;i<gas.size();i++) {
                        tank = tank + gas.get(i) - cost.get(i);
                        if(tank < 0){
                              starting = i+1;
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
            Arrays.fill(result,1);

            // forward check eg: condition1: if rating are in ascending order
            // rating = [1,2,3,4,5]  ---> chocalate calculated =  [1,2,3,4,5]
            for(int i=1;i<result.length;i++){
                  if(studentsRating[i] > studentsRating[i-1])
                  result[i] = result[i-1] + 1;
            }

            // reverse check eg: condition2:  if rating are in descending order
            // rating = [5,4,3,2,1] ---> chocalate calculated = [5,4,3,2,1]
            for(int i=result.length-1;i>0;i--){
                  if(studentsRating[i-1] > studentsRating[i] && result[i] >= result[i-1])
                        result[i-1] = result[i] + 1;
            }

            return Arrays.stream(result).sum();
      }

      /*
            it will left shift the array without using inbuilt function or
            collections method

            Time complexity = O(n)
       */
      @Override
      public void jagglingLeftSift(int[] arr,int k) {
            int j = 0;
            int temp;
            int d;
            int n = arr.length;
            for(int i=0;i<gcd(k,n);i++){
                  j=i;
                  temp = arr[i];
                  while(true){
                        d = (j+k) % n;
                        if(i == d) break;
                        arr[j] = arr[d];
                        j = d;
                  }
                  arr[j] = temp;
            }
      }

      private int gcd(int a, int b) {
            if(b == 0){
                  return a;
            }else{
                  return gcd(a,a%b);
            }
      }

      /*
            This method used to rotate array in 90
            time complexity = O(n)
            space complexity = O(1)
       */
      @Override
      public void rotateArray90(int[][] arr) {
            int row = arr.length-1;
            int column = arr.length-1;

            for(int i=0;i<row;i++){
                  for(int j=i+1;j<=column;j++){
                        int temp = arr[i][j];
                        arr[i][j] = arr[j][i];
                        arr[j][i] = temp;
                  }
            }

            for(int i=0;i<=row;i++){
                  int start = 0;
                  int end = column;
                  while(start <  end){
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

            for(int i:arr){
                  if(0 == i) count0++;
                  else if(1 == i) count1++;
            }

            for(int i=0;i<arr.length;i++){
                if(count0 != 0) {
                      arr[i] = 0;
                      count0--;
                } else if(count1 != 0){
                      arr[i] = 1;
                      count1--;
                } else {
                      arr[i] = 2;
                }
            }

      }

      private void mergePartition(int[] arr, int lb, int ub, int mid) {
            int[] result = new int[lb+ub+1];
            int left = lb;
            int right = mid+1;
            int k = lb;

            while(left <= mid && right <= ub){
                  if(arr[left] < arr[right]){
                        result[k] = arr[left];
                        left++;
                  }else{
                        result[k] = arr[right];
                        right++;
                  }
                  k++;
            }

            while(left <= mid){
                  result[k] = arr[left];
                  left++;
                  k++;
            }

            while(right <= ub){
                  result[k] = arr[right];
                  right++;
                  k++;
            }

            if (ub + 1 - lb >= 0) System.arraycopy(result, lb, arr, lb, ub + 1 - lb);
      }

      private int quickPartition(int[] arr,int lb,int ub){
            int pivot = arr[ub];
            int start = lb;

            for(int i=lb;i<ub;i++){
                  if(arr[i] < pivot){
                        swap(arr,i,start);
                        start++;
                  }
            }
            swap(arr,start,ub);
            return start;
      }

      private void swap(int[] arr,int pos1,int pos2){
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
      }
}
