# Usa uma imagem base com Java 21
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia todos os arquivos do projeto para dentro da imagem
COPY . .

# Dá permissão de execução ao wrapper do Maven (caso esteja usando ./mvnw)
RUN chmod +x ./mvnw

# Compila o projeto (sem rodar testes)
RUN ./mvnw clean package -DskipTests

# Expõe a porta padrão da aplicação (ajuste se necessário)
EXPOSE 8080

# Executa o JAR gerado
CMD ["java", "-jar", "target/dslist-0.0.1-SNAPSHOT.jar"]
