package km.com.avltree;


public class Tree {
	
    public class Node {
        String key;
        int height;
        Node left;
        Node right;

        Node(String key) {
            this.key = key;
        }

        //IMPRIME A ÁRVORE
        public String buildTreeString() {
            StringBuilder treeString = new StringBuilder();
            buildTreeString(treeString, true, "");
            return treeString.toString();
        }   

        private void buildTreeString(StringBuilder treeString, boolean isRight, String indent) {
            if (right != null) {
                right.buildTreeString(treeString, true, indent + (isRight ? "        " : " |      "));
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
                left.buildTreeString(treeString, false, indent + (isRight ? " |      " : "        "));
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
            if (current.key == key) {
               break;
            }
            current = current.key.compareTo(key) < 0 ? current.right : current.left;
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
        contador++;
        if (node == null) {
            Node n = new Node(key);
            return n;
        } else if (node.key.compareTo(key)>0) {
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            node.right = insert(node.right, key);
        }
        return node;
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
}