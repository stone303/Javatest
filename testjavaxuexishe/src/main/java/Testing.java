import java.util.Scanner;

public class Testing {

    public int testSum(int[] x)
    {
        int testsum=0;

        for(int i=0;i <x.length;i++)
        {
            if((x[i]%10 != 7)&&(x[i]/10%10 != 7))
            {
                testsum +=x[i];
            }
        }
        return testsum;
    }

    public int rabbit_Sum(int x)
    {
        int[] rsum =new int[20];
        rsum[0]=1;
        rsum[1]=1;

        for (int i = 2; i < rsum.length; i++) {
            rsum[i]=rsum[i-2]+rsum[i-1];
        }

        return rsum[x];
    }

    public int[] testSC()
    {
        int[] arr=new int[6];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+i+"评委的分数:");
            arr[i]=sc.nextInt();
        }

        return arr;
    }

    public Comparable<Integer> avgSC(int[] x)
    {
        int max=x[0];
        int min=x[0];
        int deSC=0;
        int count=0;

        for (int i = 0; i < x.length; i++) {
            if(x[i]>max)
            {
                max=x[i];
            }
            if (x[i]<min)
            {
                min=x[i];
            }

        }

        for (int i = 0; i <x.length ; i++) {

           /* if((x[i]!=min)&&(x[i]!=max)) {
                deSC += x[i];
            }
            else
            {
                count++;
            }*/
            deSC += x[i];
        }



       // return deSC/(x.length-count);

        if (x.length-2 !=0)
        {
            return  (deSC-min-max)/x.length-2;
        }

        return  null;
    }

}
