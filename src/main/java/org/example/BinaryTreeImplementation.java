package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImplementation {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree {
        static int i = -1;
        public static Node buildTree(int nodes[]) {
            //      1
            //    2   3
            //   4 5 6  7
           // int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
            i++;
            if (nodes[i] == -1)
                return null;

            Node new_node=new Node(nodes[i]);
            new_node.left=buildTree(nodes);
            new_node.right=buildTree(nodes);
           // System.out.println("build tree");
            System.out.println(new_node.data+" ");
            return new_node;
        }
        public static void preOrder(Node root){
            //      1
            //    2   3
            //   4 5 6  7
            if(root==null)
                return;
            System.out.print(root.data+", ");
            preOrder(root.left);
            preOrder(root.right);

        }
        public static void inOrder(Node root){
            if(root==null)
                return;
            inOrder(root.left);
            System.out.print(root.data+", ");
            inOrder(root.right);
        }
        public static void postOrder(Node root){
            if(root==null)
                return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+", ");
        }

        public static void levelOrder(Node root){
            //      1
            //    2   3
            //   4 5 6  7  queue:
            if(root==null)
                return;
            Queue<Node> queue=new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty()){
                Node currentNode=queue.remove();
                if(currentNode==null) {
                    System.out.println();
                    if (queue.isEmpty())
                        break;
                    else
                        queue.add(null);
                }
                else{
                    System.out.print(currentNode.data);
                    if(currentNode.left != null)
                        queue.add(currentNode.left);
                    if(currentNode.right != null)
                        queue.add(currentNode.right);
                }
            }
        }

        public static void main(String []args){
         //      1
         //    2   3
         //   4 5 6  7
            int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
            BinaryTree tree=new BinaryTree();
            Node root=tree.buildTree(nodes);
            System.out.println(root.data);
            preOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            postOrder(root);
            System.out.println();
            levelOrder(root);

        }
    }
}
