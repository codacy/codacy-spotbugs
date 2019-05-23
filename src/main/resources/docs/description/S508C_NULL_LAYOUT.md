# [GUI uses absolute layout](http://fb-contrib.sourceforge.net/bugdescriptions.html#S508C_NULL_LAYOUT)

This class passes null to `setLayout`, which specifies that components are
			to be laid out using absolute coordinates. This makes making changes for
			font sizes, etc, difficult as items will not reposition.