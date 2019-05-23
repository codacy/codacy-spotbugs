# [Double assignment of field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SA_FIELD_DOUBLE_ASSIGNMENT)

 This method contains a double assignment of a field; e.g.

    int x,y;
    public void foo() {
        x = x = 17;
    }

Assigning to a field twice is useless, and may indicate a logic error or typo.