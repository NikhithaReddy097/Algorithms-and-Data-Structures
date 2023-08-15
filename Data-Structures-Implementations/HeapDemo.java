import java.util.Scanner;
class Heap {
    int heap[];
    static int size;
    public Heap(){
        heap = new int[1000];
        size = 0;
    }

    public void printData(){
        System.out.print("Heaps elements are: ");
        for(int i=0; i<size; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    //we place the element at the end and trigger percolate up
    public void insert(int data){
        heap[size] = data;
        size++;
        percolateUp();
    }
    //In heap we delete the root element
    public void delete(){
        if(size==0){
            System.out.println("Heap is empty!");
            return;
        }
        int deleted = heap[0];
        heap[0] = heap[size-1];
        size--;
        percolateDown();
        System.out.println("Deleted element is: "+deleted);
    }
    //main functionality of heap to get the minimum value within O(1) time
    public void getMin(){
        if(size==0){
            System.out.println("Heap is empty!");
        }
        else{
            System.out.println("Minimum element in heap is: "+heap[0]);
        }
    }
    //whenever an element is inserted in heap we start from backwards and 
    //swap the elements if the parent is greater than a child
    public void percolateUp(){
        for(int i=size-1; i>=0; i--){
            int p_idx = parent(i);
            if(p_idx >= 0 && heap[p_idx] > heap[i]){
                swap(p_idx, i);
            }
        }
    }

    //Whenever an element is deleted in heap we place the last element as root and 
    //we start from beginning of heap and swap the elements if
    // the child is less than parent element
    public void percolateDown(){
        for(int i=0; i<size; i++){
            //two children
            if(leftchild(i)<size && rightchild(i)<size){
                //if parent is greater than it's children
                if(heap[i]>heap[leftchild(i)] || heap[i]>heap[rightchild(i)]){
                    //if left child has minimum value swap parent with left child
                    if(heap[leftchild(i)] < heap[rightchild(i)])
                        swap(leftchild(i), i);
                    //if right child has minimum value swap parent with right child
                    else
                        swap(rightchild(i), i);
                }
            }
            //single child
            else if(leftchild(i)<size || rightchild(i)<size){
                //if it has only left child and parent value is greater than left child swap them
                if(leftchild(i)<size && heap[leftchild(i)] < heap[i])
                    swap(leftchild(i), i);
                //if it has only right child and parent value is greater than right child swap them
                if(rightchild(i) < size && heap[rightchild(i)] < heap[i])
                    swap(rightchild(i), i);
            }
            
        }

    }

    // returns the index of children based on parent index
    public int leftchild(int i){
        return 2*i+1;
    }
    public int rightchild(int i){
        return 2*i+2;
    }
    //return index of parent based on child index
    public int parent(int i){
        return (i-1)/2;
    }
    //swap function
    public void swap(int id1, int id2){
        int temp = heap[id1];
        heap[id1] = heap[id2];
        heap[id2] = temp;
    }
}

public class HeapDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap heap = new Heap();
        System.out.println("\n\n1.Insert\t2.Delete\t3.Display Minimum\t4.Display Heap\t5.Exit\n\n");
        int ch = 1,data;
        do{
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter element to insert: ");
                    data = sc.nextInt();
                    heap.insert(data);
                    break;
                case 2:
                    heap.delete();
                    break;
                case 3:
                    heap.getMin();
                    break;
                case 4:
                    heap.printData();
                    break;
                case 5:
                    System.out.println("Exiting Heap Operations!");
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }while(ch != 5);
        sc.close();
    }
}


