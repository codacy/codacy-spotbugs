# [Do not reuse public identifiers from JSL as class name](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_CLASS_NAMES)

      It's essential to avoid reusing public identifiers from the Java Standard Library as class names.
      This is because the Java Standard Library is a part of the Java platform and is expected to be available in all Java environments.
      Doing so can lead to naming conflicts and confusion, making it harder to understand and maintain the code.
      It's best practice to choose unique and descriptive class names that accurately represent the purpose and functionality of your own code.
      To provide an example, let's say you want to create a class for handling dates in your application. Instead of using a common name like "Date",
      which conflicts with the existing java.util.Date class, you could choose a more specific and unique name like or "AppDate" or "DisplayDate".

      A few key points to keep in mind when choosing names as identifier:

*   Use meaningful prefixes or namespaces: Prepend a project-specific prefix or namespace to your class names to make them distinct. For example, if your project is named "MyApp", you could use "MyAppDate" as your class name.
*   Use descriptive names: Opt for descriptive class names that clearly indicate their purpose and functionality. This helps avoid shadowing existing Java Standard Library identifiers. For instance, instead of "List", consider using "CustomAppList".
*   Follow naming conventions: Adhere to Java's naming conventions, such as using camel case (e.g., MyClass) for class names. This promotes code readability and reduces the chances of conflicts.

See SEI CERT rule [DCL01-J. Do not reuse public identifiers from the Java Standard Library](https://wiki.sei.cmu.edu/confluence/display/java/DCL01-J.+Do+not+reuse+public+identifiers+from+the+Java+Standard+Library).