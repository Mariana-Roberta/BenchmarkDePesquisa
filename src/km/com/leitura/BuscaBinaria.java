package km.com.leitura;

import java.util.ArrayList;

public class BuscaBinaria {
    
    //BUSCA BINÁRIA COM UM VETOR
    public static boolean buscaBin(ArrayList lista, String palavra, int inicio, int fim){
        int meio;
        if(inicio > fim){
            System.out.println("A palavra não existe.");
            return false;
        }
        meio = (inicio + fim) / 2;
        if(palavra.compareTo(lista.get(meio).toString()) == 0){
            System.out.println("A palavra existe.");
            return true;
        }
        else if (palavra.compareTo(lista.get(meio).toString()) < 0){
            return (buscaBin(lista, palavra, inicio, meio-1));
        }
        else if(palavra.compareTo(lista.get(meio).toString()) > 0){
            return (buscaBin(lista, palavra, meio+1, fim));
        }
        return false;
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
