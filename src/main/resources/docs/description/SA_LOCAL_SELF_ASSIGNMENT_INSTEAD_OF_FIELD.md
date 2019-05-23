# [Self assignment of local rather than assignment to field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SA_LOCAL_SELF_ASSIGNMENT_INSTEAD_OF_FIELD)

 This method contains a self assignment of a local variable, and there
is a field with an identical name.
assignment appears to have been ; e.g.

    int foo;
        public void setFoo(int foo) {
            foo = foo;
        }

The assignment is useless. Did you mean to assign to the field instead?