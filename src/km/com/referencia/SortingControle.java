package km.com.referencia;


public class SortingControle{
    public static int Particione(String word[], int inicio, int fim){
        String temp = word[fim];
        int i = inicio - 1;
        for(int j = inicio; j < fim; j++){
            if(word[j].compareTo(temp)< 0){
                i++;
                word[i]=word[j];
            }
        }
        word[i+1] = word[fim];
        return i+1;
    }
    public static void QuickSort(String word[],int inicio,int fim)throws Exception{
        if(inicio<fim){
            int meio = Particione(word,inicio,fim);
            QuickSort(word,inicio,meio-1);
            QuickSort(word,meio+1,fim);
        }
    }
}
