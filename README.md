阿里云ECS搭建Git和Web服务
========================
配置环境：
	云环境：Linux CentOS6.5 x64
	Git版本：git-1.9.0
	Java版本：jdk1.8.0_91
	Tomcat版本：tomcat-8.0.35
	MySQL版本：mysql-server5.1.73
	Apache版本：httpd-2.4.18
	PHP版本：php-5.1.6
	phpMyAdmin版本：phpMyAdmin-4.0.0
	
> **Note:**
> 为方便数据库操作，服务器搭载了LAMP服务，搭配phpMyAdmin，可通过网页远程操控数据库、查看数据库信息。

搭建Git服务
--------------
####①安装git:
 # yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel perl-devel
 # wget http://git-core.googlecode.com/files/git-1.9.0.tar.gz
 # tar zxvf git-1.9.0.tar.gz
 # cd git-1.9.0
 # make prefix=/usr/local all
 # make prefix=/usr/local install  

####②创建文件和用户：
新建git文件在/opt中，新建git用户并设置密码（所有成员通过这个用户对仓库进行管理）
 # mkdir /opt/git
 # sudo useradd -m git
 # sudo passwd git 
 
####③权限管理：
将git管理权限给git用户，调到git用户并对相关（密钥管理）文件进行权限设置
 # sudo chown git:git /opt/git 
 # sudo chmod 755 /opt/git
 # su git
 # cd
 # mkdir .ssh && chmod 700 .ssh
 # touch .ssh/authorized_keys && chmod 600 .ssh/authorized_keys
 
####④Git成员设置：
用户进入Git Bash控制台通过控制台生成公钥，上传公钥到git服务器 （->为注释标记）
 # ssh-keygen -t rsa  ->中间问题直接按回车，到生成一个图片为止
 # scp ~/.ssh/id_rsa.pub git@115.29.45.75:/tmp/xxxx.pub   ->xxxx替换成自己名字拼音->回车后提示输入密码为：git

####⑤添加Git成员：
将这些公钥加入系统用户 git 的 .ssh 目录下 authorized_keys 文件的末尾
 # cat /tmp/id_rsa.xxxx.pub >>  ~/.ssh/authorized_keys
 # cat /tmp/id_rsa.xxxxxx.pub >>  ~/.ssh/authorized_keys
 # cat /tmp/id_rsa.xxxxxxx.pub  >>  ~/.ssh/authorized_keys

####⑥新建空仓库：
一定要创建成裸库(bare)
 # cd /opt/git
 # mkdir xxxx.git && cd xxxx.git
 # git init --bare

####⑦主成员初始化库：
 # cd XXXXproject
 # git init
 # git add .
 # git commit -m 'initial commit'
 # git remote add origin ssh://git@115.29.45.75:/opt/git/xxxx.git
 # git push origin master

####⑧其他成员操作:
开发者可以克隆此仓库，并推送各自的改动
 # git clone ssh://git@gitserver:/opt/git/MaBao.git
 # cd project
 # vim README
 # git commit -am 'fix for the README file'
 # git push origin master

> **安全说明:**
> 在git服务器上通常会建立一个git这样一个账户，其它人共用这个账户来克隆或推送数据到git仓库中，通常也只需要这个功能，但是如果不加限制，那么其它人可以通过这个git账户登录到主机，那么这样是不安全的，所以需要加以限制，方法如下：编辑/etc/passwd（# vi /etc/passwd）这个文件，在文件末尾可以找到类似这样的行：
    git:x:1000:1000::/home/git:/bin/sh
    然后把/bin/sh改为/usr/bin/git-shell，这样git这个账户就只能用来克隆或者推送数据到git仓库中了，而不能用它来登录到主机。

搭建web服务
----------------
###Java8 + Tomcat8 装配步骤
####Java8安装与配置:
①安装java8（jdk-8u91-linux-x64）
 # cd /usr/local
 # wget http://211.161.151.140/files/110500000742BCD5/download.oracle.com/otn-pub/java/jdk/8u91-b14/jdk-8u91-linux-x64.tar.gz（因为oracle不让直接下载所以用
工具传--上传工具xftp5）
 # tar zxvf jdk-8u91-linux-x64.tar.gz
 # rm jdk-8u91-linux-x64.tar.gz
 # mv jdk1.8.0_91 jdk8.0

建立/usr/local/下的jdk软连接方便以后版本升级 ：
 # ln -s /usr/local/jdk8.0/ /usr/local/jdk

