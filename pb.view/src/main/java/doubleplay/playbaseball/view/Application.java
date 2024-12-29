package doubleplay.playbaseball.view;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        String openApiUrl = "http://localhost:8080/playBaseBall/v3/api-docs";
//        String subProjectUrl = "http://localhost:8081/api-specs/receive-openapi";
//
//        RestTemplate restTemplate = new RestTemplate();
//        String openApiSpec = restTemplate.getForObject(openApiUrl, String.class);
//
//        // HTTP POST 요청으로 전송
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON); // JSON 데이터 전송
//        HttpEntity<String> request = new HttpEntity<>(openApiSpec, headers);
//
//        restTemplate.postForObject(subProjectUrl, request, String.class);
//
//        System.out.println("OpenAPI 명세를 서브 프로젝트로 전송했습니다.");
//    }

    @Override
    public void run(String... args) throws Exception {
        // OpenAPI 명세를 문자열로 정의
        String openApiSpec = """
                openapi: 3.0.0
                info:
                  title: Complex API Example
                  version: 1.0.0
                paths:
                  /users:
                    get:
                      summary: Get user list
                      responses:
                        '200':
                          description: Successful response
                          content:
                            application/json:
                              schema:
                                $ref: '#/components/schemas/UserList'
                  /users/{id}:
                    get:
                      summary: Get user details
                      parameters:
                        - name: id
                          in: path
                          required: true
                          schema:
                            type: string
                      responses:
                        '200':
                          description: Successful response
                          content:
                            application/json:
                              schema:
                                $ref: '#/components/schemas/User'
                  /orders:
                    post:
                      summary: Create an order
                      requestBody:
                        content:
                          application/json:
                            schema:
                              $ref: '#/components/schemas/CreateOrderRequest'
                      responses:
                        '201':
                          description: Order created
                  /orders/{id}:
                    get:
                      summary: Get order details
                      parameters:
                        - name: id
                          in: path
                          required: true
                          schema:
                            type: string
                      responses:
                        '200':
                          description: Successful response
                          content:
                            application/json:
                              schema:
                                $ref: '#/components/schemas/Order'
                  /products:
                    get:
                      summary: Get product list
                      responses:
                        '200':
                          description: Successful response
                          content:
                            application/json:
                              schema:
                                $ref: '#/components/schemas/ProductList'
                  /inventory:
                    get:
                      summary: Get inventory details
                      responses:
                        '200':
                          description: Successful response
                          content:
                            application/json:
                              schema:
                                $ref: '#/components/schemas/Inventory'
                components:
                  schemas:
                    UserList:
                      type: object
                      properties:
                        users:
                          type: array
                          items:
                            $ref: '#/components/schemas/User'
                    User:
                      type: object
                      properties:
                        id:
                          type: string
                        name:
                          type: string
                        email:
                          type: string
                    CreateOrderRequest:
                      type: object
                      properties:
                        userId:
                          type: string
                        productId:
                          type: string
                        quantity:
                          type: integer
                    Order:
                      type: object
                      properties:
                        id:
                          type: string
                        userId:
                          type: string
                        productId:
                          type: string
                        quantity:
                          type: integer
                    ProductList:
                      type: object
                      properties:
                        products:
                          type: array
                          items:
                            $ref: '#/components/schemas/Product'
                    Product:
                      type: object
                      properties:
                        id:
                          type: string
                        name:
                          type: string
                        price:
                          type: number
                    Inventory:
                      type: object
                      properties:
                        productId:
                          type: string
                        availableQuantity:
                          type: integer
                """;

        String subProjectUrl = "http://localhost:8081/api-specs/receive-openapi";

        // HTTP POST 요청으로 전송
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // JSON 데이터 전송
        HttpEntity<String> request = new HttpEntity<>(openApiSpec, headers);

        restTemplate.postForObject(subProjectUrl, request, String.class);

        System.out.println("OpenAPI 명세를 서브 프로젝트로 전송했습니다.");
    }
}
