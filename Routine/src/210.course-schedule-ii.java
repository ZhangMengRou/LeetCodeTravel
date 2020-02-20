import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 * 207变形 不多说了，left,right对换
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] map = new int[numCourses][numCourses];
        int[] deep = new int[numCourses];
        for (int i = 0;i<prerequisites.length;i++){
            int left = prerequisites[i][1];
            int right = prerequisites[i][0];
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
        int[] ans = new int[numCourses];
        int count = 0;
        while(queue.size()>0){
            int start = (int) queue.poll();
            ans[count] = start;
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
    if (count ==numCourses){
        return ans;
    }
    return new int[0];   
    
    }
}
// @lc code=end

