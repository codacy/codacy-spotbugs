# [Method constructs a File object, merely to convert it to a Path object](http://fb-contrib.sourceforge.net/bugdescriptions.html#UAC_UNNECESSARY_API_CONVERSION_FILE_TO_PATH)

This method creates a java.nio.file.Path object by first creating a java.io.File object, and then calling
    		toPath() on it. It is simpler to just construct the Path object directly, say by using
    		{@code Paths.get(String...)}.