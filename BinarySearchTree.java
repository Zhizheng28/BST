import java.lang.NullPointerException;

public class BinarySearchTree {

    //Initialize Varibles    
    private NodeType root;

    /**
     * Constructor
     */
    public BinarySearchTree() {
        this.root = null;
    } // SortedLinkedList

    /**
     * Insert a node with the value of key into the tree 
     * No duplicates are allowed.
     * @param key
     */
    public void insert(ItemType key) {
        if (retrieve(key) == false) {
            root = insertRec(root, key);        
        } else {
            System.out.println("The item already exists in the tree.");
        }
    } // insert

    private NodeType insertRec(NodeType tree, ItemType key) {
        if (tree == null) {
            NodeType node = new NodeType();
            node.info = key;
            tree = node;
            return tree;
        }
        if (key.compareTo(tree.info) == -1) {
            tree.left = insertRec(tree.left, key);
        } else if (key.compareTo(tree.info) == 1) {
            tree.right = insertRec(tree.right, key);
        } 
        return tree;
    } // insert

    /**
     * Remove a node with a key value equal to the parameter key's value
     * other wise leave tyhe root unchanged.
     * @param key
     */
    public void delete(ItemType key) {
        if (retrieve(key) == true) {
            if (root == null) {
                System.out.println("Empty Tree");
            } else {
                root = deleteRec(root, key);
            }
        } else {
            System.out.println("The number is not present in the tree");
        }
    } // delete

    private NodeType deleteRec(NodeType tree, ItemType key) {
        if (key.compareTo(tree.info) == -1) {
            tree.left = deleteRec(tree.left, key);
        } else if (key.compareTo(tree.info) == 1) {
            tree.right = deleteRec(tree.right, key);
        } else {
            if (tree.left == null && tree.right == null) {
                return null;
            } else if (tree.left != null && tree.right == null) {
                return tree.left;
            } else if (tree.right != null && tree.left == null) {
                return tree.right;
            } else {
                NodeType temp = new NodeType();
                temp = findPred(tree);
                tree.info = temp.info;
                tree.left = deleteRec(tree.left, temp.info);
                return tree;
            }
        }
        return tree;
    }

    private NodeType findPred(NodeType pred) {
        if (pred == null) {
            return null;
        }        
        if (pred.left != null) { // find predecessor
            NodeType temp = pred.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        } else { // find succesor 
            NodeType temp = pred.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } //if/else
    }

    /**
     * Item should refer to a key of a Node n in the root where the value of n.key
     * is equal to the value of item.
     * @param key
     * @return true if n exists else return false.
     */
    public boolean retrieve(ItemType key) {
        NodeType temp = new NodeType();
        temp = root;
        temp = retrieveRec(temp, key); 
        if (temp != null) {
            return true;
        } else {
            return false;
        } 
    } // retrieve
    
    private NodeType retrieveRec(NodeType tree, ItemType key) {
        if (tree == null || key.compareTo(tree.info) == 0) {
            return tree;
        } 
        if (key.compareTo(tree.info) == -1) {
            return retrieveRec(tree.left, key);
        } else if (key.compareTo(tree.info) == 1 ){
            return retrieveRec(tree.right, key);
        } else {
            return null;
        }
    }

    /**
     * Print out the root in order.
     */
    public void inOrder() {
        inOrderRec(root);        
    } // inOrder

    private void inOrderRec(NodeType root) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.info.getValue() + " ");
        inOrderRec(root.right);
    }

    /**
     * Print the nodes that have one child.
     */
    public void getSingleParent() {
        getSingleParentRec(root);
        System.out.println();
    } // getSingleParent

    private void getSingleParentRec(NodeType tree) {
        if (tree == null) {
            return;
        } else {
            if ((tree.left != null && tree.right == null) || (tree.left == null && tree.right != null)) {
                System.out.print(tree.info.getValue() + " ");
            }
        }
        getSingleParentRec(tree.left);
        getSingleParentRec(tree.right);
    }

    /**
     * Count the number of leaf nodes in the BST.
     * @return the count of number of leaf nodes.
     */
    public int getNumLeafNodes() {
        return countLeaf(root);
    } // getNumLeafNodes

    private int countLeaf(NodeType tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        } else {
            int leftLeaf;
            int rightLeaf;
            leftLeaf = countLeaf(tree.left);
            rightLeaf = countLeaf(tree.right);
            return leftLeaf + rightLeaf;
        }
    } // countLeaf

    /**
     * Take in a node as input and prints the cousins of the given node.
     */
    public void getCousins(ItemType key) {
        try {
            NodeType temp = getParent(root, key);
            NodeType currentPos = getParent(root, temp.info);; 
            if (currentPos.left == temp) {
               currentPos = currentPos.right;
               System.out.print(currentPos.left.info.getValue() + " ");
               System.out.print(currentPos.right.info.getValue() + " ");
            } else if (currentPos.right == temp) {
                currentPos = currentPos.left;
                System.out.print(currentPos.left.info.getValue() + " ");
                System.out.print(currentPos.right.info.getValue() + " ");
            } else {
                System.out.print("");
            }
        } catch (NullPointerException exception) {
            System.out.print("");
        }
    } // getCousins

    /**
     * Get the parent of a node.
     * @param tree
     * @param key
     * @return parent node
     */
    public NodeType getParent(NodeType tree, ItemType key) {
        NodeType parent = new NodeType();
        if(tree == null) {
            return null;
        }
        while(tree != null) {
            if (key.compareTo(tree.info) == -1) {
                parent = tree;
                tree = tree.left;
            } else if (key.compareTo(tree.info) == 1) {
                parent = tree;
                tree = tree.right;
            } else {
                break;
            }
        }
        return parent;
    } // getParent

} // BinarySearchTree