# [Reliance on default encoding](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_DEFAULT_ENCODING)

 Found a call to a method which will perform a byte to String (or String to byte) conversion,
and will assume that the default platform encoding is suitable. This will cause the application
behavior to vary between platforms. Use an alternative API and specify a charset name or Charset
object explicitly.