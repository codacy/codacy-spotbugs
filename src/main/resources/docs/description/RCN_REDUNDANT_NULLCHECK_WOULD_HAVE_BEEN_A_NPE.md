# [Nullcheck of value previously dereferenced](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE)

 A value is checked here to see whether it is null, but this value cannot
be null because it was previously dereferenced and if it were null a null pointer
exception would have occurred at the earlier dereference.
Essentially, this code and the previous dereference
disagree as to whether this value is allowed to be null. Either the check is redundant
or the previous dereference is erroneous.