# Docker tarafından kullanılacak JDK sürümünü belirtir.
FROM amazoncorretto:17
# JAR_FILE --> jar dosyasının path yolunu dinamik olarak verilebilmesini sağlar
ARG JAR_FILE=target/*.jar
# JAR dosyalarının bilgisayarda bir kopyasını üretmek için, verilmediğinde çalışabilir
COPY ${JAR_FILE} application.jar
# Dockerfile' ın hangi parametrelerini alarak çalışacağını belirtir.
ENTRYPOINT ["java","-Xmx2048M","-jar","/application.jar"]