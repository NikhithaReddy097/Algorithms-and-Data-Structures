import java.util.Scanner;

class Queue{
    int queue[];
    int front, rear;
    public Queue(){
        queue = new int[100];
        front = -1;
        rear = -1;
    }
    //adding element to queue
    void enqueue(int data){
        if(rear == queue.length-1){
            System.out.println("Queue is full!");
            return;
        }
        if(front == -1 && rear == -1){
            front = 0;
            rear = 0;
            queue[front] = data;
        }
        else{
            rear++;
            queue[rear] = data;
        }
        System.out.println("Element added!");
    }
    void dequeue(){
        if(front == -1){
            System.out.println("Queue is empty!");
            return;
        }
        int deleted = queue[front];
        if(front == rear){
            front = -1;
            rear = -1;
        }else{
            front++;
        }
        System.out.println(deleted+" is deleted from queue");
    }
    void display(){
        if(front == -1 || rear == -1){
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for(int i=front; i<=rear; i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();

    }
}
public class QueueDemo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        int ch,data;
        System.out.println("\n\n1.Enqueue 2.Dequeue 3.Display 4.Exit\n\n");

        do{
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter the element to insert: ");
                    data = sc.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting Queue Operations!");
                    break;
                default:
                    System.out.println("Invalid choice⚠️");

            }

        }while(ch != 4);
        sc.close();
    }
}
