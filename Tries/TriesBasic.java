public class TriesBasic{

    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord;

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
    public static boolean search(String word){
        Node curr = trie;
        for(int level = 0 ; level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        } 
        return curr.endOfWord;
    }
    public static void main(String[] args) {
        
    }
}