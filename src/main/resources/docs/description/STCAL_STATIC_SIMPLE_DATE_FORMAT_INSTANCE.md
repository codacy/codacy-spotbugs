# [Static DateFormat](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#STCAL_STATIC_SIMPLE_DATE_FORMAT_INSTANCE)

As the JavaDoc states, DateFormats are inherently unsafe for multithreaded use.
Sharing a single instance across thread boundaries without proper synchronization will result in erratic behavior of the
application.

You may also experience serialization problems.

Using an instance field is recommended.

For more information on this see [JDK Bug #6231579](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6231579)
and [JDK Bug #6178997](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6178997).