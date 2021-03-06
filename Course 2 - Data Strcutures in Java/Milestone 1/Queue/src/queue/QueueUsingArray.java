package queue;

public class QueueUsingArray {


	    private int data[];
	    private int front;
	    private int rear;
	    private int size;

	    public QueueUsingArray(){

	        data= new int[5];
	        front= -1;
	        rear= -1;
	    }

	    public QueueUsingArray(int capacity){

	        data= new int[capacity];
	        front= -1;
	        rear= -1;
	    }
	    
	    private void doubleCapcaity() {
			// TODO Auto-generated method stub
	    	int temp[] = data;
	    	data = new int[temp.length * 2];
	    	int index = 0;
	    	
	    	// for circular Queue
	    	for(int i = front;i<temp.length;i++) {
	    		data[index++] = temp[i];
	    	}
	    	
	    	for(int i = 0;i< front-1 ;i++) {
	    		data[index++] = temp[i];
	    	}
	    	
	    	front =0;
	    	rear = temp.length-1;
			
		}

	    public int size(){
	      return size;
	    }

	    public boolean isEmpty(){
	        return size==0;
	    }

	    public void enqueue(int elem){
	      if(size== data.length){
	    	  doubleCapcaity();
//	        throw new QueueFullException();
	      }
	      if(size==0){
	        front=0;
	      }
	      
	       // for circular queue operation
	        rear++;
	        if(rear== data.length){
	            rear=0;
	        }
	        data[rear]= elem;
	        size++;
	    }

	    public int front() throws QueueEmptyException{
	        if(size==0){
	            throw new QueueEmptyException();
	        }
	        return data[front];
	    }

	    public int dequeue() throws QueueEmptyException{
	      if(size == 0){
	        throw new QueueEmptyException();
	        }
	      
	        int temp= data[front];
	        
	        front++;
	        if(front == data.length) {
	        	front=0;
	        }
	        size--;
	        
	        if(size==0){
	            front=-1;
	            rear= -1;
	        }
	        
	        return temp;
	    }

}


