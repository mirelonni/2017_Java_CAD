build:
	javac -g Main.java

clean:
	find . -name "*.class" -type f -delete
	rm -f *.rgba
	rm -f *.png
