package misc;

/**
 * Created by Kumar_Garg on 6/24/2016.
 */
class B {
    private int b;

    B(int b) {
        this.b = b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return this.b;
    }
}

public class A {
    private final B obj;
    private final int arr[];

    A(int b) {
        obj = new B(b);
        arr = new int[5];
        for (int i = 0; i < 5; i++)
            arr[i] = i;

    }

    public static void main(String[] args) {
        A a = new A(5);

        System.out.println(a.obj.getB());
        a.arr[2] = 5;
        System.out.println(a.arr[2]);
    }
}
