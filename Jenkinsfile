pipeline {
    agent any

    tools {
        jdk 'Java-11'
    }

    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH=${PATH}"
                    echo "JAVA_HOME=${JAVA_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt clean compile"
            }
        }
        stage('Test') {
            steps {
                sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt test"
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt jacoco"
                    sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt sonarScan"
                }
            }
        }
    }
}
