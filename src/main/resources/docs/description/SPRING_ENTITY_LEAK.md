# [Spring Entity Leak](http://find-sec-bugs.github.io/bugs.htm#SPRING_ENTITY_LEAK)

    Persistent objects should never be returned/accepted by APIs. They might lead to leaking business logic over the UI, unauthorized tampering of
    persistent objects in database.

    **Persistence Annotations**  

    1\. javax.persistence.Entity (JPA)  

    2\. javax.jdo.spi.PersistenceCapable (JDO)  

    3\. org.springframework.data.mongodb.core.mapping.Document (Document database)  

    **Vulnerable Code:**  

<pre>@GetMapping("/sample/api")
    public SampleEntityClass sampleMethod(Principal principal) {
        Query query = getEntityManager().createQuery("select c from SampleTable c");
        SampleEntityClass entityObject = query.getResultList().get(0);
        return entityObject;
    }</pre>

<pre>@GetMapping("/sampletwo/api")
public void update(SampleEntityClass updateEntity) {
  ...
}
</pre>

    **Solution/Countermeasures:**  

*   Data transfer objects should be used instead including only the parameters needed as input/response to/from the API.
*   Sensitive parameters should be removed properly before transferring to UI.
*   Data should be persisted in database only after proper sanitisation checks.