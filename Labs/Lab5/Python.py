class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def is_valid_bst(root, min_val=float('-inf'), max_val=float('inf')):
    if root is None:
        return True

    if not min_val < root.val < max_val:
        return False

    return is_valid_bst(root.left, min_val, root.val) and is_valid_bst(root.right, root.val, max_val)

if __name__ == "__main__":
    root = TreeNode(4, TreeNode(3, TreeNode(1), None), TreeNode(8, TreeNode(5), TreeNode(9)))
    solution = is_valid_bst(root)
    print(solution)
