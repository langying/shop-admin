cp -fr vip.qicaiqianbao.yml        src/main/resources/application-prod.yml
cp -fr vip.qicaiqianbao.properties src/main/resources/velocity/jpush.properties

mvn clean package -Dmaven.test.skip=true

scp ./target/gold-admin.jar root@h5.qicaiqianbao.vip:/root/apps/vip.qicaiqianbao.admin.jar

ssh root@h5.qicaiqianbao.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.qicaiqianbao.admin.jar --spring.profiles.active=prod --server.port=8081 > /root/apps/vip.qicaiqianbao.admin.log &
  exit
eeooff
