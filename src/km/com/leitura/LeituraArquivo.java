package km.com.leitura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class LeituraArquivo {
    
    
    
    public static boolean stopwords(String word)throws FileNotFoundException, IOException{
        FileReader filereader = new FileReader("./src/km/com/arquivos/stopwords.txt");
        BufferedReader bufferedreader = new BufferedReader(filereader);
        //VERIFICA AS PALAVRAS QUE SÃO STOPWORDS
        Scanner inputStopwords = new Scanner(bufferedreader);
        while(inputStopwords.hasNext()) {
            String stopword  = inputStopwords.next(); 
                if(word.equals(stopword)){
                    return true;
                }
            }
        return false;
    }
    
    public static ArrayList leituraDoArquivo(String filename) throws FileNotFoundException, IOException{
        ArrayList lista = new ArrayList();
        
        //LÊ ARQUIVO DE TEXTO
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        //RETIRA AS PONTUAÇÕES
        Scanner input = new Scanner(br);
        while(input.hasNext()) {
            String word  = input.next().toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!Character.isDigit(c) && !Character.isLetter(c)) {
                    String replace = word.replace(c, ' ');
                    word = replace;
                } 
            }
            if(!stopwords(word.trim())){
                lista.add(word.trim());
            }
        }
        return lista;      
    }    
}

    
