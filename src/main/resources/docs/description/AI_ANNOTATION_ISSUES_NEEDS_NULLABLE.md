# [Method that can return null, is missing a @Nullable annotation](http://fb-contrib.sourceforge.net/bugdescriptions.html#AI_ANNOTATION_ISSUES_NEEDS_NULLABLE)

This method can return null, but is not annotated with an @Nullable annotation. Without this annotation,
    		various IDEs, and static analysis tools may not be able to fully discover possible NullPointerExceptions in
    		your code. By adding these annotations, you will discover problems around null-ness, more easily.

Unfortunately there isn't just one @Nullable annotation, but this detector will recognize:

*   org.jetbrains.annotations.Nullable
*   javax.annotation.Nullable
*   javax.annotation.CheckForNull
*   edu.umd.cs.findbugs.annotations.Nullable
*   org.springframework.lang.Nullable
*   android.support.annotations.Nullable

    		You can supply a comma separated list of classes that are custom Nullable Annotations if you desire, by using the
    		system property -Dfb-contrib.ai.annotations="com.acme.Foo,com.acme.Boo" when run.