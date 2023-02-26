package StackandQueue;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    int pointer= -1;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        this.data= new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full! ");
            return false;
        }
        pointer++;
        data[pointer]=item;
        return true;
    }
    public int pop() throws CustomException{
        if(isEmpty()){
            throw new CustomException("Stack is empty");
        }
        int removed=data[pointer];
        pointer--;
        return removed;
    }
    public int peek() throws CustomException{
        if(isEmpty()){
            throw new CustomException("Stack is empty");
        }
        return data[pointer];
    }
    public boolean isFull(){
        return pointer== data.length-1;
    }
    public boolean isEmpty(){
        return pointer==-1;
    }
}
