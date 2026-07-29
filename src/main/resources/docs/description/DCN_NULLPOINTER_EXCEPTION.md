# [NullPointerException caught](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DCN_NULLPOINTER_EXCEPTION)

According to SEI Cert rule [ERR08-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/exceptional-behavior-err/err08-j/) NullPointerException should not be caught. Handling NullPointerException is considered an inferior alternative to null-checking.

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

See [CWE-395: Use of NullPointerException Catch to Detect NULL Pointer Dereference](https://cwe.mitre.org/data/definitions/395.html).