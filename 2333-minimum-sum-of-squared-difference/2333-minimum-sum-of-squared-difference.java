
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {

        long operations = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];

        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (operations >= sum) {
            return 0;
        }

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= operations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long used = 0;
        long answer = 0;

        for (int d : diff) {
            int reduced = Math.min(d, limit);
            used += d - reduced;
            answer += (long) reduced * reduced;
        }

        // Spend any remaining operations reducing the
        // differences that are equal to the limit.
        long remaining = operations - used;

        for (int d : diff) {
            if (remaining == 0) break;

            if (d >= limit && limit > 0) {
                answer -= (long) limit * limit;
                answer += (long) (limit - 1) * (limit - 1);
                remaining--;
            }
        }

        return answer;
    }
}
