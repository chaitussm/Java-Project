# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy the project files
COPY . .

# Build the Maven project
RUN mvn -B clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/classes /app/classes

# Copy dependencies if needed (optional - for direct classpath execution)
COPY --from=builder /app/target/lib /app/lib

# Set the default command to run the main class
# You can change this to run any specific class from your project
CMD ["java", "-cp", "/app/classes", "com.example.Main"]

# Optional: Expose any ports your application uses
# EXPOSE 8080
