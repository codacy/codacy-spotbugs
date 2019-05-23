# [Method calls getProperties just to get one property, use getProperty instead](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_GETPROPERTY)

<table> 
 <tbody> 
  <tr> 
   <td>This method uses</td> 
  </tr> 
  <tr> 
   <td>String prop = System.getProperties().getProperty("foo");</td> 
  </tr> 
  <tr> 
   <td>instead of simply using</td> 
  </tr> 
  <tr> 
   <td>String prop = System.getProperty("foo");</td> 
  </tr> 
 </tbody> 
</table>