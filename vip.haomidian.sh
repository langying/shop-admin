cp -fr vip.haomidian.yml        src/main/resources/application-prod.yml
cp -fr vip.haomidian.properties src/main/resources/velocity/jpush.properties

mvn clean package -Dmaven.test.skip=true

scp ./target/gold-admin.jar root@haomidian.vip:/root/apps/vip.haomidian.admin.jar

ssh root@haomidian.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.haomidian.admin.jar --spring.profiles.active=prod --server.port=8081 > /root/apps/vip.haomidian.admin.log &
  exit
eeooff
