package km.com.avltree;

public class RedBlackTreeTeste {
    
    public class Node {
        
        String key;
        Node left, right;
        Node parent;
        int height;
        boolean color; // true == RED; false == BLACK
        
        public Node (String key) {
            this.key = key;
            this.color = false;
        }
        
        // Imprime a árvore
        public String buildRebBlackTreeString() {
          StringBuilder treeString = new StringBuilder();
          buildRebBlackTreeString(treeString, true, "");
          return treeString.toString();
        }   

        private void buildRebBlackTreeString(StringBuilder treeString, boolean isRight, String indent) {
          if (right != null) {
              right.buildRebBlackTreeString(treeString, true, indent + (isRight ? "        " : " |      "));
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
              left.buildRebBlackTreeString(treeString, false, indent + (isRight ? " |      " : "        "));
          }
        }

        private void appendNodeValue(StringBuilder treeString) {
          if (key == null) {
              treeString.append("<null>\n");
          } else {
              treeString.append(key).append(color ? " (RED) " : " (BLACK) ").append('\n'); // Imprime o valor do nó e a cor
          }
        }
    }
    
    private Node root;
    private Node tNull;
    
    public Node getRoot() {
        return root;
    }
    
    public Node find (String key) {
        Node current = root;
        while (current != null) {
            if (current.key.equals(key)) {
                break;
            }
            current = current.key.compareTo(key) > 0 ? current.left : current.right; // se a key for maior que a key do current, o current recebe o da direita
        }
        return current;
    }
    
    public int height() {
        return root == null ? -1 : root.height;
    }
    
    public void insert (String key) {
        Node node = root;
        Node parent = null; // o nó pai do novo nó a ser inserido
        
        while(node != null) { // enquanto não chegar em um nó folha
            parent = node; // atualizado com o valor 
            
            if (node.key.compareTo(key) > 0) {
                node = node.left;
            } else if (node.key.compareTo(key) < 0) {
                node = node.right;
            } /*else {
                throw new IllegalArgumentException("BST already contains a node with key " + key);
            }*/
        }
        
        Node newNode = new Node(key);
        newNode.color = false;
        
        if (parent == null) { // se parent == null, o nó a ser inserido é a raiz
            root = newNode;
        } else if (parent.key.compareTo(key) > 0) {
            parent.left = newNode;
        } else if (parent.key.compareTo(key) < 0) {
            parent.right = newNode;
        }
        newNode.parent = parent;
        
        fixRedBlackPropertiesAfterInsert(newNode);
            
    }
    
    private void fixRedBlackPropertiesAfterInsert(Node node) {
        // se o filho da direita é vermelho e o filho da esquerda é preto, fazer rotação a esquerda
        // se o filho da esquerda é vermelho e o filho à esquerda do filho da esquerda também é vermelho, fazer rotação a direita
        // se ambos os filhos são vermelhos, trocar as cores

        Node parent = node.parent;
        if (parent == null) { // chegou a raiz
            return;
        }
        
        Node grandparent = parent.parent;
        if (grandparent == null) {
            parent.color = false; // cor preta para a raiz
            return;
        }
        
        Node uncle = getUncle(parent);
        if (uncle != null && uncle.color == true && parent.color == true && grandparent.color == false) {
            parent.color = false;
            grandparent.color = true;
            uncle.color = false;
            
            fixRedBlackPropertiesAfterInsert(grandparent);
        } else if (parent == grandparent.left) {
            
          if (node == parent.right) {
            rotateLeft(parent);
            parent = node;
          }

          rotateRight(grandparent);
          parent.color = false;
          grandparent.color = true;
        } else {

            if (node == parent.left) {
                rotateRight(parent);
                parent = node;
            }

            rotateLeft(grandparent);

            parent.color = false;
            grandparent.color = true;
        }
        
        
    }
    
    public Node delete (Node node, String key) {
        return null;
    }
    
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right)); // o height é definido como um mais o máximo de altura das subárvores a direita e a esquerda
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    public int getBalance(Node node) {
        return (node == null) ? 0 : height(node.right) - height(node.left);
    }
    
    private Node getUncle(Node parent) {
        Node grandparent = parent.parent;
        if (grandparent.left == parent) {
          return grandparent.right;
        } else if (grandparent.right == parent) {
          return grandparent.left;
        } else {
          throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }
    
    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
          leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        replaceParentsChild(parent, node, leftChild);
    }

    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
          rightChild.left.parent = node;
        }

        rightChild.left = node;
        node.parent = rightChild;

        replaceParentsChild(parent, node, rightChild);
    }
      
    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
          root = newChild;
        } else if (parent.left == oldChild) {
          parent.left = newChild;
        } else if (parent.right == oldChild) {
          parent.right = newChild;
        } else {
          throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
          newChild.parent = parent;
        }
    }
    
    public static void main (String []args) {
        RedBlackTreeTeste test = new RedBlackTreeTeste();
        test.insert("a");
        test.insert("b");
        test.insert("c");
        test.insert("d");
        test.insert("z");
        test.insert("i");
        test.insert("j");
        System.out.println(test.getRoot().buildRebBlackTreeString());
    }
}
