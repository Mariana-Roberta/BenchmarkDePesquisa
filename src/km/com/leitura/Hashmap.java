package km.com.leitura;

import java.util.ArrayList;
import java.util.HashMap;

public class Hashmap {
    
    //ADICIONA AS PALAVRAS CONFORME A FREQUÊNCIA E EVITA DUPLICADAS
    public static HashMap criaHashmap(ArrayList lista) {
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        for (int i = 0; i < lista.size(); i++) {
            Integer c = hmap.get(lista.get(i).toString());

            if (hmap.get(lista.get(i).toString()) == null) {
               hmap.put(lista.get(i).toString(), 1);
            } else {
              hmap.put(lista.get(i).toString(), ++c);
            }
        }
        return hmap;
    }
}
