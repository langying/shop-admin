cp -fr vip.chsd.yml        src/main/resources/application-prod.yml
cp -fr vip.chsd.properties src/main/resources/velocity/jpush.properties

mvn clean package -Dmaven.test.skip=true

scp ./target/gold-admin.jar root@dev.chsd.vip:/root/apps/vip.chsd.admin.jar

ssh root@dev.chsd.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.chsd.admin.jar --spring.profiles.active=prod --server.port=8281 > /root/apps/vip.chsd.admin.log &
  exit
eeooff
