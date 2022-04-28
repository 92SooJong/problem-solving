class LRUCache {
    
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int cap;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)) return -1;
        int value = map.get(key);
        map.remove(key);
        map.put(key,value);

        return value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            
        } else if(map.size() == cap){
            int removeKey=0;
            for (Integer integer : map.keySet()) {
                    removeKey =integer;
                    break;
            }
            map.remove(removeKey);
        }
        
        map.put(key,value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
