import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
// /a/./b/../../c/
/*
./ 当前目录 
../ 父级目录
*/
class Solution {
    public String simplifyPath(String path) {
       // System.out.println("f---");
        String[] f = path.split("/");
      //  String[] f = {""};
     //   System.out.println("f"+f.length);
        Stack s = new Stack<>();
    //    System.out.println("f"+f.length);
        for (int i = 0;i<f.length;i++){

            if (f[i].equals(".")||f[i].equals("")){
                continue;
            }
            System.out.println(s.size());
            if (f[i].equals("..")){
                if (!s.empty())
                {
                   s.pop();
                }
                continue;
            }
            // System.out.println("--"+f[i]+"--");
            s.add(f[i]);

        }
        StringBuffer stringBuffer = new StringBuffer();
        // System.out.println(s.size());
        while(!s.empty()){
            stringBuffer.insert(0, "/"+s.pop());

        }
        System.out.println(stringBuffer.length());
        if (stringBuffer.length()==0){
            stringBuffer.append("/");
        }
        return stringBuffer.toString();
        
    }
}

