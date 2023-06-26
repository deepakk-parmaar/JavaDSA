public class UniqueSubstring {
    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord=false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
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
    public static int countUniqueSubstring(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countUniqueSubstring(root.children[i]);
            }
        }
        return count+1;
    }
    
    public static void main(String[] args) {
        String word="ababa";

        for(int i=0;i<word.length();i++){
            insert(word.substring(i));
        }
        System.out.println(countUniqueSubstring(trie));
        
    }
}
