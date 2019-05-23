# [Method assigns boolean literal in boolean expression](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#QBA_QUESTIONABLE_BOOLEAN_ASSIGNMENT)

      This method assigns a literal boolean value (true or false) to a boolean variable inside
      an if or while expression. Most probably this was supposed to be a boolean comparison using
      ==, not an assignment using =.