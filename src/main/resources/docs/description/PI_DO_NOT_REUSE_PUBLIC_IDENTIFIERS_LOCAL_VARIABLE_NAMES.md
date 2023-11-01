# [Do not reuse public identifiers from JSL as method name](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_LOCAL_VARIABLE_NAMES)

      When declaring local variables in Java, it is crucial to refrain from reusing public identifiers from the Java Standard Library.
      Reusing these identifiers as local variable names can lead to confusion, hinder code comprehension, and potentially cause conflicts
      with existing publicly available identifier names from the Java Standard Library.
      To maintain code clarity and avoid such issues, it is best practice to select unique and descriptive names for your local variables.

      To provide an example, let's say you want to store a custom font value in a variable. Instead of using a common name like "Font" for the variable name,
      which conflicts with the existing java.awt.Font class, you could choose a more specific and unique name like or "customFont" or "loadedFontName".

      A few key points to keep in mind when choosing names as identifier:

*   Use descriptive names: Opt for descriptive variable names that clearly indicate their purpose and functionality. This helps avoid shadowing existing Java Standard Library identifiers. For instance, instead of "variable", consider using "myVariableName".
*   Follow naming conventions: Adhere to Java's naming conventions, such as using mixed case for variable names. Start with a lowercase first letter and the internal words should start with capital letters (e.g. myVariableName). This promotes code readability and reduces the chances of conflicts.

See SEI CERT rule [DCL01-J. Do not reuse public identifiers from the Java Standard Library](https://wiki.sei.cmu.edu/confluence/display/java/DCL01-J.+Do+not+reuse+public+identifiers+from+the+Java+Standard+Library).