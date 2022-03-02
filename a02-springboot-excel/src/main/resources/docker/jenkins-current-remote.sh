# /bin/bash

# jenkins本机打包命令
echo "---- start tar ----"

# 压缩文件
docker_start(){

  module_path=$1

	echo "$WORKSPACE"
	# 进入target目录并复制Dockerfile文件
	cd $WORKSPACE/$module_path/target
	if [ ! -d "dockerdir" ];then
    mkdir dockerdir
  else
    rm -rf dockerdir
    mkdir dockerdir
  fi
	cp classes/docker/Dockerfile ./dockerdir
	cp *.jar ./dockerdir
  tar czvf dockerdir.tar.gz ./dockerdir

}

docker_start springboot-excel

echo "---- tar success ----"
