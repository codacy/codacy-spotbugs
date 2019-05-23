# [Method assigns a variable in a larger scope than is needed](http://fb-contrib.sourceforge.net/bugdescriptions.html#BAS_BLOATED_ASSIGNMENT_SCOPE)

_THIS DETECTOR IS HIGHLY EXPERIMENTAL AND IS LIKELY TO CREATE A LOT OF FUD_

This method assigns a value to a variable in an outer scope compared to where the variable is actually used.
			Assuming this evaluation does not have side effects, the assignment can be moved into the inner scope (if block)
			so that its execution time isn't taken up if the `if` guard is false. Care should be
			taken, however, that the right hand side of the assignment does not contain side
			effects that are required to happen, and that changes are not made further down that
			will affect the execution of the assignment when done later on.