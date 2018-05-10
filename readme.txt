#copy any springboot jar e.g. hello-world-springboot.jar to this directory and exec build(with apropriate image name and label)
docker build -t djudikator/dju-springboot-docker:1.0.0 --build-arg JAR_FILE=target\hello-world-springboot.jar .

#runing in container (for image in prev example)
docker run -p 8080:8080 -t djudikator/dju-springboot-docker:1.0.0

#runing with build and compose - see docker-compose-build.yml (check name of jar file in webapp/build/args)
docker-compose -f docker-compose-build.yml build

#runing with compose - see docker-compose.yml
docker-compose up -d