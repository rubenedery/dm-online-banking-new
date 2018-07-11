pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
		sh ‘ls’
		sh ’cd data-access-services’
		sh ’mvn clean’
		sh ‘mvn install’
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
		sh ‘mvn test’
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		sh ‘mvn deploy’
            }
        }
    }
}