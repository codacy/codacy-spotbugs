# [Dubious catching of IllegalMonitorStateException](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IMSE_DONT_CATCH_IMSE)

IllegalMonitorStateException is generally only
   thrown in case of a design flaw in your code (calling wait or
   notify on an object you do not hold a lock on).