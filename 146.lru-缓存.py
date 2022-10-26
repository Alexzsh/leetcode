#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU 缓存
#

# @lc code=start
class ListNode:
    
    def __init__(self,_key=0,_value=0):
        self.key=_key
        self.value=_value
        self.pre=None 
        self.next=None
class LRUCache:

        
    def __init__(self, capacity: int):
        self.capacity=capacity
        self.cache={}
        self.head=ListNode()
        self.tail=ListNode()
        self.head.next=self.tail 
        self.tail.pre=self.head
    def add_head(self,node):
        node.pre=self.head
        node.next=self.head.next
        self.head.next.pre=node
        self.head.next=node 
    def remove_node(self,node):
        node.pre.next=node.next
        node.next.pre=node.pre
    def remove_tail(self):
        tail = self.tail.pre 
        self.remove_node(tail)
        return tail 
    def move_head(self,node):
        self.remove_node(node)
        self.add_head(node)

        

        

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.move_head(node)
            return node.value
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.value=value 
            self.move_head(node)
        else:
            node = ListNode(key,value)
            self.cache[key]=node 
            self.add_head(node)
            if len(self.cache)>self.capacity:
                k = self.remove_tail().key
                self.cache.pop(k)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end


