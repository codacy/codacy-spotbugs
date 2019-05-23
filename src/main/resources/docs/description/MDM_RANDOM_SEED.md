# [Method creates insecure Random object](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_RANDOM_SEED)

`Random()` constructor without a seed is insecure because it defaults to an easily guessable seed:
			`System.currentTimeMillis()`. Initialize a seed like `new Random(SecureRandom.getInstance("SHA1PRNG").nextLong())`
			or replace `Random()` with `SecureRandom.getInstance("SHA1PRNG")` instead.
			"SHA1PRNG" is the random algorithm supported on all platforms.

				As of Java 6, you may use `new Random(new SecureRandom().nextLong())` or `new SecureRandom()` instead.