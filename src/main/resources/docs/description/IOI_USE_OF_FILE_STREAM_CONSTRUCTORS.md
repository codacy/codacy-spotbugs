# [Method uses a FileInputStream or FileOutputStream constructor](http://fb-contrib.sourceforge.net/bugdescriptions.html#IOI_USE_OF_FILE_STREAM_CONSTRUCTORS)

This method creates and uses a java.io.FileInputStream or java.io.FileOutputStream object. Unfortunately both
    		of these classes implement a finalize method, which means that objects created will likely hang around until a
    		full garbage collection occurs, which will leave excessive garbage on the heap for longer, and potentially much
    		longer than expected. Java 7 introduced two ways to create streams for reading and writing files that do not have this concern.
    		You should consider switching from these above classes to
    		`
    		InputStream is = java.nio.file.Files.newInputStream(myfile.toPath());
    		OutputStream os = java.nio.file.Files.newOutputStream(myfile.toPath());
    		`