import java.util.*;
public class Strings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //write all the necessary methods of strings class
        //1. length()
        System.out.println(s.length());
        //2. charAt()
        System.out.println(s.charAt(0));
        //3. substring()
        System.out.println(s.substring(0, 3));
        //4. indexOf()
        System.out.println(s.indexOf("a"));
        //5. lastIndexOf()
        System.out.println(s.lastIndexOf("a"));
        //6. contains()
        System.out.println(s.contains("a"));
        //7. equals()
        System.out.println(s.equals("a"));
        //8. equalsIgnoreCase()
        System.out.println(s.equalsIgnoreCase("a"));
        //9. compareTo()
        System.out.println(s.compareTo("a"));
        //10. compareToIgnoreCase()
        System.out.println(s.compareToIgnoreCase("a"));
        //11. toLowerCase()
        System.out.println(s.toLowerCase());
        //12. toUpperCase()
        System.out.println(s.toUpperCase());
        //13. trim()
        System.out.println(s.trim());
        //14. replace()
        System.out.println(s.replace("a", "b"));
        //15. split()
        String arr[] = s.split(" ");
        for(String str:arr){
            System.out.println(str);
        }
        //16. join()
        System.out.println(String.join(" ", arr));
        //17. startsWith()
        System.out.println(s.startsWith("a"));
        //18. endsWith()
        System.out.println(s.endsWith("a"));
        //19. isEmpty()
        System.out.println(s.isEmpty());
        //20. concat()
        System.out.println(s.concat("a"));
        

    }
}