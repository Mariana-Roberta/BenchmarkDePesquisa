package km.com.referencia;

import java.util.ArrayList;

public class BuscaControle{
    
    public static boolean buscaBinaria(ArrayList<String> lista, String palavra, int inicio, int fim) {

    int meio = 0;
        if (inicio>fim)return false;
        meio = (inicio+fim)/2;
        if(palavra.compareTo(lista.get(meio))==0)
            return true;
        else if (palavra.compareTo(lista.get(meio))<0)
            return (buscaBinaria (lista, palavra, inicio, meio-1));
        else return (buscaBinaria(lista, palavra, meio+1, fim));
}
    
    public static boolean buscaSequencial(ArrayList<String> lista, String palavra) {
        
        for(String palavraLista : lista) {
            if(palavra.toLowerCase().equals(palavraLista.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
