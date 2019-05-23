# [Method attempts to access a result set field with index 0](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BRSA_BAD_RESULTSET_ACCESS)

 A call to getXXX or updateXXX methods of a result set was made where the
field index is 0\. As ResultSet fields start at index 1, this is always a mistake.