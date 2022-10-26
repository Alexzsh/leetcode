import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {

    class DeLinkNode{
        int key,value;
        DeLinkNode pre,next;
        public DeLinkNode(int _key,int _value){
            key=_key;
            value=_value;
        }
        public DeLinkNode(){};
    }

    DeLinkNode head,tail;
    int size,capacity;
    HashMap<Integer,DeLinkNode> cache = new HashMap<>();

    public LRUCache(int _capacity) {
        size=0;
        capacity=_capacity;
        head = new DeLinkNode();
        tail = new DeLinkNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        DeLinkNode node = cache.get(key);
        moveFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DeLinkNode node = cache.get(key);
            moveFirst(node);
            node.value=value;
        }
        else{
            DeLinkNode node = new DeLinkNode(key,value);
            cache.put(key, node);
            addFirst(node);
            size++;
            if(size>capacity){
                int keyTail = removeTail().key;
                cache.remove(keyTail);
                size--;
            }
        }
    }

    public void removeNode(DeLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public void addFirst(DeLinkNode node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    public void moveFirst(DeLinkNode node){
        removeNode(node);
        addFirst(node);
    }
    public DeLinkNode removeTail(){
        DeLinkNode last = tail.pre;
        removeNode(last);
        return last;
    }

    // hashMap + deLink
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

