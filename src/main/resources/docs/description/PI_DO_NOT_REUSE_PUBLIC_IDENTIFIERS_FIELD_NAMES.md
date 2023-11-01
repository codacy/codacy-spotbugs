# [Do not reuse public identifiers from JSL as field name](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_FIELD_NAMES)

      It is a good practice to avoid reusing public identifiers from the Java Standard Library as field names in your code.
      Doing so can lead to confusion and potential conflicts, making it harder to understand and maintain your codebase.
      Instead, it is recommended to choose unique and descriptive names for your fields that accurately represent their purpose and differentiate them from Standard Library identifiers.

      To provide an example, let's say you want to create a class for handling dates in your application. Instead of using a common name like "Date",
      which conflicts with the existing java.util.Date class, you could choose a more specific and unique name like or "AppDate" or "DisplayDate".

      For example, let's say you're creating a class to represent a car in your application. Instead of using a common name like "Component" as a field,
      which conflicts with the existing java.awt.Component class, you should opt for a more specific and distinct name, such as "VehiclePart" or "CarComponent".

      A few key points to keep in mind when choosing names as identifier:

*   Use descriptive names: Opt for descriptive field names that clearly indicate their purpose and functionality. This helps avoid shadowing existing Java Standard Library identifiers. For instance, instead of "list", consider using "myFancyList"
*   Follow naming conventions: Adhere to Java's naming conventions, such as using mixed case for field names. Start with a lowercase first letter and the internal words should start with capital letters (e.g., myFieldUsesMixedCase). This promotes code readability and reduces the chances of conflicts.

See SEI CERT rule [DCL01-J. Do not reuse public identifiers from the Java Standard Library](https://wiki.sei.cmu.edu/confluence/display/java/DCL01-J.+Do+not+reuse+public+identifiers+from+the+Java+Standard+Library).