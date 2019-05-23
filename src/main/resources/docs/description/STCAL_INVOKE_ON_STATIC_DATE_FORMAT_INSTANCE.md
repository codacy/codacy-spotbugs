# [Call to static DateFormat](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#STCAL_INVOKE_ON_STATIC_DATE_FORMAT_INSTANCE)

As the JavaDoc states, DateFormats are inherently unsafe for multithreaded use.
The detector has found a call to an instance of DateFormat that has been obtained via a static
field. This looks suspicious.

For more information on this see [JDK Bug #6231579](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6231579)
and [JDK Bug #6178997](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6178997).