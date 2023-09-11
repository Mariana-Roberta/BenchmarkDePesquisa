package km.com.leitura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class LeituraArquivo {
//    public static void main(String [] args) {
//        try {
//            leituraDoArquivo("C:\\Users\\Mariana\\Documents\\Teste.txt");
//            //System.out.println(leituraDoArquivo("C:\\Users\\Mariana\\Documents\\Teste.txt"));
//        } catch (IOException ex) {
//            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public static HashMap leituraDoArquivo(String filename) throws FileNotFoundException, IOException{
        ArrayList lista = new ArrayList();
        
        //LÊ ARQUIVO DE TEXTO
        FileReader fr = new FileReader(filename);
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
            lista.add(word.trim());
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
            }

        }
        
        //ADICIONA AS PALAVRAS CONFORME A FREQUÊNCIA E EVITA DUPLICADAS
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        for (int i = 0; i < lista.size(); i++) {
            Integer c = hmap.get(lista.get(i).toString());

            if (hmap.get(lista.get(i).toString()) == null) {
               hmap.put(lista.get(i).toString(), 1);
            } else {
              hmap.put(lista.get(i).toString(), ++c);
            }
        }
//        for (Map.Entry<String, Integer> m:hmap.entrySet()) {
//            System.out.println(m.getKey() + m.getValue());
//        }
        
       return hmap;      
    }    
}

    
