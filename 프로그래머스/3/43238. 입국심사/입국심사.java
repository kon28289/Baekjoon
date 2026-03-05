class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 1;
        long end = 1000000000L * n;
        long mid = start + (end - start) / 2;
        
        while(start <= end){
            long totalPerson = 0;
            for(int i = 0; i < times.length; i++){
                totalPerson += mid / times[i];
            }
            if(totalPerson >= n){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        
        return start;
    }
}