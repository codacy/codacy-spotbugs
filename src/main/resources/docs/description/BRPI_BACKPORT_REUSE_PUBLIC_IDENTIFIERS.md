# [Method uses backported libraries that are now built in](http://fb-contrib.sourceforge.net/bugdescriptions.html#BRPI_BACKPORT_REUSE_PUBLIC_IDENTIFIERS)

This class uses either Backport Utils concurrent classes from Emory, or Time classes from ThreeTen Backport.
			Updated/efficient versions of these classes are available in the version of the JDK that this code is compiled against -
			JDK 1.5 for the concurrent classes, and JDK 1.8 for the time classes - and these
			classes should only be used if you are targeting a JDK lower than this.