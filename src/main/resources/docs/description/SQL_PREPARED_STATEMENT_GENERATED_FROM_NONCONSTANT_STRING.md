# [A prepared statement is generated from a nonconstant String](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SQL_PREPARED_STATEMENT_GENERATED_FROM_NONCONSTANT_STRING)

The code creates an SQL prepared statement from a nonconstant String.
If unchecked, tainted data from a user is used in building this String, SQL injection could
be used to make the prepared statement do something unexpected and undesirable.