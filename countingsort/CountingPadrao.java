package countingsort;

public class CountingPadrao {
    public static int[] countingSort(int[] v, int maior) {
        int[] C = new int[maior];
        for(int i = 0; i < C.length;i++) {
            C[v[i]-1] += 1;
        }

        for(int i = 1; i < C.length;i++) {
            C[i] += C[i-1];
        }

        int[] B = new int[v.length];
        for(int i = v.length-1; i >= 0; i--) {
            B[C[v[i]-1]-1] = v[i];
            C[v[i]-1]--;
        }

        return B;
    }
}
