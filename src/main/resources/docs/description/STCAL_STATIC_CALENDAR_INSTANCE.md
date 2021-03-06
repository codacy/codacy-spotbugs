# [Static Calendar field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#STCAL_STATIC_CALENDAR_INSTANCE)

Even though the JavaDoc does not contain a hint about it, Calendars are inherently unsafe for multithreaded use.
Sharing a single instance across thread boundaries without proper synchronization will result in erratic behavior of the
application. Under 1.4 problems seem to surface less often than under Java 5 where you will probably see
random ArrayIndexOutOfBoundsExceptions or IndexOutOfBoundsExceptions in sun.util.calendar.BaseCalendar.getCalendarDateFromFixedDate().

You may also experience serialization problems.

Using an instance field is recommended.

For more information on this see [JDK Bug #6231579](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6231579)
and [JDK Bug #6178997](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6178997).