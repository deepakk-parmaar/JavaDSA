import java.util.*;

public class PriorityQueues{
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();


        public void add(int data){
            arr.add(data);

            int x = arr.size()-1; //parent's index
            int par=(x-1)/2;

            while(arr.get(x) < arr.get(par)){
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x=par;
                par=(x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify (int i) {
            int left = 2*i + 1;
            int right= 2*i + 2;
            int minidx= i;

            if(left < arr.size() && arr.get(left) < arr.get(minidx)){
                minidx = left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minidx)){
                minidx = right;
            }
            if(minidx!=i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minidx));
                arr.set(minidx,temp);

                heapify(minidx);
            }
        }
        public int remove(){
            int  data = arr.get(0);

            //step 1 Swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            //step 2 delete last element
            arr.remove(arr.size()-1);
            //step 3 heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty (){
            return arr.size()==0;
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(3);
        pq.add(5);

    }
}