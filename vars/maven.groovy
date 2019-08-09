#!/usr/bin/env groovy

def call(maven) {
  
  node {
          stage ('clone Project') {
                sh 'git clone https://github.com/vMahidhar/pipeline-library-demo.git'
          }
          stage('clean') { 
                sh 'mvn clean' 
          }
          stage('validate') { 
                  sh 'mvn validate' 
          }
          stage('Deploy') { 
                  sh 'mvn package'
          }
    }
}
