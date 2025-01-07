package random.tests;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.special.Gamma;

public class RNGTester {

    static final double sqrt2 = 1.41421356237309504880;

    public static double runFrequencyTest(String bits){
        int len = bits.length();
        int sum = 0;

        for (int i = 0; i < len; i++) {
           int s_i =  bits.charAt(i) == '1' ? 1 : -1;
           sum += s_i;
        }

        double s_obs = Math.abs(sum) / Math.sqrt(len);
        double f = s_obs / sqrt2;

        double p_value = Erf.erfc(f);
        return p_value;

    }

    public static double runFrequencyBlockTest(String bits, int M){
        int n = bits.length();
        int N = n/M;
        System.out.println(n + " " + M + " " + N);
        double[] pi_i = new double[N];
        for(int i=1; i<= N; i++){
            int sum = 0;
            for(int j = 1; j <= M; j++){
                int index = (i-1)*M+j;
                sum += bits.charAt(index-1) == '1' ? 1 : 0;
            }
            pi_i[i-1] = (double)sum/M;
        }

        double stat = 0.0;

        for(int i=1; i<= N; i++){
            stat += ((pi_i[i-1] - 0.5) * (pi_i[i-1] - 0.5));
        }

        double chi_squared = 4 * M * stat;

        return Gamma.regularizedGammaQ(N / 2.0, chi_squared / 2.0);

    }

    public static double runRunsTest(String bits){
        int n = bits.length();
        int ones, k;

        ones = 0;
        for (int i = 0; i < n; i++) {
            if (bits.charAt(i) != '0') {
                ones++;
            }
        }

        double pi = (double) ones / (double) n;

        if (Math.abs(pi - 0.5) >= (2.0 / Math.sqrt(n))) {
            return 0.0;
        }
        int V = 1;
        for (k = 1; k < n; k++) {
            if (bits.charAt(k) != bits.charAt(k-1)) {
                V++;
            }
        }
        double numerator = Math.abs((double) V - 2.0 * n * pi * (1 - pi));
        double denominator = 2.0 * Math.sqrt(2 * n) *pi * (1 - pi) ;

        return Erf.erfc(numerator/denominator);
    }

}
