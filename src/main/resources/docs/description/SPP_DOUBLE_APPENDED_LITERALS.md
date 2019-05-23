# [Method appends two literal strings back to back to a StringBuilder](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_DOUBLE_APPENDED_LITERALS)

This method appends two literal strings to a `StringBuilder` back to back.
			Modern compilers will optimize something like:  

    public static final string CONST_VAL = "there";
    ...
    String str = "Hello" + " "+ CONST_VAL + " " +"world!";

			to:   

    public static final string CONST_VAL = "there";
    ...
    String str = "Hello there world!";

			This means the concatenation is done during compile time, not at runtime, so there's **no need** to do:   

    public static final string CONST_VAL = "there";
    ...
    StringBuilder sb = new StringBuilder("Hello").append(" ").append(CONST_VAL).append(" ").append("world!");
    String str = sb.toString();

			which is harder to read and will result in more complex bytecode.

			Simply append your constants with the "+" symbol, don't append them with `StringBuilder.append()`.