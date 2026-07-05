# 81. Search in Rotated Sorted Array II

## Pattern
Modified Binary Search (Rotated Array with Duplicates)

## Recognition
- Sorted array rotated at an unknown pivot.
- **Duplicates are allowed.**
- Need to determine whether the target exists.
- Binary search needs extra handling for duplicates.

## Core Idea
Similar to Problem 33, but duplicates introduce ambiguity.

Normally, one half is sorted. However, if:

```text
nums[low] == nums[mid] == nums[high]
```

you cannot determine which half is sorted.

In this case:
- Increment `low`
- Decrement `high`

Otherwise, proceed exactly like Problem 33.

## Algorithm
1. Initialize `low = 0`, `high = n - 1`.
2. While `low <= high`:
   - Compute `mid`.
   - If target found, return `true`.
   - If `nums[low] == nums[mid] == nums[high]`:
     - `low++`
     - `high--`
   - Else determine the sorted half.
   - Check whether the target lies in the sorted half.
3. Return `false`.

## Pseudocode

```java
low = 0
high = n - 1

while(low <= high):

    mid = low + (high - low) / 2

    if(nums[mid] == target)
        return true

    if(nums[low] == nums[mid] &&
       nums[mid] == nums[high]):

        low++
        high--

    else if(nums[low] <= nums[mid]):

        if(nums[low] <= target &&
           target < nums[mid])
            high = mid - 1
        else
            low = mid + 1

    else:

        if(nums[mid] < target &&
           target <= nums[high])
            low = mid + 1
        else
            high = mid - 1

return false
```

## Key Syntax

```java
if(nums[low] == nums[mid] &&
   nums[mid] == nums[high]){

    low++;
    high--;
}

int mid = low + (high - low) / 2;

return true;

return false;
```

## Complexity

### Average Case
Time: O(log n)

### Worst Case
Time: O(n)

Space: O(1)

## Why Worst Case Becomes O(n)?

Example:

```text
[1,1,1,1,1,1,1]
```

or

```text
[1,1,1,3,1]
```

Since:

```text
nums[low] == nums[mid] == nums[high]
```

you cannot discard half of the array.

You only shrink the search space by one element from each end:

```java
low++;
high--;
```

In the worst case, this takes **O(n)** time.

## Template Insight

Whenever:
- Rotated sorted array.
- Duplicates are present.

Think:

1. Handle duplicate ambiguity.
2. Otherwise, apply the same logic as Problem 33.

## Similar Problems

- 33. Search in Rotated Sorted Array
- 153. Find Minimum in Rotated Sorted Array
- 154. Find Minimum in Rotated Sorted Array II
- Binary Search

## Revision (15 sec)

- Same as Problem 33.
- Extra case:
  - `low == mid == high`
  - `low++`, `high--`
- Otherwise identify the sorted half.
- Average: O(log n)
- Worst: O(n)
