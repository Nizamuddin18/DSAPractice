package interview.BinarySearch;

public class SquareRootOfANumber {

    public static void main(String[] args) {
        int x = 26;
        System.out.println("Find the Square Root of a Number ");
        System.out.println("Input  : " + x);
        int ans = sqrt(x);
        System.out.println("Output : " + ans);
    }

    private static int sqrt(int x) {
        int low = 1;
        int high = x;
        int ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long val = mid * mid;
            if (val <= (long) x) {
                ans = (int) mid;
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return ans;
    }
}
