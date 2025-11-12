package quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] v, int ini, int fim) {
        if(ini >=  fim) return;

        
        int indexMed = mediana(v, ini, fim);
        swap(v,ini,indexMed);
        int indexPivot = partLomuto(v, ini, fim); // ou indexPivot = partHoare(v,ini,fim)
        quickSort(v, ini, indexPivot-1); 
        quickSort(v, indexPivot+1, fim);
    }


    public static int partLomuto(int[] v, int ini, int fim) {
        int i = ini;
        int pivot = v[ini];
        for(int j = i+1; j < fim; j++) {
            if(v[j] < pivot) {
                i++;
                swap(v,i,j);
            }
        }
        swap(v, i, ini);
        return i;
    }

    public static int partHoare(int[] v, int ini, int fim) {
        int pivot = v[ini];
        int i = ini + 1;
        int j = fim;
        
        while(i <= j) {
            while(i <= j && v[i] < pivot) {
                i++;
            }
            while(i <= j && v[j] > pivot) {
                j--;
            }
            if(i < j)
            swap(v,i,j);
        }
        swap(v, ini, j);
        return j;
    }

    public static void swap(int[]v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static int mediana(int[] v, int ini, int fim) {
        int meio = (ini + fim)/2;
        int[] index = {v[ini], v[meio], v[fim]};
        Arrays.sort(index);

        if (index[1] == v[ini]) return ini;
        else if(index[1] == v[meio]) return meio;
        else return fim;
    }
}
