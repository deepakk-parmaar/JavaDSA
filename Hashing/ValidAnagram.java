import java.util.HashMap;

public class ValidAnagram {

    public static boolean isAnagram(String a, String b) {
        HashMap <Character,Integer> map = new HashMap<>();

        for(int i=0; i<a.length();i++){
            map.put(a.charAt(i),map.getOrDefault(a.charAt(i), 0)+1);
        }
        for(int i=0;i<b.length();i++){
            if(map.containsKey(b.charAt(i))){
                if(map.get(b.charAt(i))==1){
                    map.remove(b.charAt(i));
                }else{
                    map.put(b.charAt(i),map.get(b.charAt(i))-1);
                }
            }else return false;
        }
        return map.isEmpty();
    }
    
    public static void main(String[] args) {
        boolean test = isAnagram("null", "hull");
        boolean test2 = isAnagram("null", "ulln");
        System.out.println(test + " "+ test2);
        
    }
}
