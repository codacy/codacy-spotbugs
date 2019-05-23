# [Method uses floating point indexed loops](http://fb-contrib.sourceforge.net/bugdescriptions.html#FPL_FLOATING_POINT_LOOPS)

This method uses floating point variables to index a loop. Since floating point
			math is imprecise, rounding errors will accumulate over time each time the loop is
			executed. It is usually better to use integer indexing, and calculate the new value
			of the floating point number at the top of the loop body.

Example:

    for (float f = 1.0f; f <= 10.0f; f += 0.1f) {
        System.out.println(f);
    }

			The last value printed may not be 10.0, but instead might be 9.900001 or such.