# [Found Spring endpoint](https://find-sec-bugs.github.io/bugs.htm#SPRING_ENDPOINT)

This class is a Spring Controller. All methods annotated with `RequestMapping` (as well as its shortcut annotations `GetMapping`, `PostMapping`, `PutMapping`, `DeleteMapping`, and `PatchMapping`) are reachable remotely.
This class should be analyzed to make sure that remotely exposed methods are safe to expose to potential attackers.