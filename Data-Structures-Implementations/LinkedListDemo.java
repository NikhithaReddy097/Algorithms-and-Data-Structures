import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    //inserting a new element to the end of linkedlist
    Node insertLast(Node start, int data){
        Node newNode = new Node(data);
        if(start == null){   
            start = newNode;
        }
        else{    
            Node temp = start;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode; 

        }
        System.out.println("Element inserted into LinkedList!");
        return start;
    }

    //inserting a new element to the start of linkedlist
    Node insertFirst(Node start, int data){
        Node newNode = new Node(data);
        if(start == null){   
            start = newNode;
        }
        else{    
            newNode.next = start;
        }
        System.out.println("Element inserted into LinkedList!");
        return newNode;
    }

    //Deleting the node based on data of node
    Node deleteByValue(Node root, int value){
        Node start = root;
        if(start!=null && start.data == value){
            System.out.println("Element Deleted!");
            return start.next;
        } 
        while(start.next!=null && start.next.data!=value){
            start = start.next;
        }
        if(start.next == null) System.out.println("Element not found!");
        else{
            start.next = start.next.next;
            System.out.println("Element deleted!");
        }
        return root;
    }

    //Deleting the node based on index of node
    Node deleteByIndex(Node root, int index){
        if(index < 0){
            System.out.println("Enter valid index!");
            return root;
        }
        Node start = root;
        int size = listSize(start);
        if(size < index){
            System.out.println("Insufficient elements!");
        }else{
            if(index == 1){
                return root.next;
            }
            for(int i=1; i<index-1; i++){
                start = start.next;
            }
            start.next = start.next.next;
            System.out.println("Element Deleted!");
        }
        return root;
    }

    //finding size of list
    int listSize(Node root){
        int count = 0;
        while(root!=null){
            count++;
            root = root.next;
        }
        return count;
    }

    //Displaying the contents of list
    void display(Node start){
        System.out.print("Elements of linkedlist are : ");
        while(start != null){                                                
            System.out.print(start.data+" -> ");
            start = start.next;                                            
        }
        System.out.println("NULL");
    }
}

class LinkedListDemo{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        Node root = null;
        int ch = 1, data;

        System.out.println("\n\n1.Insert First  2.Insert Last  3.Delete by Value  4.Delete By Index  5.Print List  6.Exit\n\n");
        do{
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter the element to be inserted: ");
                    data = sc.nextInt();
                    root = list.insertFirst(root, data);
                    break;
                case 2:
                    System.out.print("Enter the element to be inserted: ");
                    data = sc.nextInt();
                    root = list.insertLast(root, data);
                    break;
                case 3:
                    System.out.print("Enter the element to be deleted: ");
                    data = sc.nextInt();
                    root = list.deleteByValue(root, data);
                    break;
                case 4:
                    System.out.print("Enter the index to be deleted: ");
                    data = sc.nextInt();
                    root = list.deleteByIndex(root, data);
                    break;
                case 5:
                    list.display(root);
                    break;
                case 6:
                    System.out.println("LinkedList Operations completed!");
                    break;
                default:
                    System.out.println("Invalid choice⚠️");
            }

        }while(ch != 6);
        sc.close();

    }
}