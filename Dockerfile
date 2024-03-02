# 设置JAVA版本
FROM openjdk:16
# 指定存储卷, 任何向/tmp写入的信息都不会记录到容器存储层
VOLUME /tmp
# 拷贝运行JAR包
ADD target/ymx_project-0.0.1-SNAPSHOT.jar /app/ymx_project.jar

## 设置JVM运行参数， 这里限定下内存大小，减少开销
#ENV JAVA_OPTS="\
#-server \
#-Xms256m \
#-Xmx512m \
#-XX:MetaspaceSize=256m \
#-XX:MaxMetaspaceSize=512m"
##空参数，方便创建容器时传参
#ENV PARAMS=""
# 入口点， 执行JAVA运行命令

EXPOSE 8001
ENTRYPOINT ["sh","-c","java -jar /app/ymx_project.jar"]
