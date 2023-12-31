package km.com.avltree;

public class AVLTree {
	
    public class Node {

        String key;
        int height;
        Node left;
        Node right;

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
    private int contador = 0;
    
    public int getContador(){
        return contador;
    }

    public void setContador(int contador){
        this.contador = contador;
    }
    
    public Node find(String key) {
        Node current = root;
        while (current != null) {
            contador++;
            if (current.key.equals(key)) {
               break;
            }
            current = current.key.compareTo(key)< 0 ? current.right : current.left;
        }
        return current;
    }

    public void insert(String key) {
        root = insert(root, key);
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, String key) {
        if (node == null) {
            Node n = new Node(key);
            return n;
        } else if (node.key.compareTo(key)>0) {
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            node.right = insert(node.right, key);
        }
        return rebalance(node);
    }

    private Node delete(Node node, String key) {
        if (node == null) {
            return node;
        } else if (node.key.compareTo(key)>0) {
            node.left = delete(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
}