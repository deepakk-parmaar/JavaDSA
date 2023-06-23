import java.util.ArrayList;;
public class IntroArrayList{
    public static void main(String[] args) {
        //Similar to vectors in C++
        //Java Collection Framework
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);//O(1)
        System.out.println(list);
        int element = list.get(2);//O(1)
        System.out.println(element);
        list.remove(1);//O(n)
        list.set(1, 10);//O(n)
        System.out.println(list);
        list.contains(1);
        //Multidimensional
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        list2.add(list);
    }
}