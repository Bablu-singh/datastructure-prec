public class TrieNode {
    HashMap<Character, TrieNode> tree = new HashMap<>();
    boolean endOfWord = false;
}
class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        for(char c: word.toCharArray()){
            curr.tree.putIfAbsent(c,new TrieNode());
            curr = curr.tree.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {

        TrieNode curr = root;

        for(char c: word.toCharArray()){
            if(!curr.tree.containsKey(c)){
                return false;
            }
            curr = curr.tree.get(c);
        }
        return curr.endOfWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(!curr.tree.containsKey(c)){
                return false;
            }
            curr = curr.tree.get(c);
        }
        return true;
    }
}
