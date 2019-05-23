# [Method attempts to access a prepared statement parameter with index 0](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SQL_BAD_PREPARED_STATEMENT_ACCESS)

 A call to a setXXX method of a prepared statement was made where the
parameter index is 0\. As parameter indexes start at index 1, this is always a mistake.