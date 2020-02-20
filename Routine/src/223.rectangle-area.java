/*
 * @lc app=leetcode id=223 lang=java
 *
 * [223] Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 */

// @lc code=start
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
//        24+27-6
        int up1 = Math.max(B,D);
        int up2 = Math.max(F,H);
        int down1 = Math.min(B,D);
        int down2 = Math.min(F,H);
        int right1 = Math.max(A,C);
        int right2 = Math.max(E,G);
        int left1 = Math.min(A,C);
        int left2 = Math.min(E,G);
        int a1 = (up1-down1)*(right1-left1);
        int a2 = (up2-down2)*(right2-left2);
        if (a1==0||a2==0){
            return a1+a2;
        }
        int all = a1+a2;
        int a = 0;
        int left = Math.max(left1, left2);
        int right = Math.min(right1, right2);
        int up = Math.min(up1, up2);
        int down = Math.max(down1, down2);

        if (left<right&&down<up){
            a = (right-left)*(up-down);
        }
        return all-a;
    }
}
// @lc code=end

