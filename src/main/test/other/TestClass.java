package other;

/**
 * @author FaceFeel
 * @Created 2018-01-19 23:05
 */

public class TestClass {

    public static void main(String[] args) {
        System.err.println(new B().getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);
        }

        public int getValue() {
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.err.println(value);
            }
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    static class B extends A {

        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
