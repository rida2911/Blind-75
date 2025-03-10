class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int count = t.length(), start = 0;
        
        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (map.containsKey(rChar)) {
                if (map.get(rChar) > 0) count--;
                map.put(rChar, map.get(rChar) - 1);
            }
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                char lChar = s.charAt(left);
                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                    if (map.get(lChar) > 0) count++;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
