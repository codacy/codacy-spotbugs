# [Write to static field from instance method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD)

 This instance method writes to a static field. This is tricky to get
correct if multiple instances are being manipulated,
and generally bad practice.