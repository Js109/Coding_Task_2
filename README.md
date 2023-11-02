# MBTI_Coding_Task_2
This is the repository to provide the Coding Task 2 solution of Julian Stier.  
It is about implementing a function called merge which takes a list of intervals and returns a list of intervals as well. The result contains all overlapping intervals that are merged. 
All non-overlapping intervals remain untouched.

## Algorithm explanation

## What is the runtime of the program?
Since Collections.sort(intervalList) has a complexity of O(n log n) and the for loop has a complexity of O(n) the total complexity is also O(n).

## How can the robustness be ensured, especially with regard to very large inputs?
For larger input data sets, one solution can be to split the list of intervals into separate lists of intervals and merge each of these sub-interval lists separately, then merge them again at the end and apply merge again. Keyword: Multithreading

## How does the memory consumption of your program behave ?