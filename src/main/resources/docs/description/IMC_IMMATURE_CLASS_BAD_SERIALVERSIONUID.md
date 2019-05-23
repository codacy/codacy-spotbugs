# [Class defines a computed serialVersionUID that doesn't equate to the calculated value](http://fb-contrib.sourceforge.net/bugdescriptions.html#IMC_IMMATURE_CLASS_BAD_SERIALVERSIONUID)

This serializable class defines a serialVersionUID that appears to be a computed value, however the value does not
    		match the computed value, and thus losses it's value as version indicator. Either create a custom value like 1, 2, 3, 4.. etc, or
    		recompute the serialVersionUID using your IDE.