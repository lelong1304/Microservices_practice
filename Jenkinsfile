node {
    dev app
    stage('git clone') {
        checkout scm
    }

    stage('clean install') {
        mvn clean install
    }

    stage('liquibase update') {
        mvn liquibase:update
    }

    stage('Build image') {
        app = docker.build("user-msa/v1")
    }
    stage('Test image') {
        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker') {
        app.push("${env.BUILD_NUMBER}")
        app.push("latest")
        }
    }
}