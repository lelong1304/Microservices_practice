pipeline {
    agent any
        environment {
            DOCKERHUB_CREDENTIAL=credentials('docker')
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
                    sh 'docker build –t lelong1304/user-msa:latest .'
                }
            }
            stage('Login Docker') {
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
        post {
            always {
                sh 'docker logout'
            }
        }
}