run-dist:
	./build/install/app/bin/app

report:
	./gradlew jacocoTestReport

run-stylish-json-example:
	./gradlew installDist
	./build/install/app/bin/app ./src/test/resources/hexlet/code/fixtures/json/file1.json ./src/test/resources/hexlet/code/fixtures/json/file2.json

run-plain-yaml-example:
	./gradlew installDist
	./build/install/app/bin/app -f plain ./src/test/resources/hexlet/code/fixtures/yaml/file1.yml ./src/test/resources/hexlet/code/fixtures/yaml/file2.yml
