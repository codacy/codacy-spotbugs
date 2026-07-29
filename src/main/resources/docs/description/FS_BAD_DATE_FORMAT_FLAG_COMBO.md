# [Date-format strings may lead to unexpected behavior](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FS_BAD_DATE_FORMAT_FLAG_COMBO)

      This format string includes a bad combination of flags which may lead to unexpected behavior.
      Potential bad combinations include the following:

*   using a week year ("Y") with month in year ("M") and day in month ("d") without
              specifying week in year ("w"). Flag ("y") may be preferable here instead

*   using an AM/PM hour ("h" or "K") without specifying an AM/PM marker ("a") or
              period of day marker ("B")

*   using a 24-hour format hour ("H" or "k") with specifying AM/PM or period of day markers

*   using a milli of day ("A") together with hours ("H", "h", "K", "k") and/or
              minutes ("m") and/or seconds ("s")

*   use of milli of day ("A") and nano of day ("N") together
*   use of fraction of second ("S") nano of second together ("n")
*   use of AM/PM markers ("a") and period of day ("B") together
*   use of year ("y") and year of era ("u") together