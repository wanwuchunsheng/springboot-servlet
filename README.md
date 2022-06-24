# springboot-servlet
jenkins测试

要想java 调用k8s服务名，无需带接口的话， k8s yaml文件名称和 项目名称，servlet名称一致，如：

项目名称：
server:
  port: 8200
  servlet:
    context-path: /springboot-servlet
  
spring:
  application:
     name: springboot-servlet
     
k8s名称：
apiVersion: v1
kind: Service
metadata:
  name: springboot-servlet
  namespace: windmagics
  labels:
    app: springboot-servlet
spec:
  ports:
  - protocol: TCP
    port: 8200
    targetPort: 8200
  selector:
    app: springboot-servlet
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: springboot-servlet #名称
  namespace: windmagics
spec:
  replicas: 1 #运行容器的副本数，修改这里可以快速修改分布式节点数量
  selector:
    matchLabels:
      app: springboot-servlet
  template:
    metadata:
      labels:
        app: springboot-servlet
    spec:
      imagePullSecrets:
      - name: registry-nexus-sercet
      containers:
      - name: springboot-servlet
        image: 58.48.62.234:5000/springboot-servlet:1.0.220623162255
        imagePullPolicy: IfNotPresent #Always #pull镜像时机，
        ports:
        - containerPort: 8200 #容器对外开放端口
          protocol: TCP
        volumeMounts:  #容器内挂载点
        - mountPath: /mnt/files/
          name: springboot-servlet  #必须要有的名称
      volumes:
      - name: springboot-servlet  #跟上面保持一致
        hostPath:
          path: /mnt/files/
