FROM registry.cn-hangzhou.aliyuncs.com/choerodon-tools/javabase:0.8.0
COPY esp-remote-control-0.0.1-SNAPSHOT.jar /esp-remote-control-0.0.1-SNAPSHOT.jar
ENV TZ UTC
ENTRYPOINT exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS $APM_OPTS -jar /esp-remote-control-0.0.1-SNAPSHOT.jar --spring.profiles.active=prd
