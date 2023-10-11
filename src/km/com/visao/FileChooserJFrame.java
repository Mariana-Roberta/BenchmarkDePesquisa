package km.com.visao;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import km.com.avltree.AVLTree;
import km.com.avltree.BTree;
import km.com.avltree.RedBlackTree;
import km.com.avltree.Tree;
import km.com.leitura.BuscaBinaria;
import km.com.leitura.Hashmap;
import km.com.leitura.LeituraArquivo;

public class FileChooserJFrame extends javax.swing.JFrame {

    public FileChooserJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldOrdem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonOrdem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leitura TXT");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(219, 233, 238));

        jPanel3.setBackground(new java.awt.Color(29, 53, 87));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ESCOLHA UM ARQUIVO");

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("O seguinte tipo de arquivo é obrigatório:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/km/com/imagens/upload-file (1).png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/km/com/imagens/txt-file.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(68, 122, 155));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CLIQUE AQUI");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTextFieldOrdem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 53, 87));
        jLabel5.setText("Ordem da Arvore B");

        jButtonOrdem.setBackground(new java.awt.Color(68, 122, 155));
        jButtonOrdem.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButtonOrdem.setForeground(new java.awt.Color(255, 255, 255));
        jButtonOrdem.setText("CONFIRMAR");
        jButtonOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonOrdem))
                    .addComponent(jLabel5))
                .addGap(103, 103, 103))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldOrdem)
                    .addComponent(jButtonOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setPreferredSize(new Dimension(800,600));
            fileChooser.setCurrentDirectory(new File(".\\src\\km\\com\\arquivos"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter(){
                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
                }

                @Override
                public String getDescription() {
                    return "Text File";
                }
            });

            int result = fileChooser.showOpenDialog(this);
            File selectedFile = null;
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
            }
            ArrayList<String> lista = new ArrayList();
            ArrayList<String> listaBinaria = new ArrayList();
            AVLTree avltree = new AVLTree();
            Tree tree = new Tree();
            BTree btree = new BTree(Integer.parseInt(jTextFieldOrdem.getText()));
            RedBlackTree rbtree = new RedBlackTree();
            BuscaBinaria buscaBi = new BuscaBinaria();
            lista = LeituraArquivo.leituraDoArquivo(selectedFile.toString());
            HashMap<String, Integer> hmap = Hashmap.criaHashmap(lista);
 
            //Gerando contador da busca binaria e populando a lista vetor binario
            long tempoB = System.nanoTime();
            for(int i = 0; i < lista.size(); i++){
                String palavra = lista.get(i);
                if(!buscaBi.buscaBin(listaBinaria, palavra, 0, listaBinaria.size()-1)){
                    listaBinaria.add(palavra);
                    buscaBi.InsertionSort(listaBinaria);
                }
            }            
            long tempoB2 = System.nanoTime();
            //contador da busca binaria
            int contadorBinario = buscaBi.getContador();
            long tempoBuscaBi = tempoB2-tempoB;
            
            //Gerando contador da arvore AVL e populando a mesma
            int contadorAvl = 0;
            long tempoAvl = System.nanoTime();
            for(int i=0; i<lista.size();i++){
                String palavra = lista.get(i);
                if(avltree.find(palavra) == null){
                    avltree.insert(palavra);
                }
            }
            long tempoAvl2 = System.nanoTime();
            contadorAvl = avltree.getContador();
            long tempoAVL = tempoAvl2-tempoAvl;
            
            //RBTree
            int contadorRBT = 0;
            long tempoRBT1 = System.nanoTime();
            for(int i=0; i<lista.size();i++){
                String palavra = lista.get(i);
                if(rbtree.searchNode(palavra) == null){
                    rbtree.insertNode(palavra);
                }
            }
            //Contador de tempo e verificações
            long tempoRBT2 = System.nanoTime();
            long tempoRBT = tempoRBT2 - tempoRBT1;
            contadorRBT = rbtree.getContador();
            
            //BTree
            int contadorBT = 0;
            long tempoBT1 = System.nanoTime();
            for(int i=0; i<lista.size();i++){
                String palavra = lista.get(i);
                if(!btree.search(palavra)){
                    btree.insert(palavra);
                }
            }
            long tempoBT2 = System.nanoTime();
            //Contador de tempo e verificações
            long tempoBT = tempoBT2 - tempoBT1;
            contadorBT = btree.getContador();
            //btree.printTree();
            
            //Gerando contador da arvore binaria e populando a mesma
            int contadorArvore = 0;
            long tempoArvore = System.nanoTime();
            for(int i=0; i<lista.size();i++){
                String palavra = lista.get(i);
                if(tree.find(palavra) == null){
                    tree.insert(palavra);
                }
            }
            long tempoArvore2 = System.nanoTime();
            contadorArvore +=  tree.getContador();
            long tempoBinaria = tempoArvore2 - tempoArvore;
            
            ResultadoJFrame resultadoJFrame = new ResultadoJFrame(lista, avltree, tree, rbtree, btree, hmap,
                    contadorAvl, contadorArvore, contadorBinario, contadorRBT, contadorBT, tempoAVL, tempoBinaria, tempoBuscaBi, tempoRBT, tempoBT);
            resultadoJFrame.setVisible(true);
            jTextFieldOrdem.setText("");
            jTextFieldOrdem.setEnabled(true);
            jButtonOrdem.setEnabled(true);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdemActionPerformed
        jTextFieldOrdem.setEnabled(false);
        jButtonOrdem.setEnabled(false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButtonOrdemActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileChooserJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonOrdem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldOrdem;
    // End of variables declaration//GEN-END:variables
}
