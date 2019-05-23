# [Method calls deprecated SecureRandom method](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_SECURERANDOM)

In JDK 1.5 or less, the `SecureRandom()` constructors and `SecureRandom.getSeed()` method are recommended against using.
			Call `SecureRandom.getInstance()` and `SecureRandom.getInstance().generateSeed()` instead.