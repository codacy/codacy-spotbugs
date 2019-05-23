# [JLabel doesn't specify what it's labeling](http://fb-contrib.sourceforge.net/bugdescriptions.html#S508C_NO_SETLABELFOR)

This class uses JLabels that do not specify what fields are being labeled.
			This hampers screen readers from giving appropriate feedback to users. Use
			the JLabel.setLabelFor method to accomplish this.