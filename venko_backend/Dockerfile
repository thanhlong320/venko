FROM quay.io/wildfly/wildfly
ADD ./customization /opt/jboss/wildfly/customization/
COPY ./target/venko.war /opt/jboss/wildfly/customization/
EXPOSE 8080 9990
CMD ["sh","/opt/jboss/wildfly/customization/execute.sh"]