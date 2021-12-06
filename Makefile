install:
	gradlew clean install
run-dist:
	bash build/install/app/bin/app
check-updates:
	gradlew dependencyUpdates
