class Solution {
    // tries node
    static class TrieNode{
        TrieNode[] Children = new TrieNode[26];
        boolean isTerminal = false;
    }

    // insertion 
    private void insertData(TrieNode root, String word){
        TrieNode node = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.Children[index] == null){
                node.Children[index] = new TrieNode();
            }
            node = node.Children[index];
        }
        node.isTerminal = true;
    }
    // serching
    private String findRoot(TrieNode root, String word){
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.Children[index] == null || node.isTerminal) break;
            prefix.append(ch);
            node = node.Children[index];
        }

        return node.isTerminal ? prefix.toString() : word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        
        TrieNode root = new TrieNode();

        for(String word : dictionary){
            insertData(root, word);
        }

        StringBuilder result = new StringBuilder();
        for(String word : sentence.split(" ")){
            if(result.length() > 0) result.append(" ");
            result.append(findRoot(root, word));
        }

        return result.toString();
    }
}