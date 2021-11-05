public class FifthNovember {
    public static int arrangeCoins(long n) {
        long sum = 0;
        for(long i = 1; i<= (n/2 + 1) ; i++) {
            sum += i;
            if(sum == n)
                return (int)i;
            else if(sum > n)
                return (int)i-1;
        }
        return 0;
    }
}
