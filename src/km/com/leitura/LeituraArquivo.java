package km.com.leitura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeituraArquivo {
    public static void main(String [] args) {
        try {
            leituraDoDicionario();
            System.out.println(leituraDoDicionario());
        } catch (IOException ex) {
            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ArrayList leituraDoDicionario() throws FileNotFoundException, IOException{
        ArrayList lista = new ArrayList();
        
        //LÊ ARQUIVO DE TEXTO
        FileReader fr = new FileReader("./src/km/com/arquivos/Testando.txt");
        BufferedReader br = new BufferedReader(fr);

        //LÊ STOPWORDS
        FileReader filereader = new FileReader("./src/km/com/arquivos/stopwords.txt");
        BufferedReader bufferedreader = new BufferedReader(fr);
        
        //RETIRA AS PONTUAÇÕES
        Scanner input = new Scanner(fr);
        while(input.hasNext()) {
            String word  = input.next().toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!Character.isDigit(c) && !Character.isLetter(c)) {
                    String replace = word.replace(c, ' ');
                    word = replace;
                } 
            }      
            String trim = word.trim();
            lista.add(trim);
        }
        
        //VERIFICA AS PALAVRAS QUE SÃO STOPWORDS
        Scanner inputStopwords = new Scanner(filereader);
        while(inputStopwords.hasNext()) {
            String stopword  = inputStopwords.next();

            for(int i = 0; i < lista.size(); i++) { 
                String word = lista.get(i).toString();
                if(word.equals(stopword)){
                    lista.remove(word);
                }
                String trim = word.trim();
            }

        }
       return lista;      
    }    
}

    
