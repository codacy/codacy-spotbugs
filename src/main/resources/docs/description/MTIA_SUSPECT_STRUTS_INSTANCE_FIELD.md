# [Class extends Struts Action class and uses instance variables](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MTIA_SUSPECT_STRUTS_INSTANCE_FIELD)

    This class extends from a Struts Action class, and uses an instance member variable. Since only
    one instance of a struts Action class is created by the Struts framework, and used in a
    multithreaded way, this paradigm is highly discouraged and most likely problematic. Consider
    only using method local variables. Only instance fields that are written outside of a monitor
    are reported.