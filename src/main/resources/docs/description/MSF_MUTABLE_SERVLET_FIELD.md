# [Mutable servlet field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MSF_MUTABLE_SERVLET_FIELD)

A web server generally only creates one instance of servlet or JSP class (i.e., treats
the class as a Singleton),
and will
have multiple threads invoke methods on that instance to service multiple
simultaneous requests.
Thus, having a mutable instance field generally creates race conditions.