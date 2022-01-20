pipeline {
    agent any
        stages {
            stage('git clone') {
                steps {
                    checkout scm
                }
            }

            stage('clean install') {
                steps {
                    mvn clean install
                }
            }
            stage('liquibase update') {
                steps {
                    mvn liquibase:update
                }
            }

            stage('Build image') {
                steps {
                    app = docker.build("user-msa/v1")
                }
            }

            stage('Push image') {
                steps {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
}