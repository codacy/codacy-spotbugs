# [Self assignment of local variable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SA_LOCAL_SELF_ASSIGNMENT)

 This method contains a self assignment of a local variable; e.g.

    public void foo() {
        int x = 3;
        x = x;
    }

Such assignments are useless, and may indicate a logic error or typo.