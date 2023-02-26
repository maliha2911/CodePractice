package OOPs;

public class Arithmetic {
    public  double var = 5;
}
class DeepArith extends Arithmetic
{
    public  double var = 10;
}
class AdvancedArith extends DeepArith
{
    public  double var = 20;

}
class Test{
    public static void main(String[] num)
    {
        DeepArith arith = new AdvancedArith();
        System.out.print(arith.var);
    }
}