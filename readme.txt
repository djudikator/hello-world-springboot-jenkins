#copy any springboot jar e.g. hello-world-springboot.jar to this directory and exec build(with apropriate image name and label)
docker build -t djudikator/dju-springboot-docker:1.0.0 --build-arg JAR_FILE=target\hello-world-springboot.jar .

#runing in container (for image in prev example)
docker run -p 8080:8080 -t djudikator/dju-springboot-docker:1.0.0

#runing with build and compose - see docker-compose-build.yml (check name of jar file in webapp/build/args)
docker-compose -f docker-compose-build.yml build

#runing with compose - see docker-compose.yml
docker-compose up -d

# jenkins initial pwd b0face9e727244c983ffaec8cd332f6e

#run docker inside container
https://getintodevops.com/blog/building-your-first-docker-image-with-jenkins-2-guide-for-developers

docker run -d -p 8080:8080 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  --name jenkins \
  jenkins/jenkins:lts

chmod 777 /var/run/docker.sock


https://getintodevops.com/blog/the-simple-way-to-run-docker-in-docker-for-ci
