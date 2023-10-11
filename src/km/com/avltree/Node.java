package km.com.avltree;

/**
 *
 * @author Kazumi
 */
public class Node {
      String data;

      Node left;
      Node right;
      Node parent;

      boolean color;

      public Node(String data) {
        this.data = data;
      }
              //IMPRIME A ÁRVORE
            public String buildRBTreeString() {
                StringBuilder treeString = new StringBuilder();
                buildRBTreeString(treeString, true, "");
                return treeString.toString();
            }   

            private void buildRBTreeString(StringBuilder treeString, boolean isRight, String indent) {
                if (right != null) {
                    right.buildRBTreeString(treeString, true, indent + (isRight ? "        " : " |      "));
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
                    left.buildRBTreeString(treeString, false, indent + (isRight ? " |      " : "        "));
                }
            }

            private void appendNodeValue(StringBuilder treeString) {
                if (data == null) {
                    treeString.append("<null>\n");
                } else {
                    treeString.append(data).append(color ? " (BLACK)" : " (RED)").append('\n');
                }
            }
    }
