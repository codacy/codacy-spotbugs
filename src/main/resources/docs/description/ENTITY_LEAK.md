# [Unexpected property leak](https://find-sec-bugs.github.io/bugs.htm#ENTITY_LEAK)

    Persistent objects should never be returned by APIs. They might lead to leaking business logic over the UI, unauthorized tampering of
    persistent objects in database.

    **Vulnerable Code:**  

<pre>
@javax.persistence.Entity
class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
}

[...]
@Controller
class UserController {

    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathVariable("id") String id) {

        return userService.findById(id).get(); //Return the user entity with ALL fields.
    }

}
</pre>

    **Solution/Countermeasures:**  

*   Data transfer objects should be used instead including only the parameters needed as input/response to/from the API.
*   Sensitive parameters should be removed properly before transferring to UI.
*   Data should be persisted in database only after proper sanitisation checks.

    **Spring MVC Solution:**  

    In Spring specifically, you can apply the following solution to allow or disallow specific fields.

<pre>
@Controller
class UserController {

   @InitBinder
   public void initBinder(WebDataBinder binder, WebRequest request)
   {
      binder.setAllowedFields(["username","firstname","lastname"]);
   }

}
    </pre>

**References**  

[OWASP Top 10-2017 A3: Sensitive Data Exposure](https://www.owasp.org/index.php/Top_10-2017_A3-Sensitive_Data_Exposure)  

[OWASP Cheat Sheet: Mass Assignment](https://cheatsheetseries.owasp.org/cheatsheets/Mass_Assignment_Cheat_Sheet.html#spring-mvc)  

[CWE-212: Improper Cross-boundary Removal of Sensitive Data](https://cwe.mitre.org/data/definitions/212.html)  

[CWE-213: Intentional Information Exposure](https://cwe.mitre.org/data/definitions/213.html)