## spring-boot-hibernate-bidirectional-many-to-many-join-table-relationship-mapping

1- Implement hibernate bidirectional many-to-many join-table relational mapping <br/>
2- ER diagram :  <br/>
NOT : Many Product related to many Store <br/>

![many_to_one_er_diagram](doc/store_products_er_diagram.png) <br/>


3- Start Spring Boot application with a specific profile such as "-Dspring.profiles.active=dev" . <br/>
4- swagger-ui can be accessed from URL : http://localhost:8080/customer-info/swagger-ui/ <br/><br/>

![swagger_ui](doc/store_products_swagger_ui.png) <br/>
<br/>

### Tech Stack
Java 11 <br/>
H2 Database Engine <br/>
spring boot <br/>
spring data jpa <br/>
spring web <br/>
hibernate <br/>
logback <br/>
maven <br/>
junit <br/>
springfox-swagger-ui <br/>
datasource-proxy <br/>
<br/>


## API OPERATIONS
### Save store with products sucessfully to database

Method : HTTP.POST <br/>
URL : http://localhost:8080/customer-info/store/save <br/>

Request : 
<pre>
curl --location --request POST 'http://localhost:8080/customer-info/store/save' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "jeans_store",
  "products": [
    {
      "name": "prod1"
    },
    {
      "name": "prod2"
    },
    {
      "name": "prod3"
    }
  ]
}'
</pre><br/>

Response : 

HTTP response code 200 <br/>
<pre>
{
    "id": 1,
    "name": "jeans_store",
    "products": [
        {
            "id": 1,
            "name": "prod3"
        },
        {
            "id": 2,
            "name": "prod1"
        },
        {
            "id": 3,
            "name": "prod2"
        }
    ]
}
</pre>


### List Store saved to database

Method : HTTP.GET <br/>
URL : http://localhost:8080/customer-info/store/list <br/>

Request : 
<pre>
curl --location --request GET 'http://localhost:8080/customer-info/store/list'
</pre><br/>

Response : 

HTTP response code 200 <br/>
<pre>
[
    {
        "id": 1,
        "name": "jeans_store",
        "products": [
            {
                "id": 1,
                "name": "prod3"
            },
            {
                "id": 2,
                "name": "prod1"
            },
            {
                "id": 3,
                "name": "prod2"
            }
        ]
    }
]
</pre><br/>
