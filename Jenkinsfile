pipeline {
    agent any
        environment {
            imageName = "lelong1304/user-msa:latest"
            DOCKERHUB_CREDENTIAL=credentials('docker')
            dockerImage = ''
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
            /*
            stage('liquibase update') {
                steps {
                    sh 'mvn liquibase:update'
                }
            }*/

            stage('Build image') {
                steps {
                    script {
                        dockerImage = docker.build("lelong1304/user-msa")
                    }
                }
            }

            stage('Login Docker') {
                steps {
                    sh 'echo $DOCKERHUB_CREDENTIAL_PSW | docker login -u $DOCKERHUB_CREDENTIAL_USR --password-stdin'
                }
            }


            stage('Push image') {
                steps {
                    script {
                    /*
                        docker.withRegistry('https://registry.hub.docker.com', 'docker') {
                            dockerImage.push("${env.BUILD_NUMBER}")
                            dockerImage.push('latest')
                        }*/
                        sh 'docker push lelong1304/user-msa:latest'
                    }
                    //sh 'docker push lelong1304/user-msa:latest'
                }
            }
        }

        post {
            always {
                sh 'docker logout'
            }
        }
}