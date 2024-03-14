public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(3, new TreeNode(1),null), new TreeNode(8,new TreeNode(5),new TreeNode(9)));
        Boolean solution = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(solution);
    }

    public static Boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
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
