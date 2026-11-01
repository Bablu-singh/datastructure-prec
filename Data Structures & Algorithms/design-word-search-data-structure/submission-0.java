public class TrieNode {
    HashMap<Character, TrieNode> tree = new HashMap<>();
    boolean endOfWord = false;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode curr = root;

        for(char c: word.toCharArray()){
            curr.tree.putIfAbsent(c,new TrieNode());
            curr = curr.tree.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {

        return dfs(word,0,root);

    }
    private boolean dfs(String word, int j, TrieNode root){
        TrieNode curr = root;

        for(int i =j;i<word.length();i++){
            char c = word.charAt(i);

            if(c == '.'){
                for(char ca: curr.tree.keySet()){
                    TrieNode child = curr.tree.get(ca);

                    if(child!=null && dfs(word,i+1,child)){
                        return true;
                    }

                }
                return false;
            }else {
                if(!curr.tree.containsKey(c)){
                    return false;
                }
                curr = curr.tree.get(c);
            }

        }
        return curr.endOfWord;
    }
}
