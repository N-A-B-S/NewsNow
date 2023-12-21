public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bt = new BST<Integer, String>();
        bt.addNode(25, "Yellow");
        bt.addNode(12, "Red");
        bt.addNode(7, "Black");
        bt.addNode(57, "Cyan");
        bt.addNode(34, "Green");
        bt.addNode(16, "Burgundy");

        bt.printInOrder();

        if (bt.containsNode(7)){
            System.out.println("Contains node");
        } else {
            System.out.println("Doesn't contain node");
        }
        if (bt.containsNode(8)){
            System.out.println("Contains node");
        } else {
            System.out.println("Doesn't contain node");
        }

        System.out.println(bt.getDataAttachedToNode(57));
        System.out.println(bt.getDataAttachedToNode(8));

        bt.addDataToNode(57, "This isn't a colour...");
        System.out.println(bt.getDataAttachedToNode(57));

        BST<String, Integer> bt2 = new BST<String, Integer>();
        bt2.addNode("Mulberry", 2);
        bt2.addNode("Banana", 5);
        bt2.addNode("Orange", 8);
        bt2.addNode("Blueberry", 12);

        bt2.printInOrder();

        if (bt2.containsNode("Banana")){
            System.out.println("Contains node");
        } else {
            System.out.println("Doesn't contain node");
        }
        if (bt2.containsNode("Dragonfruit")){
            System.out.println("Contains node");
        } else {
            System.out.println("Doesn't contain node");
        }

        System.out.println(bt2.getDataAttachedToNode("Banana"));
        System.out.println(bt2.getDataAttachedToNode("Mango"));

        bt2.addDataToNode("Banana", 999);
        System.out.println(bt2.getDataAttachedToNode("Banana"));

    }
}