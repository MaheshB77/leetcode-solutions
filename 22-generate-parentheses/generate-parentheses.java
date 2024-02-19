class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solution(result, "", n);
        return result;
    }

    public void solution(List<String> result, String curr, int n) {
        if (countChar(curr, ")") >  countChar(curr, "(")) {
            return;
        }
        if (
            countBrckt(curr, n, "(") 
            && countBrckt(curr, n, ")")
            && curr.charAt(curr.length() - 1) == ')'
            && curr.charAt(0) == '('
        ) {
            result.add(new String(curr));
            return;
        }
        if (curr.length() >= n *2) {
            return;
        }
        curr = curr + "(";
        solution(result, curr, n);
        if (curr.length() > 0) {
            curr = curr.substring(0, curr.length() - 1);
        }
        curr = curr + ")";
        solution(result, curr, n);
    }

    public boolean countBrckt(String str, int n, String brckt) {
        String[] list = str.split("");
        int count = 0;
        for (String s : list) {
            if (s.equals(brckt)) count++;
        }
        return (count == n);
    }

    public int countChar(String str, String c) {
        String[] list = str.split("");
        int count = 0;
        for (String ch : list) {
            if (ch.equals(c)) count++;
        }
        return count;
    }
}