# [Class does not implement a toString method](http://fb-contrib.sourceforge.net/bugdescriptions.html#IMC_IMMATURE_CLASS_NO_TOSTRING)

This class, which has instance fields, has no toString() method, which will make debugging with this
    		class more difficult than it could be. Consider adding a toString() method. Using libraries like commons-lang3
    		ToStringBuilder makes this process easy.