package OOPs;

public class Car {
    static{
        System.out.print("1");
    }

    public Car(String name) {
        super();
        System.out.print("2");
    }

    static{
        System.out.print("3");
    }
}
class a extends Car{
    public a(String s){
        super(s);
    }
    public static void main (String [] args){
        new a("helo");
        new a("hello");
    }
}
