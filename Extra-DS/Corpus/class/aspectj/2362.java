package ca.ubc.cs.spl.aspectPatterns.examples.visitor.aspectj;

public class Main {

    /**
     * Implements the driver for the Visitor design pattern example.<p> 
     *
     * @param args the command-line parameters, unused
     */
    public static void main(String[] args) {
        System.out.println("Building the tree (1): leaves");
        BinaryTreeLeaf one = new BinaryTreeLeaf(1);
        BinaryTreeLeaf two = new BinaryTreeLeaf(2);
        BinaryTreeLeaf three = new BinaryTreeLeaf(3);
        System.out.println("Building the tree (1): regular nodes");
        BinaryTreeNode regN = new BinaryTreeNode(one, two);
        BinaryTreeNode root = new BinaryTreeNode(regN, three);
        System.out.println("The tree now looks like this: ");
        System.out.println("         regN                 ");
        System.out.println("        /    \\               ");
        System.out.println("    regN      3               ");
        System.out.println("   /    \\                    ");
        System.out.println("  1      2                    ");
        System.out.println("Visitor 1: SumVisitor, collects the sum of leaf");
        System.out.println("values. Result should be 6.");
        SummationVisitor sumVisitor = new SummationVisitor();
        root.accept(sumVisitor);
        System.out.println(sumVisitor.report());
        System.out.println("Visitor 2: TraversalVisitor, collects a tree");
        System.out.println("representation. Result should be {{1,2},3}.");
        TraversalVisitor traversalVisitor = new TraversalVisitor();
        root.accept(traversalVisitor);
        System.out.println(traversalVisitor.report());
    }
}
