# [close() invoked on a value that is always null](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_CLOSING_NULL)

 close() is being invoked on a value that is always null. If this statement is executed,
a null pointer exception will occur. But the big risk here you never close
something that should be closed.