package countingsort;

public class CountingSortNegativo {
    public static int[] sortNegativo(int[] v, int maior, int menor) {
        int[] C = new int[maior-menor+1];
        for(int i = 0; i < C.length;i++) {
            C[v[i]-menor] += 1;
        }

        for(int i = 1; i < C.length;i++) {
            C[i] = C[i-1];
        }

        int[] B = new int[v.length];
        for(int i = v.length-1; i >= 0; i--) {
            B[C[v[i]-menor]-1] = v[i];
            C[v[i]-menor]--;
        }

        return B;
    }   
}
