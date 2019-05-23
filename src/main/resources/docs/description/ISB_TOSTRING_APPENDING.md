# [Method concatenates the result of a toString() call](http://fb-contrib.sourceforge.net/bugdescriptions.html#ISB_TOSTRING_APPENDING)

This method concatenates the output of a `toString()` call into a `StringBuffer` or `StringBuilder`.
			It is simpler just to pass the object you want to append to the append call, as that form
			does not suffer the potential for `NullPointerException`s, and is easier to read.

			Keep in mind that Java compiles simple `String` concatenation to use `StringBuilder`s,
			so you may see this bug even when you don't use `StringBuilder`s explicitly.

			Instead of:   

    StringBuilder builder = ...;
    builder.append(someObj.toString());
    ...
    System.out.println("Problem with the object :" + someObj.toString());

just do:   

    StringBuilder builder = ...
    builder.append(someObj);
    ...
    System.out.println("Problem with the object :" + someObj);

			to avoid the possibility of `NullPointerException`s when someObj is `null`.