set "CURR_DIR=%~dp0%"
set "MAIN_CLASS=org.springframework.boot.loader.JarLauncher"
set "SPRING_CFG_PATH=--spring.config.location=file:%CURR_DIR%\config\ --spring.resources.static-locations=file:%CURR_DIR%\static\"
set "JAVA_OPTS=-server -Xms512m -Xmx512m -Xss512k -Dfiles.dir=%CURR_DIR%\static\files\"
set "CLASSPATH=%CURR_DIR%;%CURR_DIR%\lib;%CURR_DIR%\lib\bootapp-1.0.jar"
java %JAVA_OPTS% -cp %CLASSPATH% %MAIN_CLASS% %SPRING_CFG_PATH% 