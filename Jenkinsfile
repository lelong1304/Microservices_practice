pipeline {
    agent any
        stages {
            stage('git clone') {
                step {
                    checkout scm
                }
            }

            stage('clean install') {
                step {
                    mvn clean install
                }
            }
            stage('liquibase update') {
                step {
                    mvn liquibase:update
                }
            }

            stage('Build image') {
                step {
                    app = docker.build("user-msa/v1")
                }
            }

            stage('Push image') {
                step {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
}