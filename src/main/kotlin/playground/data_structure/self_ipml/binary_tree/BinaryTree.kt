package playground.data_structure.self_ipml.binary_tree

class BinaryTree<T> {
    private var root: TreeNode<T>? = null

    fun makeBinaryTree(rootNode: TreeNode<T>): TreeNode<T> {
        root = rootNode
        return rootNode
    }

    fun insertLeftChildNode(parentNode: TreeNode<T>, element: TreeNode<T>): TreeNode<T> {
        if (parentNode.left != null) throw IllegalArgumentException()
        parentNode.left = element
        return element
    }

    fun insertRightChildNode(parentNode: TreeNode<T>, element: TreeNode<T>): TreeNode<T> {
        if (parentNode.right != null) throw IllegalArgumentException()
        parentNode.right = element
        return element
    }

    fun traverseInorder(currentNode: TreeNode<T>) {
        currentNode.left?.let { left ->
            traverseInorder(left)
        }
        print("${currentNode.data} ")
        currentNode.right?.let { right ->
            traverseInorder(right)
        }
    }

    fun traversePreorder(currentNode: TreeNode<T>) {
        print("${currentNode.data} ")
        currentNode.left?.let { left ->
            traversePreorder(left)
        }
        currentNode.right?.let { right ->
            traversePreorder(right)
        }
    }

    fun traversePostorder(currentNode: TreeNode<T>) {
        currentNode.left?.let { left ->
            traversePostorder(left)
        }
        currentNode.right?.let { right ->
            traversePostorder(right)
        }
        print("${currentNode.data} ")
    }
}