class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        _min = min(len(word1),len(word2))
        i = 0
        ans = []
        while i<_min:
            ans += word1[i]
            ans += word2[i]
            i += 1

        if(i<len(word1)):
            ans += word1[i:]
        else:
            ans += word2[i:]


        return "".join(ans)