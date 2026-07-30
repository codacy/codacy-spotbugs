# [Do not use floating-point variables as loop counters](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FL_FLOATS_AS_LOOP_COUNTERS)

Using floating-point variables should not be used as loop counters, as they are not precise, which may result in incorrect loops. A loop counter is a variable that is changed with each iteration and controls when the loop should terminate. It is decreased or increased by a fixed amount each iteration.

See rule [NUM09-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/numeric-types-and-operations-num/num09-j/)
 and [CWE-1339: Insufficient Precision or Accuracy of a Real Number](https://cwe.mitre.org/data/definitions/1339.html).