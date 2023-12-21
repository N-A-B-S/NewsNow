FROM amazoncorretto:21
COPY ./out/production/BST/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "Main"]