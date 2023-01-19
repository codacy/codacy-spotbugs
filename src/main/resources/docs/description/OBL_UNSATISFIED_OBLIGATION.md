# [Method may fail to clean up stream or resource](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#OBL_UNSATISFIED_OBLIGATION)

          This method may fail to clean up (close, dispose of) a stream,
          database object, or other
          resource requiring an explicit cleanup operation.

          In general, if a method opens a stream or other resource,
          the method should use a try/finally block to ensure that
          the stream or resource is cleaned up before the method
          returns.

          This bug pattern is essentially the same as the
          OS_OPEN_STREAM and ODR_OPEN_DATABASE_RESOURCE
          bug patterns, but is based on a different
          (and hopefully better) static analysis technique.
          We are interested is getting feedback about the
          usefulness of this bug pattern.
          For sending feedback, check:

*   [contributing guideline](https://github.com/spotbugs/spotbugs/blob/master/.github/CONTRIBUTING.md)
*   [mailinglist](https://github.com/spotbugs/discuss/issues?q=)

          In particular,
          the false-positive suppression heuristics for this
          bug pattern have not been extensively tuned, so
          reports about false positives are helpful to us.

          See Weimer and Necula, _Finding and Preventing Run-Time Error Handling Mistakes_
          ([PDF](https://people.eecs.berkeley.edu/~necula/Papers/rte_oopsla04.pdf)),
          for a description of the analysis technique.