# [Invokes run on a thread (did you mean to start it instead?)](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RU_INVOKE_RUN)

 This method explicitly invokes `run()` on an object. 
  In general, classes implement the `Runnable` interface because
  they are going to have their `run()` method invoked in a new thread,
  in which case `Thread.start()` is the right method to call.

See [CWE-572: Call to Thread run() instead of start()](https://cwe.mitre.org/data/definitions/572.html).