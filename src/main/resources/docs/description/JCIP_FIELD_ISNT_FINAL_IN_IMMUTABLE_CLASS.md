# [Fields of immutable classes should be final](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#JCIP_FIELD_ISNT_FINAL_IN_IMMUTABLE_CLASS)

 The class is annotated with net.jcip.annotations.Immutable or javax.annotation.concurrent.Immutable,
  and the rules for those annotations require that all fields are final.

See [CWE-471: Modification of Assumed-Immutable Data (MAID)](https://cwe.mitre.org/data/definitions/471.html).