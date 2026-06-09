package collections.Arrays.BinarySearch;

public class Solutions {
    public int ArrangingCoins(int n){
        //Binary search on answer space
        //
        int l=0,r=n,ans=-1;
        while(l<=r){
            int mid= l+(r-l)/2;
            if(valid(mid,n)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    public boolean valid(int m,int n){
        return (long) m*(m+1)/2 <=n;
    }
}
