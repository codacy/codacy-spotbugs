# [Usage of GetResource may be unsafe if class is extended](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UI_INHERITANCE_UNSAFE_GETRESOURCE)

Calling `this.getClass().getResource(...)` could give
results other than expected if this class is extended by a class in
another package.