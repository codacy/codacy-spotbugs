# [Empty synchronized block](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ESync_EMPTY_SYNC)

 The code contains an empty synchronized block:

    synchronized() {
    }

Empty synchronized blocks are far more subtle and hard to use correctly
than most people recognize, and empty synchronized blocks
are almost never a better solution
than less contrived solutions.