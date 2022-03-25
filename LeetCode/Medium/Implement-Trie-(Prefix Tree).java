class Trie {

    List<String> words = new ArrayList<>();

    public Trie() {
    }

    public void insert(String word) {
        words.add(word);
    }

    public boolean search(String word) {
        
        return (int) words.stream().filter(s -> s.equals(word)).count() > 0;
    }

    public boolean startsWith(String prefix) {

        return (int) words.stream().filter(s -> s.startsWith(prefix)).count() > 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
