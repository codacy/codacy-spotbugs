# [The equals and hashCode methods of URL are blocking](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_BLOCKING_METHODS_ON_URL)

 The equals and hashCode
method of URL perform domain name resolution, this can result in a big performance hit.
See [http://michaelscharf.blogspot.com/2006/11/javaneturlequals-and-hashcode-make.html](http://michaelscharf.blogspot.com/2006/11/javaneturlequals-and-hashcode-make.html) for more information.
Consider using `java.net.URI` instead.