from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def invert_tree(root):
    if root is None:
        return None
    
    queue = deque([root])
    
    while queue:
        current = queue.popleft()
        current.left, current.right = current.right, current.left
        
        if current.left:
            queue.append(current.left)
        if current.right:
            queue.append(current.right)
    
    return root

def print_tree(root):
    if root is None:
        return
    print(root.val, end=" ")
    print_tree(root.left)
    print_tree(root.right)

if __name__ == "__main__":
    root = TreeNode(4, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(8, TreeNode(5), TreeNode(6)))
    print("Normal:")
    print_tree(root)
    print("\nInverted:")
    invert_tree(root)
    print_tree(root)
