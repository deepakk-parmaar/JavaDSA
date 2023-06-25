public class PrefixProblem {
    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord;
        int freq;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }
    public static Node trie = new Node();

    public static void insert(String word){
        Node curr = trie;
        for(int level = 0 ; level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
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
        return curr.endOfWord==true;
    }

    public static boolean wordBreak(String key) {
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0, i))&&wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String arr[]={"i","like","samsung"};

        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        String key="ilikesamsung";

        System.out.println(wordBreak(key));
    }
}
