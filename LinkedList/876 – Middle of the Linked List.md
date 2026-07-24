# 876. Middle of the Linked List

## Pattern
Slow & Fast Pointer (Tortoise and Hare)

## Recognition
- Find the middle node of a linked list.
- O(n) time and O(1) space expected.
- If there are two middle nodes, return the **second** middle.

## Core Idea
Maintain two pointers:

- `slow` → moves **1 step** at a time.
- `fast` → moves **2 steps** at a time.

When `fast` reaches the end of the list, `slow` will be at the middle.

## Algorithm
1. Initialize:
   - `slow = head`
   - `fast = head`
2. While `fast != null` and `fast.next != null`:
   - Move `slow` by one step.
   - Move `fast` by two steps.
3. Return `slow`.

## Pseudocode

```java
slow = head
fast = head

while(fast != null &&
      fast.next != null):

    slow = slow.next

    fast = fast.next.next

return slow
```

## Key Syntax

```java
ListNode slow = head;
ListNode fast = head;

while(fast != null &&
      fast.next != null){

    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

## Complexity

Time: O(n)

Space: O(1)

## Template Insight

Whenever:
- Find the middle of a linked list.
- Need two pointers moving at different speeds.
- Single traversal required.

Think:

**Slow = 1 step**

**Fast = 2 steps**

When `fast` reaches the end → `slow` is at the middle.

## Why Does This Work?

Example:

```text
1 → 2 → 3 → 4 → 5

S
F
```

After first iteration:

```text
1 → 2 → 3 → 4 → 5
    S
        F
```

After second iteration:

```text
1 → 2 → 3 → 4 → 5
        S
                F
```

`fast` reaches the end.

Return:

```text
3
```

Even-length example:

```text
1 → 2 → 3 → 4 → 5 → 6
```

Pointers end as:

```text
slow → 4
fast → null
```

Return:

```text
4
```

This matches the problem requirement to return the **second middle node**.

## Common Mistakes

❌ Using:

```java
while(fast.next != null)
```

This may cause a `NullPointerException`.

Correct:

```java
while(fast != null &&
      fast.next != null)
```

---

❌ Moving both pointers by one step.

```java
slow = slow.next;
fast = fast.next;
```

This makes both pointers move at the same speed, so `slow` won't end at the middle.

## Similar Problems

- 141. Linked List Cycle
- 142. Linked List Cycle II
- 234. Palindrome Linked List
- 143. Reorder List
- 19. Remove Nth Node From End of List

## Revision (15 sec)

- Two pointers: `slow` and `fast`.
- `slow` moves 1 step.
- `fast` moves 2 steps.
- When `fast` reaches the end, `slow` is at the middle.
- Returns the second middle for even-length lists.
- O(n), O(1).
