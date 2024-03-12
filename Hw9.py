class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def lowestCommonAncestor(root, p, q):
    if root is None or root == p or root == q:
        return root
    
    if root.val > p.val and root.val > q.val:
        return lowestCommonAncestor(root.left, p, q)
    if root.val < p.val and root.val < q.val:
        return lowestCommonAncestor(root.right, p, q)
    
    return root

if __name__ == "__main__":
    
    root = TreeNode(4, TreeNode(3, TreeNode(1)), TreeNode(8, TreeNode(5), TreeNode(9)))
    
    # Selecting nodes for which lowest common ancestor needs to be found
    p = root.left.left
    q = root.right.left
    
    # Finding the lowest common ancestor
    solution = lowestCommonAncestor(root, p, q)
    
    
    if solution is not None:
        print(solution.val)
