java -jar -server -Xms512m -Xmx512m -Xss512k ./lib/bootapp-1.0.jar --spring.config.location=file:./config/ --spring.resources.static-locations=file:./static/ -Dfile.dir=./static/files/
@pause