# [Class is final but declares protected field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CI_CONFUSED_INHERITANCE)

      This class is declared to be final, but declares fields to be protected. Since the class
      is final, it cannot be derived from, and the use of protected is confusing. The access
      modifier for the field should be changed to private or public to represent the true
      use for the field.