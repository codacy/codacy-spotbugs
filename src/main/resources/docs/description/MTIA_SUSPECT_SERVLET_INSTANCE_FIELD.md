# [Class extends Servlet class and uses instance variables](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MTIA_SUSPECT_SERVLET_INSTANCE_FIELD)

    This class extends from a Servlet class, and uses an instance member variable. Since only
    one instance of a Servlet class is created by the J2EE framework, and used in a
    multithreaded way, this paradigm is highly discouraged and most likely problematic. Consider
    only using method local variables.