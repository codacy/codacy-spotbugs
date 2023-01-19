# [Potential security check based on untrusted source.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USC_POTENTIAL_SECURITY_CHECK_BASED_ON_UNTRUSTED_SOURCE)

      A public method of a public class may be called from outside the package which means that untrusted
      data may be passed to it. Calling a method before the doPrivileged to check its return value and then
      calling the same method inside the class is dangerous if the method or its enclosing class is not
      final. An attacker may pass an instance of a malicious descendant of the class instead of an instance
      of the expected one where this method is overridden in a way that it returns different values upon
      different invocations. For example, a method returning a file path may return a harmless path to check
      before entering the doPrivileged block and then a sensitive file upon the call inside the doPrivileged
      block. To avoid such scenario defensively copy the object received in the parameter, e.g. by using
      the copy constructor of the class used as the type of the formal parameter. This ensures that the
      method behaves exactly as expected.

      See SEI CERT rule [SEC02-J. Do not base security checks on untrusted sources](https://wiki.sei.cmu.edu/confluence/display/java/SEC02-J.+Do+not+base+security+checks+on+untrusted+sources).