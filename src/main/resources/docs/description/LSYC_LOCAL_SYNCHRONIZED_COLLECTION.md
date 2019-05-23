# [Method creates local variable-based synchronized collection](http://fb-contrib.sourceforge.net/bugdescriptions.html#LSYC_LOCAL_SYNCHRONIZED_COLLECTION)

This method creates a synchronized collection and stores the reference to it
			in a local variable. As local variables are by definition thread-safe, it seems
			questionable that this collection needs to be synchronized.

<table> 
 <tbody> 
  <tr> 
   <th>If you are using</th> 
   <th>consider using</th> 
  </tr> 
  <tr> 
   <td>java.util.Vector</td> 
   <td>java.util.ArrayList</td> 
  </tr> 
  <tr> 
   <td>java.util.Hashtable</td> 
   <td>java.util.HashMap</td> 
  </tr> 
  <tr> 
   <td>java.lang.StringBuffer</td> 
   <td>java.lang.StringBuilder</td> 
  </tr> 
 </tbody> 
</table>