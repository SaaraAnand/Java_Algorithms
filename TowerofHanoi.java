public class TowerofHanoi {
    public static void main(String[] args){
        int n=3;
        towerofHanoi(n,'A','C','B');
    }
    public static void towerofHanoi(int n,char source,char destination,char auxiliary){
        if(n==1){
            System.out.println("Move disk1 from " + source + " to " +destination);
            return;
        }
        towerofHanoi(n-1,source,auxiliary,destination);
        System.out.println("Move disk" + n +" from "+source+" to "+destination);
        towerofHanoi(n-1,auxiliary,destination,source);
    }
    
}
