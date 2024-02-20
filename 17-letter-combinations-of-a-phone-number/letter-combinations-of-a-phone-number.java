class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("") || digits.equals("1")) return new ArrayList<>();
        List<String> result = new ArrayList<String>();
        solution(result, digits, "", 0, getMap());
        return result;
    }

    public void solution(
        List<String> result, 
        String digits, 
        String currStr, 
        int index,
        Map<String, String> map
    ) {
        if (currStr.length() == digits.length()) {
            result.add(currStr);
            return;
        }
        String letters = map.get(String.valueOf(digits.charAt(index)));
        for (Character c : letters.toCharArray()) {
            solution(result, digits, currStr + c, index + 1, map);
        }
    }

    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        return map;
    }
}