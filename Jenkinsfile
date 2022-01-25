pipeline {
    agent any
        environment {
            imageName = "lelong1304/user-msa-dev"
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

            stage('liquibase update') {
                steps {
                    sh 'mvn liquibase:update'
                }
            }
/*
            stage('Build image') {
                steps {
                    script {
                        dockerImage = docker.build imageName + ":$BUILD_NUMBER"
                    }
                }
            }*/
            /*

            stage('Login Docker') {
                steps {
                    sh 'echo $DOCKERHUB_CREDENTIAL_PSW | docker login -u $DOCKERHUB_CREDENTIAL_USR --password-stdin'
                }
            }*/
            stage('Docker Build and Tag') {
                       steps {

                            sh 'docker image build -t user-msa-dev:latest .'
                            sh 'docker tag user-msa-dev lelong1304/user-msa-dev:latest'
                            //sh 'docker tag samplewebapp nikhilnidhi/samplewebapp:$BUILD_NUMBER'

                      }
                    }


            stage('Push image') {
                steps {
                    script {
                        docker.withRegistry([ credentialsId: "docker", url: "" ]) {
                                  sh  'docker push lelong1304/user-msa-dev:latest'

                        /*
                            dockerImage.push("${env.BUILD_NUMBER}")
                            dockerImage.push('latest')
                            */
                            /*
                            dockerImage = docker.build('lelong1304/user-msa-dev:latest')

                            dockerImage.push()*/
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