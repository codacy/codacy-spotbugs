# [Doomed attempt to append to an object output stream](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IO_APPENDING_TO_OBJECT_OUTPUT_STREAM)

     This code opens a file in append mode and then wraps the result in an object output stream like as follows:

    OutputStream out = new FileOutputStream(anyFile, true);
         new ObjectOutputStream(out);

     This won't allow you to append to an existing object output stream stored in a file. If you want to be
     able to append to an object output stream, you need to keep the object output stream open.

The only situation in which opening a file in append mode and the writing an object output stream
      could work is if on reading the file you plan to open it in random access mode and seek to the byte offset
      where the append started.