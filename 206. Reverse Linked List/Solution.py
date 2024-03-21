# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head, acc) -> Optional[ListNode]:
        if not head:
            return acc
        return self.reverse(head.next, ListNode(head.val,acc))

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.reverse(head, None)
        