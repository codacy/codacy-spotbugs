# [Mass assignment](https://find-sec-bugs.github.io/bugs.htm#ENTITY_MASS_ASSIGNMENT)

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

    private Long role;
}

[...]
@Controller
class UserController {

    @PutMapping("/user/")
    @ResponseStatus(value = HttpStatus.OK)
    public void update(UserEntity user) {

        userService.save(user); //ALL fields from the user can be altered
    }

}
</pre>

    **General Guidelines:**  

*   Data transfer objects should be used instead including only the parameters needed as input/response to/from the API.
*   Sensitive parameters should be removed properly before transferring to UI.
*   Data should be persisted in database only after proper sanitisation checks.

    **Spring MVC Solution:**  

    In Spring specifically, you can apply the following solution to allow or disallow specific fields.  

With whitelist:  

<pre>
@Controller
class UserController {

   @InitBinder
   public void initBinder(WebDataBinder binder, WebRequest request)
   {
      binder.setAllowedFields(["username","password"]);
   }

}
    </pre>

With a blacklist:  

<pre>
@Controller
class UserController {

   @InitBinder
   public void initBinder(WebDataBinder binder, WebRequest request)
   {
      binder.setDisallowedFields(["role"]);
   }

}
    </pre>

**References**  

[OWASP Cheat Sheet: Mass Assignment](https://cheatsheetseries.owasp.org/cheatsheets/Mass_Assignment_Cheat_Sheet.html#spring-mvc)  

[CWE-915: Improperly Controlled Modification of Dynamically-Determined Object Attributes](https://cwe.mitre.org/data/definitions/915.html)