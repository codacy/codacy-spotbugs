# [Nonconstant string passed to execute or addBatch method on an SQL statement](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SQL_NONCONSTANT_STRING_PASSED_TO_EXECUTE)

The method invokes the execute or addBatch method on an SQL statement with a String that seems
to be dynamically generated. Consider using
a prepared statement instead. It is more efficient and less vulnerable to
SQL injection attacks.

See [CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html).