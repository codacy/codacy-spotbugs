# [Method uses two date comparisons when one would do](http://fb-contrib.sourceforge.net/bugdescriptions.html#DDC_DOUBLE_DATE_COMPARISON)

This method compares dates with two comparisons, rather than using the reverse comparison.
			So this pattern

    if ((date1.equals( date2 )) || (date1.after( date2 )))

			could become:  

    if (date1.compareTo( date2 ) >= 0)

			and  

    if ((date1.equals( date2 )) || (date1.before( date2 )))

			could become   

    if (date1.compareTo( date2 ) <= 0)

			and  

    if ((date1.before( date2 )) || (date1.after( date2 )))

			could become  

    if (!date1.equals( date2 ))