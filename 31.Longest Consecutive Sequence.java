class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num); // Store all elements in HashSet

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {  // Start counting from the beginning of a sequence
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {  // Keep checking next numbers
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}


