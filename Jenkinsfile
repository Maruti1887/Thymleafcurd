pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
            post {
                success {
                    echo 'Build Successful'
                }
                failure {
                    echo 'Build Failed'
                }
            }
        }

        stage('Run Spring Boot Application') {
            steps {
                sh '''
                    echo "Stopping existing application if running..."

                    sudo pkill -f "thymleaf_crud2-0.0.1-SNAPSHOT.jar" || true

                    sleep 3

                    echo "Available JAR files:"
                    ls -lh target/*.jar

                    echo "Starting Spring Boot application..."

                    sudo nohup java -jar target/thymleaf_crud2-0.0.1-SNAPSHOT.jar > app.log 2>&1 &

                    sleep 10

                    echo "Application Started Successfully"
                '''
            }
        }

        stage('Verify Application') {
            steps {
                sh '''
                    echo "Checking application status..."

                    ps -ef | grep thymleaf_crud2 | grep -v grep || true

                    curl http://localhost:8086 || true
                '''
            }
        }
    }

    post {

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Pipeline execution failed.'
        }

        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}