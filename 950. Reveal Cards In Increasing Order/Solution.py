class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        n = len(deck)
        res = [0] * n

        queue = deque(range(n))
        deck.sort()
        for n in deck:
            res[queue.popleft()] = n
            if queue:
                queue.append(queue.popleft())
        
        return res