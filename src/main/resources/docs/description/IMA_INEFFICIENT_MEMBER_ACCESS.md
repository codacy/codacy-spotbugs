# [Method accesses a private member variable of owning class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IMA_INEFFICIENT_MEMBER_ACCESS)

      This method of an inner class reads from or writes to a private member variable of the owning class,
      or calls a private method of the owning class. The compiler must generate a special method to access this
      private member, causing this to be less efficient. Relaxing the protection of the member variable or method
      will allow the compiler to treat this as a normal access.