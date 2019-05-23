# [Double assignment of local variable ](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SA_LOCAL_DOUBLE_ASSIGNMENT)

 This method contains a double assignment of a local variable; e.g.

    public void foo() {
        int x,y;
        x = x = 17;
    }

Assigning the same value to a variable twice is useless, and may indicate a logic error or typo.