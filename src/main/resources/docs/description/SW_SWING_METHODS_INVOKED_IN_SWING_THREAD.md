# [Certain swing methods need to be invoked in Swing thread](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SW_SWING_METHODS_INVOKED_IN_SWING_THREAD)

([From JDC Tech Tip](http://web.archive.org/web/20090526170426/http://java.sun.com/developer/JDCTechTips/2003/tt1208.html)): The Swing methods
show(), setVisible(), and pack() will create the associated peer for the frame.
With the creation of the peer, the system creates the event dispatch thread.
This makes things problematic because the event dispatch thread could be notifying
listeners while pack and validate are still processing. This situation could result in
two threads going through the Swing component-based GUI -- it's a serious flaw that
could result in deadlocks or other related threading issues. A pack call causes
components to be realized. As they are being realized (that is, not necessarily
visible), they could trigger listener notification on the event dispatch thread.