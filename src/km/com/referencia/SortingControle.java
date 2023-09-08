package km.com.referencia;


public class SortingControle{
    public static int Particione(String dicionario[], int inicio, int fim){
        String temp = dicionario[fim];
        int i = inicio - 1;
        for(int j = inicio; j < fim; j++){
            if(dicionario[j].length()<= temp.length()){
                i++;
                dicionario[i]=dicionario[j];
            }
        }
        dicionario[i+1] = dicionario[fim];
        return i+1;
    }
    public static void QuickSort(String dicionario[],int inicio,int fim)throws Exception{
        if(inicio<fim){
            int meio = Particione(dicionario,inicio,fim);
            QuickSort(dicionario,inicio,meio-1);
            QuickSort(dicionario,meio+1,fim);
        }
    }
}
