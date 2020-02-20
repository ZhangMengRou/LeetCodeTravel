import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] map = new int[numCourses][numCourses];
        int[] deep = new int[numCourses];
        for (int i = 0;i<prerequisites.length;i++){
            int left = prerequisites[i][0];
            int right = prerequisites[i][1];
            if (map[left][right]==0){
                deep[right]++;
            }
            map[left][right] = 1;
            
        }
        Queue queue = new LinkedList<>();
        for (int i = 0;i<numCourses;i++){
            if (deep[i]==0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(queue.size()>0){
            int start = (int) queue.poll();
            count++;
            for (int i = 0;i<numCourses;i++){
             if (map[start][i]==1){
                 deep[i]--;
                 if (deep[i]==0){
                     queue.offer(i);
             }
            }

        }
    }

        return count ==numCourses;
        
    }
}
// @lc code=end
