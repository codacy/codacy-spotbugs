# [NullPointerException caught](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DCN_NULLPOINTER_EXCEPTION)

According to SEI Cert rule [ERR08-J](https://wiki.sei.cmu.edu/confluence/display/java/ERR08-J.+Do+not+catch+NullPointerException+or+any+of+its+ancestors) NullPointerException should not be caught. Handling NullPointerException is considered an inferior alternative to null-checking.

This non-compliant code catches a NullPointerException to see if an incoming parameter is null:

    boolean hasSpace(String m) {
      try {
        String ms[] = m.split(" ");
        return names.length != 1;
      } catch (NullPointerException e) {
        return false;
      }
    }

A compliant solution would use a null-check as in the following example:

    boolean hasSpace(String m) {
        if (m == null) return false;
        String ms[] = m.split(" ");
        return names.length != 1;
    }