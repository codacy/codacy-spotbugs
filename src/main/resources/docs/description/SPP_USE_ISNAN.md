# [Method incorrectly compares a floating point number to NaN](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_ISNAN)

This method compares a double or float to the constant `Double.NaN` or `Float.NaN`.
			You should use
			`Double.isNaN(d)` or `Float.isNaN(f)`
			 if the variable is a primitive. If using a boxed primitive `d.isNaN()` or `f.isNaN()` should be used.