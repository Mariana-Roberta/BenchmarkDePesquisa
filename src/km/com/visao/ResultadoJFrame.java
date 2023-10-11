package km.com.visao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import km.com.avltree.AVLTree;
import km.com.avltree.BTree;
import km.com.avltree.RedBlackTree;
import km.com.avltree.Tree;

public class ResultadoJFrame extends javax.swing.JFrame {

    public ResultadoJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTextAreaAVLTree.setEditable(false);
        jTextAreaTree.setEditable(false);
        jTextAreaDesempenho.setEditable(false);
    }
    
    public ResultadoJFrame(ArrayList lista,AVLTree avltree, Tree tree, RedBlackTree rbtree, BTree btree, HashMap hmap, int contadorAVL,
            int contadorArvore, int contadorBinario, int contadorRBT, int contadorBT, long tempoAVL, long tempoBinaria, long tempoBuscaBi, long tempoRBT,long tempoBT) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        jTextAreaAVLTree.setEditable(false);
        jTextAreaTree.setEditable(false);
        jTextAreaDesempenho.setEditable(false);
        
        //IMPRIME AS ÁRVORES
        jTextAreaAVLTree.append(avltree.getRoot().buildAVLTreeString());
        jTextAreaTree.append(tree.getRoot().buildTreeString());
        jTextAreaRBTree.append(rbtree.getRoot().buildRBTreeString());
        jTextAreaBTree.append(btree.printTree());

        //IMPRIME AS COMPARAÇÕES E O DESEMPENHO
        jTextAreaDesempenho.append("arvore avl: \n");
        jTextAreaDesempenho.append("    comparações: " + contadorAVL + "\n");
        jTextAreaDesempenho.append("    " + tempoAVL + " nano segundos\n\n");
        jTextAreaDesempenho.append("arvore binaria: \n");
        jTextAreaDesempenho.append("    comparações: " + contadorArvore + "\n");
        jTextAreaDesempenho.append("    " + tempoBinaria + " nano segundos\n\n");
        jTextAreaDesempenho.append("pesquisa binaria: \n");
        jTextAreaDesempenho.append("    comparações: " + contadorBinario +"\n");
        jTextAreaDesempenho.append("    " + tempoBuscaBi +" nano segundos\n\n");
        jTextAreaDesempenho.append("arvore rubro negra: \n");
        jTextAreaDesempenho.append("    comparações: " + contadorRBT +"\n");
        jTextAreaDesempenho.append("    " + tempoRBT +" nano segundos\n\n");
        jTextAreaDesempenho.append("arvore b: \n");
        jTextAreaDesempenho.append("    comparações: " + contadorBT +"\n");
        jTextAreaDesempenho.append("    " + tempoBT +" nano segundos\n\n");
        jTextAreaDesempenho.append("frequencia das palavras: \n");
        Map<String, Integer> mapaOrdenado = new TreeMap<String, Integer>(hmap);
        for (Map.Entry<String, Integer> m:mapaOrdenado.entrySet()) {
            jTextAreaDesempenho.append(m.getKey() + ": " + m.getValue() + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAVLTree = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTree = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDesempenho = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaRBTree = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaBTree = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(29, 53, 87));

        jTextAreaAVLTree.setColumns(20);
        jTextAreaAVLTree.setRows(5);
        jTextAreaAVLTree.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaAVLTree);

        jTextAreaTree.setColumns(20);
        jTextAreaTree.setRows(5);
        jTextAreaTree.setBorder(null);
        jScrollPane2.setViewportView(jTextAreaTree);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPARAÇÕES E DESEMPENHO");

        jTextAreaDesempenho.setColumns(20);
        jTextAreaDesempenho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreaDesempenho.setRows(5);
        jTextAreaDesempenho.setBorder(null);
        jScrollPane3.setViewportView(jTextAreaDesempenho);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ÁRVORE BALANCEADA");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ÁRVORE NÃO BALANCEADA");

        jTextAreaRBTree.setColumns(20);
        jTextAreaRBTree.setRows(5);
        jTextAreaRBTree.setBorder(null);
        jScrollPane4.setViewportView(jTextAreaRBTree);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ÁRVORE RUBRO NEGRA");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ÁRVORE B");

        jTextAreaBTree.setColumns(20);
        jTextAreaBTree.setRows(5);
        jTextAreaBTree.setBorder(null);
        jScrollPane5.setViewportView(jTextAreaBTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultadoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextAreaAVLTree;
    private javax.swing.JTextArea jTextAreaBTree;
    private javax.swing.JTextArea jTextAreaDesempenho;
    private javax.swing.JTextArea jTextAreaRBTree;
    private javax.swing.JTextArea jTextAreaTree;
    // End of variables declaration//GEN-END:variables
}
