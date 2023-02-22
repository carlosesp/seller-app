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
                    echo "SONAR_SCANNER_HOME=${SONAR_SCANNER_HOME}"
                    echo "SONAR_HOST_URL=${SONAR_HOST_URL}"
                    echo "SONAR_LOGIN=${SONAR_LOGIN}"
                '''
                echo sh(script: 'env|sort', returnStdout: true)
            }
        }
        stage('Build') {
            steps {
                sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt clean compile"
            }
        }
        stage('Test') {
            steps {
                sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt coverage test coverageReport"
            }
        }
        stage('SonarQube analysis') {
            steps {
                 sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt sonarScan"
            }
        }
    }
}
