# [Data read is converted before comparison to -1](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EOS_BAD_END_OF_STREAM_CHECK)

      The method java.io.FileInputStream.read() returns an int. If this int is converted to a byte then -1 (which
      indicates an EOF) and the byte 0xFF become indistinguishable, this comparing the (converted) result to -1
      causes the read (probably in a loop) to end prematurely if the character 0xFF is met. Similarly, the method
      java.io.FileReader.read() also returns an int. If it is converted to a char then -1 becomes 0xFFFF which is
      Character.MAX_VALUE. Comparing the result to -1 is pointless, since characters are unsigned in Java. If the
      checking for EOF is the condition of a loop then this loop is infinite.

      See SEI CERT rule [FIO08-J. Distinguish between characters or bytes read from a stream and -1](https://wiki.sei.cmu.edu/confluence/display/java/FIO08-J.+Distinguish+between+characters+or+bytes+read+from+a+stream+and+-1).