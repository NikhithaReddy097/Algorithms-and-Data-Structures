import java.util.Scanner;

class Stack{
    int stack[];
    int top;
    public Stack(){
        stack = new int[100];
        top = -1;
    }
    public void push(int data){
        if(top==stack.length-1){
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        stack[top] = data;
    }

    public void pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println(stack[top]+" is popped");
        top--;
    }
    public void display(){
        System.out.println("Stack elements");
        System.out.println("--------------");
        for(int i=top; i>=0; i--){
            System.out.println(stack[i]);
        }
    }
}

public class StackDemo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        int ch = 1, data;

        System.out.println("\n\n1.Push   2.Pop   3.Display  4.Exit\n\n");
        do{
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter the element to push: ");
                    data = sc.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting Stack opeartions! ");
                default:
                    System.out.println("Invalid choice⚠️");
            }

        }while(ch != 4);
        sc.close();
    }
}
