# [Integer multiply of result of integer remainder](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IM_MULTIPLYING_RESULT_OF_IREM)

The code multiplies the result of an integer remaining by an integer constant.
Be sure you don't have your operator precedence confused. For example
i % 60 * 1000 is (i % 60) * 1000, not i % (60 * 1000).