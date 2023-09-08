
package km.com.referencia;


import java.util.ArrayList;

public class ArvoreAVL {
    
public class Node {
        char letra;
        ArrayList<String> palavras;
        int height;
        Node left;
        Node right;

        Node(char letra) {
            this.letra = letra;
            palavras = new ArrayList<>();
        }
    }

    private Node root;

    public boolean find(String palavra) {
        char letra = palavra.charAt(0);
        Node current = root;
        while (current != null) {
            if (current.letra == letra) {
                if (current.palavras.contains(palavra)) {
                    return true;
                } else {
                    return false; // palavra não encontrada
                }
            }
            current = current.letra < letra ? current.right : current.left;
        }
        return false; // letra não encontrada
    }

    public void insert(String palavra) {
        char letra = palavra.charAt(0);
        root = insert(root, letra, palavra);
    }

    public void delete(char letra) {
        root = delete(root, letra);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, char letra, String palavra) {
        if (node == null) {
            return new Node(letra);
        } else if (node.letra > letra) {
            node.left = insert(node.left, letra, palavra);
        } else if (node.letra < letra) {
            node.right = insert(node.right, letra, palavra);
        } else {
            node.palavras.add(palavra);
        }
        return rebalance(node);
    }

    private Node delete(Node node, char letra) {
        if (node == null) {
            return node;
        } else if (node.letra > letra) {
            node.left = delete(node.left, letra);
        } else if (node.letra < letra) {
            node.right = delete(node.right, letra);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.palavras = mostLeftChild.palavras;
                node.right = delete(node.right, node.letra);
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
            System.out.println(node.palavras);

            printAVLTree(node.left, indent, false);
            printAVLTree(node.right, indent, true);
        }
    }

    
    public void printAVLTree() {
    	printAVLTree(root, "", true);
    }
}
