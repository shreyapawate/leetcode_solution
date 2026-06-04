public class star_pattern{
    public static int factorial(int a){
       int fact=1;
       if(a==0 || a==1){
        return 1;
       }


       for(int i=1;i<=a;i++){
        return fact= fact*i;
       }
        
    }
    public static void main(String[] args){
        int a=4;
        int ans=factorial(a);
        System.out.print(ans);
       
    }
}