# [Method passes constant String of length 1 to character overridden method](http://fb-contrib.sourceforge.net/bugdescriptions.html#UCPM_USE_CHARACTER_PARAMETERIZED_METHOD)

This method passes a constant literal `String` of length 1 as a parameter to a method, when
			a similar method is exposed that takes a `char`. It is simpler and more expedient to handle one
			character, rather than a `String`.

			Instead of making calls like:   

    String myString = ...
    if (myString.indexOf("e") != -1) {
        int i = myString.lastIndexOf("e");
        System.out.println(myString + ":" + i);  //the Java compiler will use a StringBuilder internally here [builder.append(":")]
        ...
        return myString.replace("m","z");
    }

			Replace the single letter `String`s with their `char` equivalents like so:  

    String myString = ...
    if (myString.indexOf('e') != -1) {
        int i = myString.lastIndexOf('e');
        System.out.println(myString + ':' + i);  //the Java compiler will use a StringBuilder internally here [builder.append(':')]
        ...
        return myString.replace('m','z');
    }