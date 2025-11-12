package mergesort;

public class MergeSort {
    public static void mergeSort(int[] v, int ini, int fim) {
        if(ini >= fim) return;

        int meio = (ini+fim)/2;
        mergeSort(v, ini, meio);
        mergeSort(v, meio +1, fim);
        merge(v,ini,meio, fim);
    }

    public static void merge(int[] v, int ini, int meio, int fim) {
        int[] aux = new int[fim-ini+1];
        for(int i = 0; i < aux.length;i++) {
            aux[i] = v[ini + i];
        }
               
        int i = 0;
        int j = meio +1;
        int k = ini;

        while(i <= meio && j <= fim) {
            if(aux[i] <= aux[j]) v[k++] = aux[i++];
            else v[k++] = aux[j++];
        }

        while(i <= meio && k < aux.length) {
            v[k++] = aux[i++];
        }

    }
}
