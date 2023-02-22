pipeline {
    agent any

    tools {
        jdk 'Java-11'
    }

    environment {
        SONAR_SECRET_TOKEN = credentials('sonar-secret-token')
    }

    stages {
        stage('Build') {
            steps {
                sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt clean compile"
            }
        }
        stage('Test') {
            steps {
                sh "${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt test jacoco"
            }
            post {
                always {
                    junit '**/target/test-reports/*.xml'
                }
            }
        }
        stage('SonarQube analysis') {
            steps {
                    sh('''${tool name: 'sbt-1.2.3', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt \
                      -Dsonar.login="$SONAR_SECRET_TOKEN" \
                      sonarScan''')
            }
        }
    }
}
