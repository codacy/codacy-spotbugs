# [Method buries logic to the right (indented) more than it needs to be](http://fb-contrib.sourceforge.net/bugdescriptions.html#BL_BURYING_LOGIC)

Looks for relatively large `if` blocks of code, where you unconditionally return from them,
    		and then follow that with an unconditional return of a small block. This places the bulk of the logic to the right indentation-wise,
    		making it more difficult to read than needed. It would be better to invert the logic of the if block, and immediately return,
    		allowing the bulk of the logic to be move to the left for easier reading.