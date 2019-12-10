# Kubernetes enterprise integration patterns with Camel-K

## Resources
https://youtu.be/51x9BewGCYA


### Commands to run these Camel Routes:
```
kamel run Routes.java -p token=$TELEGRAM_KEY --dev

kamel run -d mvn:org.apache.camel:camel-jackson:3.0.0-RC2 -d mvn:javax.ws.rs:jsr311-api:1.1.1 -d mvn:org.apache.camel:camel-netty-http:3.0.0-RC2 -d mvn:org.apache.camel:camel-swagger-java:3.0.0-RC2 SimpleRouteBuilder2.java --dev

http://simple-route-builder2-demo.192.168.99.125.nip.io/camel/api-doc
```
