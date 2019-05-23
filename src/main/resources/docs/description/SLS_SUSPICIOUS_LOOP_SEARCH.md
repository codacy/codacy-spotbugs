# [This method continues a loop after finding an equality condition](http://fb-contrib.sourceforge.net/bugdescriptions.html#SLS_SUSPICIOUS_LOOP_SEARCH)

This method continues with a loop, and does not break out of it, after finding and setting a variable in an
    		`if` condition based on equality. Since continuing on in the loop would seem to be unlikely to find the item again,
    		breaking at this point would seem to be the proper action.

Example:

    int age = 0;
    for (Person p : people) {
        if (p.getName().equals("Dave")) {
            age = p.getAge();
        }
    }

    		It is likely you wanted a break after getting the age for "Dave".