class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n1= series1.length;
        int n2= series2.length;

        List<List<Integer>> res = new ArrayList<>();

        int i=0,j=0;
        while(i<n1 && j<n2){
            if(series1[i][0] == series2[j][0]){
                res.add(Arrays.asList(series1[i][0], series1[i][1]+series2[j][1]));
                i++;
                j++;
            }
            else if(series1[i][0] < series2[j][0]){
                res.add(Arrays.asList(series1[i][0], series1[i][1]+series2[j][1]));
                i++;
            }
            else{
                res.add(Arrays.asList(series2[j][0], series1[i][1]+series2[j][1]));
                j++;
            }
        }
        while(i < n1){
               res.add(Arrays.asList(series1[i][0],series1[i][1]));
            i++;
        }
        while(j < n2){
            res.add(Arrays.asList(series2[j][0],series2[j][1]));
            j++;
        }
        return res;
    }
}