②配置环境变量：
在 /etc/profile 中加入以下内容(# vi /etc/profile):
JAVA_HOME=/usr/local/jdk8.0
JAVA_BIN=/usr/local/jdk8.0/bin
PATH=#PATH:#JAVA_BIN
CLASSPATH=#JAVA_HOME/lib/dt.jar:#JAVA_HOME/lib/tools.jar
export JAVA_HOME JAVA_BIN PATH CLASSPATH

保存退出
 # source /etc/profile

③查看java环境变量是否生效
 # java -version

####Tomcat8安装与配置:
①安装tomcat8（tomcat-8.0.35）
 # cd /usr/local
 # wget https://codeload.github.com/apache/tomcat/tar.gz/TOMCAT_8_0_0  （GitHub开源地址）
建议还是自己上传，这个地方用开源地址的有bug，弄了两小时
 # tar zxvf apache-tomcat-8.0.35.tar.gz
 # rm -rf apache-tomcat-8.0.35.tar.gz
 # mv apache-tomcat-8.0.35 tomcat8.0

建立/usr/local/下的tomcat软连接方便以后版本升级 ：
 # ln -s /usr/local/tomcat8.0/ /usr/local/tomcat

②配置环境变量:
 # cd tomcat/bin/
 # vim catalina.sh
添加以下内容：
CATALINA_HOME=/usr/local/tomcat8.0

 # chmod +x *.sh

③启动tomcat服务器：
 # ./startup.sh
（说明：如果出现/usr/local/tomcat8.0/logs/catalina.out
输入：mkdir /usr/local/tomcat8.0/logs 再次重启即可）

④测试是否成功：
http://localhost:8080/（如果不是本机测试，localhost则改为对应的ip地址）
测试出现tomcat页面则测试成功
说明：webapps文件夹主要用于web应用程序部署，如war文件拷到该目录下，容器会自动部署。

⑤添加应用，再次进行测试：
（注意：webaapps目录下面主要是放应用包的.war在tomcat重启访问后会自动解压）
 # cd /usr/local/tomcat/webapps
 # tar -zxvf moni2.tar.gz                  //如果是自己文件则放入war
 # ls docs  examples  host-manager  manager  moni2  moni2.tar.gz  ROOT
 # /usr/local/tomcat/bin/catalina.sh start（重启tomcat）
在浏览器中输入如下地址：
http://localhost:8080/moni2/（如果不是本机，localhost则改为对应的ip地址）

> **修改端口号:**
因为后面要安装apache所以要停止并修改tomcat的端口：
 # cd  /usr/local/tomcat/conf
 # vim server.xml
【停止tomcat时的端口】
 8081" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" /> 【tomcat默认的监听端口是8080，现在改成8081】
【apache+tomcat模式时访问tomcat的端口】
 # /usr/local/tomcat/bin/catalina.sh start
现在重启tomcat。访问http://115.29.45.75:8081/moni2/【注意：这时就需要修改端口了】 

###Mysql+Apache+PHP+phpMyAdmin for linux装配步骤

####一、安装mysql（mysql-server.x86_64 5.1.73-7.el6  Linux CentOS6.5 yum自带） 
①yum安装mysql：
 # yum -y install mysql-server

②设置开机启动
 # chkconfig mysqld on

③启动MySql服务
 # service mysqld start

④设置MySQL的root用户设置密码
 # mysql -u root
mysql> select user,host,password from mysql.user;

查询用户的密码，都为空，用下面的命令设置root的密码为123456（自己根据情况改）
mysql> set password for root@localhost=password('123456');
mysql> exit     退出

⑤用新密码登陆
 #  mysql -u root -p
Enter password: 123456

> **远程登录：**
开放远程登录权限方便随时随地查看修改数据：（此处以-u root，-p root登录）
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION;
FLUSH PRIVILEGES;
这样就可以远程通过软件填写ip，用户名（root），密码（root）登录并控制数据库了，但是不太安全。
关闭远程登录：DROP USER 'root'@'%';

####二、安装apache （httpd-2.4.18.tar.gz）
预备：必须安装依赖工具APR、APR-util、pcre,步骤如下:
①安装APR:
 # cd /home
 # wget http://apache.fayea.com/apr/apr-1.5.2.tar.gz
 # tar -zxf apr-1.5.2.tar.gz
 # rm -rf apr-1.5.2.tar.gz
 # cd apr-1.5.2
 # ./configure --prefix=/usr/local/apr
 # make && make install

②安装APR-util:
 # cd /home
 # wget http://apache.fayea.com/apr/apr-util-1.5.4.tar.gz 
 # tar -zxf apr-util-1.5.4.tar.gz 
 # rm -rf apr-util-1.5.4.tar.gz 
 # cd apr-util-1.5.4
 # ./configure --prefix=/usr/local/apr-util -with-apr=/usr/local/apr/bin/apr-1-config
 # make && make install

③安装pcre：
 # cd /home
 # wget ftp://ftp.csx.cam.ac.uk/pub/software/programming/pcre/pcre-8.38.tar.gz
 # tar -zxf pcre-8.38.tar.gz
 # rm -rf pcre-8.38.tar.gz
 # cd pcre-8.38
 # ./configure --prefix=/usr/local/pcre
 # make && make install

④安装apache：
 # cd /home
 # wget http://apache.fayea.com/httpd/httpd-2.4.18.tar.gz
 # tar zxf httpd-2.4.18.tar.gz
 # rm -rf httpd-2.4.18.tar.gz
 # cd httpd-2.4.18
 # ./configure --prefix=/usr/local/apache --with-apr=/usr/local/apr --with-apr-util=/usr/local/apr-util/ --with-pcre=/usr/local/pcre
 # make && make install

⑤启动并测试：
apachectl start 启动apache 完整的命令为：
 # /usr/local/apache/bin/apachectl start

在浏览器测试一下，http://115.29.45.75（服务器公网ip） ，你会看到apache的默认界面:It works！

####三、安装php （php-5.1.6.tar.bz2）
①安装准备库(,libpng-devel):
 # yum install libxml2-devel
 # yum install libpng-devel
 # yum install libtool-libs

②安装libiconv库
 # wget http://ftp.gnu.org/pub/gnu/libiconv/libiconv-1.14.tar.gz
 # tar -zxf libiconv-1.14.tar.gz
 # rm -rf libiconv-1.14.tar.gz
 # cd libiconv-1.14
 # ./configure --prefix=/usr/local
 # make && make install


③安装php：
 # cd /home
 # wget http://cn2.php.net/distributions/php-5.6.22.tar.gz
 # tar -zxf php-5.6.22.tar.gz
 # rm -rf php-5.6.22.tar.gz
 # cd php-5.6.22
 # ./configure --enable-fpm --enable-mbstring --with-mysql --with-iconv-dir=/usr/local --with-apxs2=/usr/local/apache/bin/apxs --without-pear --with-gd --with-zlib --disable-posix --with-config-file-path=/usr/local/lib 
 # make ZEND_EXTRA_LIBS='-liconv'
 # make install

####四、整合apache和php
①修改apache的配置文件
 # vi /usr/local/apache/conf/httpd.conf  
添加:
     AddType application/x-httpd-php .php
     AddType application/x-httpd-php-source .phps
     找到DirectoryIndex index.html ，在index.html前面写上index.php
保存并退出

②修改apache的默认主页文件，添加index.php。
 # echo " < ? php phpinfo() ; ? > " > /usr/local/apache/htdocs/index.php
 # cat /usr/local/apache/htdocs/index.php   查看是否正确

③重启apache并测试
 # /usr/local/apache/bin/apachectl restart  重启命令
在浏览器测试一下，http://115.29.45.75（服务器公网ip） ，你会看到apache的默认界面变为PHP5信息页面

####五、安装phpMyAdmin  （phpMyAdmin-4.0.0）
①下载安装包解压安装转移：# cd /home# wget https://files.phpmyadmin.net/phpMyAdmin/4.0.0/phpMyAdmin-4.0.0-all-languages.tar.gz# tar -zxf phpMyAdmin-4.0.0-all-languages.tar.gz# rm phpMyAdmin-4.0.0-all-languages.tar.gz# mv phpMyAdmin-4.0.0-all-languages /usr/local/apache/htdocs/MSDM

②配置数据：# cd /usr/local/apache/htdocs/MSDM
复制配置模版成为配置文件：
 # cp /usr/local/apache/htdocs/MSDM/config.sample.inc.php /usr/local/apache/htdocs/MSDM/config.inc.php
 # vim config.inc.php  修改这个文件,添加指定内容进去,并去掉注释符：
$ cfg['Servers'][$i]['controlhost'] = 'localhost';   
$ cfg['Servers'][$i]['controluser'] = 'root';  //用户名
$cfg['Servers'][$i]['controlpass'] = '';     //密码
$ cfg['UploadDir'] = '/tmp’ ;
$ cfg['SaveDir'] = '/tmp';

③测试：
重启apache：
 # /usr/local/apache/bin/apachectl restart
开启浏览器测试：http://115.29.45.75/MSDM
这里可以修改MSDM这个目录的名字，这样访问比较方便!

项目整合与发布：
---------------------
####①修改项目配置：
1.数据库连接配置：用户、密码
2.服务器端口号项目配置：如把localhost改成115.29.45.75（本服务器公网ip地址），端口号8080改成8081（本服务器配置为8081），项目名称mb改成MaBaoShop（本服务器中项目配置名）

####②服务器导入准备
1.将数据库本地数据导出成.sql文件
2.将项目导出成.war文件

####③导入数据库数据到服务器：
1.登录上面配置的phpMyAdmin页面（http://115.29.45.75/MSDM）输入账号密码并登录
2.导入.sql数据库文件,在此之前查看并确认字符集是否正确
> **改变服务器MySQL数据库字符集（以UTF-8为例）：**
> 在服务器中登陆MySQL：
 # mysql -u root -p
 Enter password: 
mysql> set character_set_client=utf8;
mysql> set character_set_connection=utf8;
mysql> set character_set_database=utf8;
mysql> set character_set_results=utf8;
mysql> set character_set_server=utf8;
mysql> set character_set_system=utf8;
mysql> set collation_connection=utf8;
mysql> set collation_database=utf8;
mysql> set collation_server=utf8;

####④将.war文件传入服务器Tomcat的webapp文件中，tomcat会自动解析文件，这样项目就顺利发布了。