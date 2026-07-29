# [Call to Unsafe.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UNS_UNSAFE_CALL)

Do not use either sun.misc.Unsafe or
      jdk.internal.misc.Unsafe. As there class name indicates, these
      methods are not safe to use. They have been superseded by
      official APIs like the VarHandle API (JDK 9) and the Foreign
      Function & Memory API (JDK 22). See
      [JEP 471](https://openjdk.org/jeps/471)
      for details on the safer alternatives including before and after
      code samples.