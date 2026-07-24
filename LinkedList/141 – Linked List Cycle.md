# 141. Linked List Cycle

## Pattern
Slow & Fast Pointer (Floyd's Cycle Detection)

## Recognition
- Detect whether a linked list contains a cycle.
- O(n) time and O(1) space expected.
- Cannot use extra data structures like `HashSet`.

## Core Idea
Maintain two pointers:

- `slow` → moves **1 step** at a time.
- `fast` → moves **2 steps** at a time.

- If there is **no cycle**, `fast` reaches `null`.
- If there **is a cycle**, `fast` will eventually meet `slow`.

## Algorithm
1. Initialize:
   - `slow = head`
   - `fast = head`
2. While `fast != null` and `fast.next != null`:
   - Move `slow` by one step.
   - Move `fast` by two steps.
   - If `slow == fast`, return `true`.
3. If the loop ends, return `false`.

## Pseudocode

```java
slow = head
fast = head

while(fast != null &&
      fast.next != null):

    slow = slow.next

    fast = fast.next.next

    if(slow == fast)
        return true

return false
```

## Key Syntax

```java
ListNode slow = head;
ListNode fast = head;

while(fast != null &&
      fast.next != null){

    slow = slow.next;
    fast = fast.next.next;

    if(slow == fast)
        return true;
}

return false;
```

## Complexity

Time: O(n)

Space: O(1)

## Template Insight

Whenever:
- Detect a cycle in a linked list.
- Need constant extra space.
- Asked whether a cycle exists.

Think:

**Slow = 1 step**

**Fast = 2 steps**

If they meet → **Cycle exists**.

## Why Does This Work?

### No Cycle

```text
1 → 2 → 3 → 4 → null

slow -------->
fast -------------->
```

`fast` reaches `null`.

Return:

```text
false
```

---

### Cycle Exists

```text
1 → 2 → 3
    ↑     ↓
    5 ← 4
```

Eventually:

```text
slow == fast
```

Return:

```text
true
```

## Common Mistakes

❌ Comparing node values instead of node references.

Wrong:

```java
if(slow.val == fast.val)
```

Correct:

```java
if(slow == fast)
```

Two different nodes can have the same value.

---

❌ Using:

```java
while(fast.next != null)
```

This can cause a `NullPointerException`.

Correct:

```java
while(fast != null &&
      fast.next != null)
```

---

❌ Using a `HashSet`.

Although it works in O(n) time, it uses O(n) extra space. The expected interview solution is Floyd's Cycle Detection with O(1) space.

## Similar Problems

- 142. Linked List Cycle II
- 876. Middle of the Linked List
- 234. Palindrome Linked List
- 143. Reorder List
- 202. Happy Number

## Revision (15 sec)

- Two pointers: `slow` and `fast`.
- `slow` moves 1 step.
- `fast` moves 2 steps.
- If they meet → cycle exists.
- If `fast` reaches `null` → no cycle.
- O(n), O(1).
