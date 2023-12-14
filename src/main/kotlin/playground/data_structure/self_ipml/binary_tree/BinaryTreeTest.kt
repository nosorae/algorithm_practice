package playground.data_structure.self_ipml.binary_tree

fun main() {
    val nodeA: TreeNode<String> = TreeNode("A")
    val nodeB: TreeNode<String> = TreeNode("B")
    val nodeC: TreeNode<String> = TreeNode("C")
    val nodeD: TreeNode<String> = TreeNode("D")
    val nodeE: TreeNode<String> = TreeNode("E")
    val nodeF: TreeNode<String> = TreeNode("F")
    val nodeG: TreeNode<String> = TreeNode("G")
    val nodeH: TreeNode<String> = TreeNode("H")
    val nodeI: TreeNode<String> = TreeNode("I")
    val nodeJ: TreeNode<String> = TreeNode("J")
    val nodeK: TreeNode<String> = TreeNode("K")
    val nodeL: TreeNode<String> = TreeNode("L")
    val nodeM: TreeNode<String> = TreeNode("M")

    val binaryTree: BinaryTree<String> = BinaryTree()
    binaryTree.makeBinaryTree(nodeA)
    binaryTree.insertLeftChildNode(nodeA, nodeB)
    binaryTree.insertRightChildNode(nodeA, nodeC)
    binaryTree.insertLeftChildNode(nodeB, nodeD)
    binaryTree.insertRightChildNode(nodeB, nodeE)
    binaryTree.insertLeftChildNode(nodeC, nodeF)
    binaryTree.insertRightChildNode(nodeC, nodeG)
    binaryTree.insertLeftChildNode(nodeD, nodeH)
    binaryTree.insertRightChildNode(nodeD, nodeI)
    binaryTree.insertLeftChildNode(nodeE, nodeJ)
    binaryTree.insertRightChildNode(nodeF, nodeK)
    binaryTree.insertLeftChildNode(nodeG, nodeL)
    binaryTree.insertRightChildNode(nodeG, nodeM)

    println("\n Preorder : ")
    binaryTree.traversePreorder(nodeA)

    println("\n Inorder : ")
    binaryTree.traverseInorder(nodeA)

    println("\n Postorder : ")
    binaryTree.traversePostorder(nodeA)
}