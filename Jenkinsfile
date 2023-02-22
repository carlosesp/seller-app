pipeline {
    agent any

    tools {
        jdk 'Java-11'
    }

    environment {
        SONAR_SECRET_TOKEN = credentials('sonar-secret-token')
    }

    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH=${PATH}"
                    echo "JAVA_HOME=${JAVA_HOME}"
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
            step([$class: 'ScoveragePublisher', reportDir: 'target/scala-2.12/scoverage-report', reportFile: 'scoverage.xml']) {
                    sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt \
                      -Dsonar.login=$SONAR_SECRET_TOKEN \
                      sonarScan"
            }

        }
    }
}
