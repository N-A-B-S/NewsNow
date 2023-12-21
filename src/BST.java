public class BST<K extends Comparable<K>, V>{
    /*
    My thought process here is that a BST must be able to determine where to place a new node.
    To compare a key against any other key (of the same time), it must have an explicitly declared compareTo() function.
    This allows objects of the same time to be compared against each other, to determine which is lower/higher etc.

    Therefore, for any arbitrary data type, a developer can decide to declare a compareTo() (if one is not already defined) function,
    which then allows the BST to figure out where the new node should be placed.

    Value can be anything, we're not too fussed about this in the grand scheme of a BST.
    But we wanted to make sure that every node has a key value pair.

    By using K and V as my 'types', it allows for the type to be determined when the BST is initialised, allowing for flexibility
    of implementation.

    */

    private Node root;
    private Node someNode;

    class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public String toString(){
            String nodeString = key + ":" + value;
            return nodeString;
        }
    }

    public BST(){
        root = null;
    }

    //Recursive function means that the node will be added in the 'correct' location, based on
    //comparisons with the parent nodes.
    private Node addRecursive(Node current, K key, V value){
        if (current == null){
            return new Node(key, value);
        }

        int compare = key.compareTo(current.key);

        if (compare == 0){
           current.value = value;
        } else if (compare > 0){
            current.right = addRecursive(current.right, key, value);
        } else {
            current.left = addRecursive(current.left, key, value);
        }
        return current;
    }

    public void addNode(K key, V value){
        root = addRecursive(root, key, value);
    }

    private boolean containsNodeRecursive(Node current, K key){
        if (current == null){
            return false;
        }

        int compare = key.compareTo(current.key);

        if (compare == 0){
            someNode = current; //Need this for the add/retrieve data attached to the nodes, else how do I know which node I'm on?
            return true;
        }

        if (compare > 0){
            return containsNodeRecursive(current.right, key);
        } else {
            return containsNodeRecursive(current.left, key);
        }
    }

    public boolean containsNode(K key){
        return containsNodeRecursive(root, key);
    }

    //Document references a method to store a value under a given key.
    //Value is added in the Node constructor, but can be overwritten here.
    public void addDataToNode(K key, V value){
        if (containsNode(key)){
            someNode.setValue(value);
        }
    }

    //Need another method to retrieve a value stored under a key.
    public String getDataAttachedToNode(K key){
        String value = "Node with key " + key.toString() + " doesn't exist in BT";
        if (containsNode(key)){
            value = someNode.getValue().toString();
        }
        return value;
    }

    public void printInOrder(){
        recursivePrintInOrder(root);
    }

    private void recursivePrintInOrder(Node current){
        if (current == null){
            return;
        }
        recursivePrintInOrder(current.left);
        System.out.println(current);
        recursivePrintInOrder(current.right);
    }







}
