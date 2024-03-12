import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, new TreeNode(3, new TreeNode(1), null), new TreeNode(8, new TreeNode(5), new TreeNode(9)));

        // Getting the nodes for which lowest common ancestor is needed to find
        TreeNode p = root.left.left;
        TreeNode q = root.right.left;

        TreeNode solution = lowestCommonAncestor(root, p, q);
        if (solution != null) {
            System.out.println(solution.val);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // Base cases = when root is null or one of the nodes is the root, then we return root
            return root;
        }

        if (root.val > p.val && root.val > q.val) { 
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // when one node is in the left subtree and the other is in the right subtree, or if one of the nodes is the current root,
        // hence the current root is the lowest common ancestor.
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

