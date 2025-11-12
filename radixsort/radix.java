package radixsort;

public class radix {
    public static void radixSort(int[] v) {
        int max = v[0];
        for(int n : v) {
            if(n > max) max = n;
        }

        int exp = 1;
        while(max/exp > 0) {
            count(v,exp);
            exp *= 10;
        }
    }

    public static int[] count(int[] v, int exp) {
        int[] C = new int[10];
        for(int i = 0; i < v.length;i++) {
            int digito = (v[i]/exp) % 10;
            C[digito] += 1;
        }
        
        for(int i = 1; i < C.length;i++) {
            C[i] = C[i-1];
        }
        
        int[] B = new int[v.length];
        for(int i = v.length-1; i >= 0; i--) {
             int digito = (v[i]/exp) % 10;
            B[C[digito]-1] = v[i];
            C[digito]--;
        }
        return B;
    }
}
