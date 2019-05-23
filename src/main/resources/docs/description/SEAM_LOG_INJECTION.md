 Seam Logging API support an expression language to introduce bean property to log messages. The expression language can also be the source to unwanted code execution.

In this context, an expression is built with a dynamic value. The source of the value(s) should be verified to avoid that unfiltered values fall into this risky code evaluation.

**Code at risk:**

```
public void logUser(User user) {
    log.info("Current logged in user : " + user.getUsername());
    //...
}
```

**Solution:**

```
public void logUser(User user) {
    log.info("Current logged in user : #0", user.getUsername());
    //...
}
```
  

**References**  
[JBSEAM-5130: Issue documenting the risk](https://issues.jboss.org/browse/JBSEAM-5130)  
[JBoss Seam: Logging (Official documentation)](https://docs.jboss.org/seam/2.3.1.Final/reference/html_single/#d0e4185)  
[The Java EE 6 Tutorial: Expression Language](https://docs.oracle.com/javaee/6/tutorial/doc/gjddd.html)  
[CWE-94: Improper Control of Generation of Code ('Code Injection')](http://cwe.mitre.org/data/definitions/94.html)  
[CWE-95: Improper Neutralization of Directives in Dynamically Evaluated Code ('Eval Injection')](http://cwe.mitre.org/data/definitions/95.html)

