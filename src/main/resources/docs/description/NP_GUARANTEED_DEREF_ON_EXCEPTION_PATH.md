# [Value is null and guaranteed to be dereferenced on exception path](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_GUARANTEED_DEREF_ON_EXCEPTION_PATH)

              There is a statement or branch on an exception path
                that if executed guarantees that
              a value is null at this point, and that
              value that is guaranteed to be dereferenced
              (except on forward paths involving runtime exceptions).