class Trie {
    class TrieNode {
        Map<Character , TrieNode > children = new HashMap<>();
        boolean isEnd = false ;
    }
    private TrieNode root ;
    public Trie() {
        root = new TrieNode() ;
        
    }
    
    public void insert(String word) {
        TrieNode node = root ;
        for(char ch : word . toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch) ;
        }
        node.isEnd = true ;
        
    }
    
    public boolean search(String word) {
        TrieNode node = getNode(word) ;
        return node != null && node.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null ;
        
    }

    private TrieNode getNode(String word) {
        TrieNode node = root ;
        for(char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)) 
            return null;

            node =  node.children.get(ch) ;
        }
        return node ;
    }
}
