cp -fr vip.jinliangcang.yml        src/main/resources/application-prod.yml
cp -fr vip.jinliangcang.properties src/main/resources/velocity/jpush.properties

mvn clean package -Dmaven.test.skip=true

scp ./target/gold-admin.jar root@h5.jinliangcang.vip:/root/apps/vip.jinliangcang.admin.jar

ssh root@h5.jinliangcang.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.jinliangcang.admin.jar --spring.profiles.active=prod --server.port=8281 > /root/apps/vip.jinliangcang.admin.log &
  exit
eeooff
