# [Method spins on field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SP_SPIN_ON_FIELD)

 This method spins in a loop which reads a field.  The compiler
  may legally hoist the read out of the loop, turning the code into an
  infinite loop.  The class should be changed so it uses proper
  synchronization (including wait and notify calls).