install:
	sh ./gradlew clean install
run-dist:
	sh build/install/app/bin/app
check-updates:
	./gradlew dependencyUpdates
lint:
	sh ./gradlew checkstyleMain
build: lint install
