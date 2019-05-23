# [Maps and sets of URLs can be performance hogs](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_COLLECTION_OF_URLS)

 This method or field is or uses a Map or Set of URLs. Since both the equals and hashCode
method of URL perform domain name resolution, this can result in a big performance hit.
See [http://michaelscharf.blogspot.com/2006/11/javaneturlequals-and-hashcode-make.html](http://michaelscharf.blogspot.com/2006/11/javaneturlequals-and-hashcode-make.html) for more information.
Consider using `java.net.URI` instead.