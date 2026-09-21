class Solution(object):
    def resultArray(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        res = [0] * k
        dp = [0] * k  # dp[r] = number of subarrays ending at current index with product % k == r
        for v in nums:
            m = v % k
            ndp = [0] * k
            for r in range(k):
                if dp[r]:
                    ndp[(r * m) % k] += dp[r]
            ndp[m] += 1  # subarray consisting of just this element
            dp = ndp
            for r in range(k):
                res[r] += dp[r]
        return res
