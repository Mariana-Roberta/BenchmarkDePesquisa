package km.com.avltree;

public class RedBlackTree {
    
    public class Node {
        String key;
        Node parent;
        Node left;
        Node right;
        int color;
        
        Node(String key) {
            this.key = key;
        }
        
        //IMPRIME A ÁRVORE
        public String buildAVLTreeString() {
            StringBuilder treeString = new StringBuilder();
            buildAVLTreeString(treeString, true, "");
            return treeString.toString();
        }   

        private void buildAVLTreeString(StringBuilder treeString, boolean isRight, String indent) {
            if (right != null) {
                right.buildAVLTreeString(treeString, true, indent + (isRight ? "        " : " |      "));
            }
            treeString.append(indent);
            if (isRight) {
                treeString.append(" /");
            } else {
                treeString.append(" \\");
            }
            treeString.append("----- ");
            appendNodeValue(treeString);
            if (left != null) {
                left.buildAVLTreeString(treeString, false, indent + (isRight ? " |      " : "        "));
            }
        }

        private void appendNodeValue(StringBuilder treeString) {
            if (key == null) {
                treeString.append("<null>\n");
            } else {
                treeString.append(key).append('\n');
            }
        }
    }
    
    private Node root;
    private Node TNULL;

    // Pré-ordem
    // Percorre a árvore rubro-negra em pré-ordem
    public void preOrder() {
        preOrderHelper(this.root);
    }

    // Inordem
    // Percorre a árvore rubro-negra em ordem
    public void inOrder() {
        inOrderHelper(this.root);
    }

    // Pós-ordem
    // Percorre a árvore rubro-negra em pós-ordem
    public void postOrder() {
        postOrderHelper(this.root);
    }

    // Insere um valor na árvore rubro-negra
    public void insert(String key) {
        // Inicializa um novo nó e define seu valor e filhos como nulos
        Node node = new Node(key);
        node.parent = null;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // Novos nós são sempre vermelhos

        Node y = null;
        Node x = this.root;

        // Percorre a árvore para encontrar o local de inserção
        while (x != TNULL) {
            y = x;
            if (node.key.compareTo (x.key)< 0 ) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // Define o pai do novo nó
        node.parent = y;

        // Se o pai for nulo, o novo nó é a raiz da árvore
        if (y == null) {
            root = node;
        } else if (node.key.compareTo (y.key)> 0 ) {
            y.left = node;
        } else {
            y.right = node;
        }

        // Caso de inserção em que a propriedade da árvore rubro-negra pode ser violada
        if (node.parent == null) {
            return;
        }

        // Corrige a árvore
        fixInsert(node);
    }

    // Método auxiliar para percorrer a árvore em pré-ordem
    // Usado para imprimir a árvore
    private void preOrderHelper(Node node) {
        if (node != TNULL) {
            System.out.print(node.key + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    // Método auxiliar para percorrer a árvore em ordem
    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            System.out.print(node.key + " ");
            inOrderHelper(node.right);
        }
    }

    // Método auxiliar para percorrer a árvore em pós-ordem
    private void postOrderHelper(Node node) {
        if (node != TNULL) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.key + " ");
        }
    }

    // Corrige a árvore após a inserção de um nó
    // Realiza rotações e ajustes de cores conforme necessário
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // Tio
                if (u.color == 1) {
                    // Caso 1: O tio também é vermelho
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // Caso 2: O tio é preto e o nó é um filho esquerdo
                        k = k.parent;
                        rightRotate(k);
                    }
                    // Caso 3: O tio é preto e o nó é um filho direito
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // Tio

                if (u.color == 1) {
                    // Caso 1: O tio também é vermelho
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent; 
                } else {
                    if (k == k.parent.right) {
                        // Caso 2: O tio é preto e o nó é um filho direito
                        k = k.parent;
                        leftRotate(k);
                    }
                    // Caso 3: O tio é preto e o nó é um filho esquerdo
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    // Rotação à esquerda em um nó
    // Atualiza os pais e filhos dos nós envolvidos
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotação à direita em um nó
    // Atualiza os pais e filhos dos nós envolvidos
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
}
