public class StartsWith {
    static class Node{
        Node[] children;
        boolean endOfWord;
        Node(){
            children = new Node[26];
            endOfWord = false;
        }
    }

    public static Node trie = new Node();

    public static void insert(String word){
        Node curr = trie;
        for(int level = 0 ; level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr=curr.children[idx];
        } 
        curr.endOfWord=true;
    }

    //function to print all the words in the trie
    public static void printAllWords(Node root,String word){
        if(root.endOfWord){
            System.out.println(word);
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                printAllWords(root.children[i],word+(char)(i+'a'));//
            }
        }
    }

    public static boolean startWith(String word){
        Node curr = trie;
        for(int level = 0 ; level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        } 
        return true;
    }
    public static void main(String[] args) {
        //insert all the words in the trie
        insert("apple");
        insert("app");
        insert("ap");
        insert("appletree");
        
        //check startsWith on the trie
        System.out.println(startWith("app"));
        System.out.println(startWith("ap"));
        System.out.println(startWith("apple"));
        System.out.println(startWith("appletree"));
        System.out.println(startWith("appletrees"));
    }
}
