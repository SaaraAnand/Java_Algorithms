public class celebrityy {
    int i,j,index;
    celebrity=0;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            if(arr[i][j]==0){
                count++;
            }else{
                break;
            }
        }
        if(count==2){
            celebrity++;
            index--;
        }
    }
    
}
