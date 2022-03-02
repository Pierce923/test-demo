# /bin/bash

# 远程root用户登录
echo "---- start docker build ----"


# docker：制作镜像、创建容器
docker_start(){

  # 定义变量
  API_VERSION="0.0.1"
  module_path=$1
  API_NAME=$2
  API_PORT=$3
  JAVA_OPTS=$4
  mnt_path=$5

  echo "---------start docker build----------$(date "+%Y%m%d-%H%M%S")-----------------------------------------"

  # 进入target目录并复制Dockerfile文件
  cd $mnt_path/$module_path/target
  tar -zxvf dockerdir.tar.gz
  cd dockerdir
  pwd

  # 设置镜像名称（以日期时间为镜像标签，防止重复）
  IMAGE_NAME=$API_NAME":"$(date "+%Y%m%d-%H%M%S")
  # 设置容器名称
  CONTAINER_NAME=$API_NAME-$API_VERSION

  # 删除Docker容器
  container_id=$(docker ps -a | grep $CONTAINER_NAME |awk '{print $1}')
  if [ x"$container_id" != x ]
  then
    docker rm -f $container_id
  fi

  # 删除Docker镜像
  image_id=$(docker images | grep $API_NAME |awk '{print $3}')
  if [ x"$image_id" != x ]
  then
    docker rmi $image_id
  fi

  # 构建Docker镜像
  docker build -t $IMAGE_NAME .

  docker images
  # 推送Docker镜像
  #docker push $IMAGE_NAME

  # 启动Docker容器
  docker run -d -p $API_PORT:$API_PORT --restart=always \
  -e JAVA_OPTS="$JAVA_OPTS" \
  -v /etc/localtime:/etc/localtime \
  --init --name $CONTAINER_NAME $IMAGE_NAME

  sleep 3
  docker ps -a | grep $API_NAME

  # 删除Dockerfile文件
  cd $mnt_path
  rm -rf $module_path

  echo "---------docker build success----------$(date "+%Y%m%d-%H%M%S")-----------------------------------------"
}

# 开始制作镜像、创建容器
docker_start springboot-excel springboot-excel 8082 \
"-Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Xmx128M -Xms128M -XX:+UseG1GC -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:/tmp/logs/gc.log" \
"/mnt" >> /mnt/deployment.log

echo "---- docker build success ----"
