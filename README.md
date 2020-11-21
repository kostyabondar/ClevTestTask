# ClevertecJavaTask

##  How to compile?
javac -sourcepath ./src/main/java -d bin src/main/java/Runner.java

##  How to run?
java -classpath ./bin Runner 3-1 2-5 5-1 card-1234

## To run app with using csv-files (ProductList and Cards):
arg[0] must be "files-FILE_NAME_TO_PRODUCT_LIST-FILE_NAME_TO_CARD_LIST". For FILE_NAME_* dont write "src/" and ".csv"
### for example
  java -classpath ./bin Runner files-productList-cardList 3-1 2-5 5-1 card-1234 