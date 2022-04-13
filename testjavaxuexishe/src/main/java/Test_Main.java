public class Test_Main {
    public static void main(String[] args) {
        int test []={68,27,95,88,171,996,51,210};
        int test1 []={1,2,3,4,5,6,7,71};
        Testing testing=new Testing();
        int sum= testing.testSum(test);
        int sum1= testing.testSum(test1);

        System.out.println(sum);
        System.out.println(sum1);

        System.out.println( testing.rabbit_Sum(19));

        System.out.println( testing.avgSC(testing.testSC()));

    }
}
