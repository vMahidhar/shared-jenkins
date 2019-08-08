#!/usr/bin/env groovy

    stages {
        stage('clean') { 
            steps {
               sh 'mvn clean' 
            }
        }
        stage('validate') { 
            steps {
                sh 'mvn validate' 
            }
        }
        stage('Deploy') { 
            steps {
                sh 'mvn package'
            }
        }
    }
