# [instanceof will always return true](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_VACUOUS_INSTANCEOF)

This instanceof test will always return true (unless the value being tested is null).
Although this is safe, make sure it isn't
an indication of some misunderstanding or some other logic error.
If you really want to test the value for being null, perhaps it would be clearer to do
better to do a null test rather than an instanceof test.