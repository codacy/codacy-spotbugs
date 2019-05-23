# [Method stacks similar try/catch blocks](http://fb-contrib.sourceforge.net/bugdescriptions.html#STB_STACKED_TRY_BLOCKS)

This method declares two try-catch blocks one after another, where each
			catch block catches the same type of exception. They also throw uniformly the
			same type of exception. These two catch blocks can be combined into one to
			simplify the method.