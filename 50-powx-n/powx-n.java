class Solution {
    public double myPow(double x, int n) {
        if (n > 0) {
            return solution(x, n);
        }
        return 1 / solution(x, Math.abs(n));
    }

    public double solution(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = solution(x, n/2);
        if (n % 2 != 0) {
            res = res * res * x;
        } else {
            res = res * res;
        }
        return res;
    }
}