public class LongestWordWithAllPrefix {
    static class Node{
        Node children[] = new Node[26];
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
    //function to print all the words in the trie  
    public static void printAllWords(Node root,String word){
        if(root.endOfWord){
            System.out.println(word);
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                printAllWords(root.children[i],word+(char)(i+'a'));
            }
        }
    }
    
    public static String ans = "";

    public static void longestWordWithAllPrefix(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].endOfWord==true){
                char ch= (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestWordWithAllPrefix(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }

        }
    }
    public static void main(String[] args) {
        String words[]={ "apple", "app","ap", "appl", "apples","a" };
        for(String word:words){
            insert(word);
        }
        //printAllWords(trie,"");
        StringBuilder temp = new StringBuilder("");
        longestWordWithAllPrefix(trie, temp);
        System.out.println(ans);
    }
}
