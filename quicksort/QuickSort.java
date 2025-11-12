package quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] v, int ini, int fim) {
        if(ini >=  fim) return;

        
        int indexMed = mediana(v, ini, fim);
        int indexPivot = partLomuto(v, ini, fim, indexMed); // ou indexPivot = partHoare(v,ini,fim,indexMed)
        quickSort(v, ini, indexPivot-1); 
        quickSort(v, indexPivot+1, fim);
    }


    public static int partLomuto(int[] v, int ini, int fim,int indexMed) {
        int i = ini;
        swap(v, fim, indexMed);
        int pivot = v[fim];
        for(int j = i; j < fim; j++) {
            if(v[j] < pivot) {
                swap(v,i,j);
                i++;
            }
        }
        swap(v, i, fim);
        return i;
    }

    public static int partHoare(int[] v, int ini, int fim, int indexMed) {
        int pivot = v[indexMed];
        int i = ini;
        int j = fim;
        
        while(i <= j) {
            while(v[i] < pivot) {
                i++;
            }
            while(v[j] > pivot) {
                j--;
            }
            if(i < j)
            swap(v,i,j);
        }
        swap(v, indexMed, j);
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
