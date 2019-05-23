# [Method orders expressions in a conditional in a sub optimal way](http://fb-contrib.sourceforge.net/bugdescriptions.html#SEO_SUBOPTIMAL_EXPRESSION_ORDER)

This method builds a conditional expression, for example, in an `if` or `while` statement,
			where the expressions contain both simple local variable comparisons and comparisons on method calls.
			The expression orders these so that the method calls come before the simple local variable comparisons.
			This causes method calls to be executed in conditions when they do not need to be, and thus potentially causes a lot of code
			to be executed for nothing. By ordering the expressions so that the simple conditions containing local variable conditions are first,
			you eliminate this waste. This assumes that the method calls do not have side effects. If the methods do have side effects,
			it is probably a better idea to pull these calls out of the condition and execute them first, assigning a value to a local variable.
			In this way you give a hint that the call may have side effects.

Example:

    if ((calculateHaltingProbability() > 0) && shouldCalcHalting) { }

			would be better as

    if (shouldCalcHalting && (calculateHaltingProbability() > 0) { }