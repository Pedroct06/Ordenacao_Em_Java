package countingsort;

public class CountingZero {
    public static int[] counting(int[] v, int maior) {
        int[] C = new int[maior+1];
        for(int i = 0; i < C.length;i++) {
            C[v[i]] += 1;
        }
        
        for(int i = 1; i < C.length;i++) {
            C[i] = C[i-1];
        }

        int[] B = new int[v.length];
        for(int i = v.length-1; i >= 0; i--) {
            B[C[v[i]]-1] = v[i];
            C[v[i]]--;
        }

        return B;
    }
}
