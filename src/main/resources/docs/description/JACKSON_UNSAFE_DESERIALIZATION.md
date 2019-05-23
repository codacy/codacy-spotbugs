# [Unsafe Jackson deserialization configuration](http://find-sec-bugs.github.io/bugs.htm#JACKSON_UNSAFE_DESERIALIZATION)

When the Jackson databind library is used incorrectly the deserialization of untrusted data can lead to remote code execution, if there is a class in classpath that allows the trigger of malicious operation.

**Solutions:**  

Explicitly define what types and subtypes you want to be available when using polymorphism through JsonTypeInfo.Id.NAME.
Also, never call `ObjectMapper.enableDefaultTyping` (and then `readValue` a type that holds a Object or Serializable or Comparable or a known deserialization type).

**Code at risk:**  

<pre>
public class Example {
    static class ABean {
        public int id;
        public Object obj;
    }

    static class AnotherBean {
        @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS) // or JsonTypeInfo.Id.MINIMAL_CLASS
        public Object obj;
    }

    public void example(String json) throws JsonMappingException {
         ObjectMapper mapper = new ObjectMapper();
         mapper.enableDefaultTyping();
         mapper.readValue(json, ABean.class);
    }

    public void exampleTwo(String json) throws JsonMappingException {
         ObjectMapper mapper = new ObjectMapper();
         mapper.readValue(json, AnotherBean.class);
    }

}
</pre>

**References**  

[Jackson Deserializer security vulnerability](https://github.com/FasterXML/jackson-databind/issues/1599)  

[Java Unmarshaller Security - Turning your data into code execution](https://github.com/mbechler/marshalsec)