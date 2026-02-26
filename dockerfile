# Criação da imagem docker
FROM tomcat:11.0-jdk21-temurin
#remove permissão (adm para executar)/ remoção dos arquivos WEBAPPS do tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

#renomeando o arquivo 
COPY target/app.war /usr/local/tomcat/webapps/ROOT.war

#abrir a porta 8080
EXPOSE 8080

CMD ["catalina.sh", "run"]
