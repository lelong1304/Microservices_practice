pipeline {
    agent any
        tools {
                maven 'Maven 3.3.9'
                jdk 'jdk11'
        }
        environment {
            DOCKERHUB_CREDENTIAL=credential('docker')
        }

        stages {
            stage('git clone') {
                steps {
                    checkout scm
                }
            }

            stage('clean install') {
                steps {
                    sh 'mvn clean install'
                }
            }
            stage('liquibase update') {
                steps {
                    sh 'mvn liquibase:update'
                }
            }

            stage('Build image') {
                steps {
                    sh 'docker build -t lelong1304/user-msa:latest'
                }
            }
            stage('Build image') {
                steps {
                    sh 'echo $DOCKERHUB_CREDENTIAL_PSW | docker login -u $DOCKERHUB_CREDENTIAL_USR --password-stdin'
                }
            }

            stage('Push image') {
                steps {
                    sh 'docker push lelong1304/user-msa:latest'
                    }
                }
            }
        }
        post {
            always {
                sh 'docker logout'
            }
        }
}