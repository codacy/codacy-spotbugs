# [Uninitialized read of field method called from constructor of superclass](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UR_UNINIT_READ_CALLED_FROM_SUPER_CONSTRUCTOR)

 This method is invoked in the constructor of the superclass. At this point,
    the fields of the class have not yet initialized.

To make this more concrete, consider the following classes:

    abstract class A {
        int hashCode;
        abstract Object getValue();

        A() {
            hashCode = getValue().hashCode();
        }
    }

    class B extends A {
        Object value;

        B(Object v) {
            this.value = v;
        }

        Object getValue() {
            return value;
        }
    }

When a `B` is constructed,
the constructor for the `A` class is invoked
_before_ the constructor for `B` sets `value`.
Thus, when the constructor for `A` invokes `getValue`,
an uninitialized value is read for `value`.