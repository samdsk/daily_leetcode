/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {
    private class TrieNode {
    
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
    
        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char c){
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c){
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node){
            links[c-'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }
    
    private TrieNode root;

    public Trie() {
       root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }

            node = node.get(currentChar);
        }
        node.setEnd();
    }
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else return null;
        }

        return node;
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();

    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}