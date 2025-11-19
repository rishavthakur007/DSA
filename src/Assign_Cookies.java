import java.util.Arrays;

public class Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        Arrays.sort(s);
        Arrays.sort(g);

        int ans = 0;
        int i =0;
        int j =0;
        while(i<n && j<m){
            if(g[i]<=s[j]){
                ans++;
                i++;
                j++;
            }else if(g[i]>s[j]){
                j++;
            }

        }
        return ans;
    }
}
