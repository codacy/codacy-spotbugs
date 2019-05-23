# [instanceof will always return false](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_IMPOSSIBLE_INSTANCEOF)

This instanceof test will always return false. Although this is safe, make sure it isn't
an indication of some misunderstanding or some other logic error.