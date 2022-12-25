import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 내가 제출한 정담 코드
     */
    public boolean hasCycle(ListNode head) {

        Set<Integer> visited = new HashSet<>();
        ListNode currentNode = head;
        while(true) {

            if(currentNode == null || currentNode.next == null) return false;

            if(visited.contains(currentNode.hashCode())) return true;

            visited.add(currentNode.hashCode());
            currentNode = currentNode.next;
        }
    }

    /**
     * 시간복잡도 O(1) 짜리 답안
     * Floyd’s Cycle Finding Algorithm를 공부해볼 것
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode walker = head.next;
        ListNode cheater = head;
        while(true) {
            if (walker == null) return false;
            if (walker.next == walker) return true;
            cheater.next = cheater;
            cheater = walker;
            walker = walker.next;
        }
    }

}
