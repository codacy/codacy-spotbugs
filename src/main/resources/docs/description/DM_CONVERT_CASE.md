# [Consider using Locale parameterized version of invoked method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_CONVERT_CASE)

 A String is being converted to upper or lowercase, using the platform's default encoding. This may
      result in improper conversions when used with international characters. Use the 

*   String.toUpperCase( Locale l )
*   String.toLowerCase( Locale l )

versions instead.