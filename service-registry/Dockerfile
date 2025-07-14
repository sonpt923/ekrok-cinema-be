# Sử dụng image OpenJDK 11 dựa trên Alpine (nhẹ, tối ưu)
FROM openjdk:11-jdk-slim

# Tạo thư mục làm việc
WORKDIR /app

# Copy file JAR từ target vào container
COPY target/service-registry-1.0.jar app.jar

# Cấu hình volume cho dữ liệu tạm (nếu cần)
VOLUME /tmp

# Cấu hình JVM options để tối ưu tài nguyên (phù hợp với 512MB RAM của Render)
ENV JAVA_OPTS="-Xmx256m -Xms128m"

# Cổng mặc định của Eure(thay đổi nếu dùng cổng khác trong application.properties)
EXPOSE 8761

# Chạy ứng dụng với JAVA_OPTS
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]