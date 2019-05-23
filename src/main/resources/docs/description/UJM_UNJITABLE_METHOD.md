# [This method is too long to be compiled by the JIT](http://fb-contrib.sourceforge.net/bugdescriptions.html#UJM_UNJITABLE_METHOD)

This method is longer than 8000 bytes. By default the JIT will not attempt to compile this method no matter
    		how hot it is, and so this method will always be interpreted. If performance is important, you should consider
    		breaking this method up into smaller chunks. (And it's probably a good idea for readability too!)