# [Bad Applet Constructor relies on uninitialized AppletStub](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BAC_BAD_APPLET_CONSTRUCTOR)

This constructor calls methods in the parent Applet that rely on the AppletStub. Since the AppletStub
isn't initialized until the init() method of this applet is called, these methods will not perform
correctly.