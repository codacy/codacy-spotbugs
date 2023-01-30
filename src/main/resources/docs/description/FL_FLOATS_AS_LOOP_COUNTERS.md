# [Do not use floating-point variables as loop counters](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FL_FLOATS_AS_LOOP_COUNTERS)

Using floating-point variables should not be used as loop counters, as they are not precise, which may result in incorrect loops. A loop counter is a variable that is changed with each iteration and controls when the loop should terminate. It is decreased or increased by a fixed amount each iteration.

See rule [NUM09-J](https://wiki.sei.cmu.edu/confluence/display/java/NUM09-J.+Do+not+use+floating-point+variables+as+loop+counters).