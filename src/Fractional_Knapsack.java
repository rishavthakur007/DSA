import java.util.Arrays;

public class Fractional_Knapsack {
    public class Item{
        public int val;
        public int weight;

        Item(int val,int weight){
            this.val = val;
            this.weight = weight;
        }
        public double ratio(){
            return (double)val/weight;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here

        int n = val.length;
        int m = wt.length;

        Item[] items = new Item[n];
        for(int i=0;i<n;i++){
            items[i] = new Item(val[i],wt[i]);
        }
        Arrays.sort(items,(a,b)->Double.compare(b.ratio(),a.ratio()));

        double ans = 0;
        int remaining = capacity;

        for(Item item:items){
            int weight = item.weight;
            int value = item.val;
            if(remaining==0){
                break;
            }

            if(weight<=remaining){
                ans += value;
                remaining -= weight;
            }else{
                double fraction = (double) remaining/weight;
                ans += value*fraction;
                break;
            }

        }
        return ans;
    }
}
