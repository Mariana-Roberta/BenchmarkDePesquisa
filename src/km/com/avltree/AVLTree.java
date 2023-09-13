package km.com.avltree;

import km.com.avltree.TreePrinter.PrintableNode;

public class AVLTree {
	
	public class Node implements PrintableNode {

	    String key;
	    int height;
	    Node left;
	    Node right;

	    Node(String key) {
	        this.key = key;
	    }
        
        @Override
        public PrintableNode getLeft() {
            return left;
        }

        @Override
        public PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return key;
        }
	}

    private Node root;
    int contador = 0;
    
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
            contador++;
            return n;
        } else if (node.key.compareTo(key)>0) {
            contador++;
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            contador++;
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
    
    public void printAVLTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }
            System.out.println(node.key);

            printAVLTree(node.left, indent, false);
            printAVLTree(node.right, indent, true);
        }
    }

    
    public void printAVLTree() {
    	printAVLTree(root, "", true);
    }
}