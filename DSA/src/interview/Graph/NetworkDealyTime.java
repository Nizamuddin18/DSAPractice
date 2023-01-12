package interview.Graph;

public class NetworkDealyTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k-1] = 0;
        int edges = times.length;
        for(int v = 0 ; v < n ; v++){
            for(int e = 0 ; e < edges ; e++){
                int src = times[e][0] - 1 ;
                int dest = times[e][1] - 1;
                int weight = times[e][2];
                if(dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]){
                    dist[dest] = dist[src] + weight;
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < dist.length ; i++){
        	if(dist[i] == Integer.MAX_VALUE) return -1;
        	max = Math.max(max ,  dist[i]);
        }
        return max;
    }
    
	public static void main(String[] args) {
		System.out.println("Network Delay Time(Leetcode 743)");
		int [][] times = {{2,1,1},{2,3,1},{3,4,1}};
		int n = 4, k = 2;
		int max = networkDelayTime(times , n , k);
		System.out.println("Output : " + max);
	}

}
