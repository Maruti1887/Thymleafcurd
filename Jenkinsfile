pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Build Stage') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo "Build Success"
                }
                failure {
                    echo "Build Failed"
                }
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                success {
                    echo "Tests Passed"
                }
                failure {
                    echo "Tests Failed"
                }
            }
        }

        stage('Run Spring Boot Application') {
            steps {
                sh '''
                    echo "Stopping existing application..."

                    if pgrep -f THYMLEAF_CRUD2-0.0.1-SNAPSHOT.jar > /dev/null; then
                        sudo pkill -f THYMLEAF_CRUD2-0.0.1-SNAPSHOT.jar
                        echo "Old application stopped."
                    else
                        echo "No application is running."
                    fi

                    echo "Starting Spring Boot application..."

                    sudo nohup java -jar target/THYMLEAF_CRUD2-0.0.1-SNAPSHOT.jar > app.log 2>&1 &
                '''
            }
        }
    }

    post {
        success {
            echo "Pipeline Executed Successfully"
        }
        failure {
            echo "Pipeline Failed"
        }
    }
}