package selectionsort;

public class SelectionSort {
    public static void selectionSort(int[] v) {
        for(int j = 0; j < v.length;j++) {
            int indexMenor = j;
            for(int i = 0; i < v.length;i++) {
                if(v[indexMenor] > v[i])
                    indexMenor = i;        
            }
            swap(v,indexMenor,j);
        }    
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
