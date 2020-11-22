# ClevertecJavaTask1

##  How to compile?
from folder ClevertecJavaTask1 run:
javac -sourcepath ./src/main/java -d bin src/main/java/Runner.java

##  How to run?
from folder ClevertecJavaTask1 run:
java -classpath ./bin Runner 3-1 2-5 5-1 card-1234

## To run app with using csv-files (ProductList and Cards):
arg[0] must be "files-FILE_NAME_TO_PRODUCT_LIST-FILE_NAME_TO_CARD_LIST". For FILE_NAME_* dont write "src/" and ".csv"
### for example
  java -classpath ./bin Runner files-productList-cardList 3-1 2-5 5-1 card-1234 

# ClevTestWeb

## before running web application you must change constant in Constants.java for your path     
public static final String PATH_FILES = "D:\\Java-Projects\\ClevTestWeb\\src\\resources\\";

## after running you can use this URL:
http://localhost:8080/receipt?param=files-productList-cardList&param=2-17&param=4-2&param=card-1234
OR
http://localhost:8080/receipt?param=1-10&param=2-2&param=card-1234

### good luck

