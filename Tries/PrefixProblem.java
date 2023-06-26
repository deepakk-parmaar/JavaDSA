public class PrefixProblem {
    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord=false;
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

    public static void findPrefix(Node root, String ans, int idx){
        if(root==null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findPrefix(root.children[i], ans+(char)(i+'a'), idx+1);
            }
        }
    }
    public static void main(String[] args) {
        String arr[]={"zebra","duck","dog","dove"};
        trie.freq=-1;
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        System.out.println("Prefixes are: ");
        findPrefix(trie,"",0);
    }
}
