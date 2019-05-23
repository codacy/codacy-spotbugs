# [Method appears to pass character to StringBuffer or StringBuilder integer constructor](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_NO_CHAR_SB_CTOR)

This method constructs a StringBuffer or a StringBuilder using the constructor that takes an integer, but
			appears to pass a character instead. It is probable that the author assumed that the character would be appended to the
			StringBuffer/Builder, but instead the integer value of the character is used as an initial size for the buffer.