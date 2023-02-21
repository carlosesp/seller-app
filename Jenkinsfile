pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "${tool name: 'sbt-1.2.3'} compile"
            }
        }
        stage('Test') {
            steps {
                sh "${tool name: 'sbt-1.2.3'} test"
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    sh "${tool name: 'sbt-1.2.3'} jacoco"
                }
            }
        }
    }
}
