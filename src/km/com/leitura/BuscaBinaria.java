package km.com.leitura;

public class BuscaBinaria {
    
    //BUSCA BINÁRIA COM UM VETOR
    public static boolean buscaBin(String vetor[], String x, int inicio, int fim){
        int meio;
        if(inicio > fim){
            System.out.println("A palavra não existe.");
            return false;
        }
        meio = (inicio + fim) / 2;
        if(x.matches(vetor[meio])){
            System.out.println("A palavra existe.");
            return true;
        }
        else if (x.length() < vetor[meio].length()){
            return (buscaBin(vetor, x, inicio, meio-1));
        }
        else {
            if(x.length() == vetor[meio].length()){
                for(int i = meio; vetor[i].length() == vetor[meio].length(); i++){  
                    if(x.matches(vetor[i])){
                        return true;
                    }
                }
                for(int i = meio; vetor[i].length() == vetor[meio].length(); i--){  
                    if(x.matches(vetor[i])){
                        return true;
                    }
                }
                return false;
            }
            return (buscaBin(vetor, x, meio+1, fim));
        }
    }
    
}
