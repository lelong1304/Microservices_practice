pipeline {
    agent any
        environment {
            imageName = "lelong1304/user-msa"
            DOCKERHUB_CREDENTIAL=credentials('docker')
            dockerImage = ''
        }

        stages {
            stage('git clone') {
                steps {
                    git 'https://github.com/lelong1304/Microservices_practice.git'
                    //checkout scm
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
                                    sh 'docker rmi $imageName'

                        dockerImage = docker.build imageName
                    }
                }
            }
            /*
            stage('Login Docker') {
                steps {
                    sh 'echo $DOCKERHUB_CREDENTIAL_PSW | docker login -u $DOCKERHUB_CREDENTIAL_USR --password-stdin'
                }
            }*/


            stage('Push image') {
                steps {
                    script {
                        docker.withRegistry('', DOCKERHUB_CREDENTIAL) {
                        /*
                            dockerImage.push("${env.BUILD_NUMBER}")
                            dockerImage.push('latest')
                            */
                            dockerImage.push()
                        }
                    }
                    //sh 'docker push lelong1304/user-msa:latest'
                }
            }
        }
        /*
        post {
            always {
                sh 'docker logout'
            }
        }*/
}