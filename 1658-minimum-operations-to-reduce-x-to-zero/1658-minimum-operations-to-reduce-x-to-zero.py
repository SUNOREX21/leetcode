class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        target = sum(nums) - x
        n = len(nums)
        if target < 0:
            return -1
        if target == 0:
            return n
        left = cur = 0
        max_len = -1
        for right, v in enumerate(nums):
            cur += v
            while cur > target:
                cur -= nums[left]
                left += 1
            if cur == target:
                max_len = max(max_len, right - left + 1)
        return -1 if max_len == -1 else n - max_len
