/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class WordDictionary {
    private class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null)
                node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.item = word;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(),0,root);
    }

    private boolean match(char[] arr,int k, TrieNode node){
        if(k==arr.length) return !node.item.equals("");
        if(arr[k]!='.'){
            return node.children[arr[k]-'a'] != null && match(arr,k+1,node.children[arr[k]-'a']);
        }else{
            for(int i=0;i<node.children.length;i++){
                if(node.children[i]!= null){
                    if(match(arr,k+1,node.children[i]))
                        return true;
                }
            }
        }
        return false;
    }
}

