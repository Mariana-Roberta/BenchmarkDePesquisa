package km.com.leitura;

import java.util.ArrayList;

public class BuscaBinaria {
    int contador = 0;
    
    public void setContador(int contador){
        this.contador = contador;
    }
    
    public int getContador(){
        return contador;
    }
    
    //BUSCA BINÁRIA COM UM VETOR
    public boolean buscaBin(ArrayList<String> lista, String palavra, int inicio, int fim){
        int meio = 0;
        contador++;
        if(inicio > fim){
            return false;
        }
        meio = (inicio + fim) / 2;
        if(palavra.equalsIgnoreCase(lista.get(meio))){
            return true;
        }
        else if (palavra.compareTo(lista.get(meio)) < 0){
            return (buscaBin(lista, palavra, inicio, meio-1));
        }
        else if (palavra.compareTo(lista.get(meio)) > 0){
            return (buscaBin(lista, palavra, meio+1, fim));
        }
        return false;
        }
    
    public void InsertionSort(ArrayList<String> lista){
        for(int i=1; i<lista.size(); i++){
            contador++;
            String v = lista.get(i);
            int j = i;
            while((j > 0) && (lista.get(j-1).compareTo(v) > 0)){
                lista.set(j, lista.get(j-1));
                j--;
            }
            lista.set(j, v);
        }
    }
    
//    public static boolean buscaBin(String vetor[], String palavra, int inicio, int fim){
//        int meio;
//        if(inicio > fim){
//            System.out.println("A palavra não existe.");
//            return false;
//        }
//        meio = (inicio + fim) / 2;
//        if(palavra.matches(vetor[meio])){
//            System.out.println("A palavra existe.");
//            return true;
//        }
//        else if (palavra.length() < vetor[meio].length()){
//            return (buscaBin(vetor, palavra, inicio, meio-1));
//        }
//        else {
//            if(palavra.length() == vetor[meio].length()){
//                for(int i = meio; vetor[i].length() == vetor[meio].length(); i++){  
//                    if(palavra.matches(vetor[i])){
//                        return true;
//                    }
//                }
//                for(int i = meio; vetor[i].length() == vetor[meio].length(); i--){  
//                    if(palavra.matches(vetor[i])){
//                        return true;
//                    }
//                }
//                return false;
//            }
//            return (buscaBin(vetor, palavra, meio+1, fim));
//        }
//    }
}
