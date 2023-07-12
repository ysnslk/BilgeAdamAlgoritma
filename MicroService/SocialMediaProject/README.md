
### @Service, @Repository, @Controller, (@Configuration) --> @Component
### @SpringBootApplication --> Component olan sınıflardan birer instance üretiyor.
### Ürettiği instance' ları arkada tarafta IoC Container' a uygun bir şekilde bir depoda tutuyor.
### Bu deponun adı --> applicationContext, SpringBootApplication, beanContainer

#### JDK vs JRE nedir?
#### JVM nedir? Java JVM ile nasıl çalışır?
#### Spring Stereo Type Annotation nedir? Anotasyonlar arasındaki farklar nelerdir?
#### @Configuration ve @Bean nedir?
#### ApplicationContext=SpringContainer nedir?
#### Spring de bean mantığı nedir? (Spring bean)
#### DI nedir? ne için kullanılır? tipleri nelerdir?
#### Autowired nedir? Neden cons inj. neden autowired?
#### SpringFramework vs SpringBoot?
#### SOLID prensipleri nelerdir?


## Http Request - JavaServlet Container
### Javada web işlemlerinde her şey http üzerinden yapılır ve temel olarak request <--> response şeklinde veri taşınır.
### ServletContainer --> Bir uygulamadaki http isteklerini alan, işleyen ve gönderilen cevabı göstermeyi sağlayan bir yapıdır.
### ServletContainer aslında bir sunucudur. Spring BOot' da bu sunucu gömülü olarak gelir. (Apache Tomcat)
### Sunucuya gelen istek DispatcherServlet tarafından alınır ve HandlerMapping' e iletilir.
### HandlerMapping gelen isteğin URL, Mapping(GET,POST vb.) gibi özelliklerine bakarak ilgili Controller metoduna isteği iletir.
### Dönen cevap DispatcherServlet tarafından yakalanır, sunucuya iletilir ve kullanıcıya bir cevap gönderilir.

### HandlerMapping işleminden sonra eğer uygulamada var ise Interceptors araya girer. --> Intercepters nedir?

## FeignClient
### FeignClient, HttpClient(Tomcat), RestTemplate --> Java da dışarıdaki farklı bir endpointe istek atmak için gerekli yapılar.
### RestTemplate --> Daha çok dışarıdaki bir API' dan veri çekmek istediğimizde kullanılırız. Sebebi daha esnek ve değiştirilebilir yöntemler sunuyor olmasıdır.
### HttpClient --> Basic Http Request --> Temel olarak RestTemplate ile aynı işi yapar.
### FeignClient --> Daha çok iki servis arasındaki isteklerde kullanılır. Yani microservice'ler arasındaki istekler için kullanılır.
### FeignClient, Spring Cloud ailesinin bir üyesidir. ve clouddaki uygulamada daha efektif ve etkin çalışabilir. Bu yüzden tercih edilir.

# -----------------------------------------------------------------------------------------

## UserProfileService
### 1- MongoDB denemesi için veritabanına bir kayıt yapılmalıdır. Bu işlem için DTO ve Mapper kullanınız.
### 2- Register işlemi auth service' den feign client aracılığıyla yapıldı. Ancak userprofile service' de kullanıcının bazı bilgileri eksiktir.
###    Eksik olan bilgilerin update metodu ile kullanıcıya tamamlatılması gerekmektedir. Bu işlem için gerekli metodu yazınız.
### 3- UserProfile' da update işlemi yapıldıktan sonra burada değiştirilen verilerin de auth service' e gönderilerek update edilmesi gerekmektedir.
###    Bunun için UserprofileService' den AuthService' e bir manager yazılmalıdır. Ancak userprofile' dan auth' a veriyi gönderirken eşleştirme yapabilmek için
###    bazı ek property'lere ihtiyaç vardır. UserProfile' da ve Auth' da gelen giden verilerde değişiklik yapmak gerekebilir.
###    Bu işlem için gerekli manager ve service metotlarını yazınız.
