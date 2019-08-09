#!/usr/bin/env groovy

def call(maven) {
  
  node {
          stage ('clean Project') {
                sh 'rm -rf pipeline-library-demo'
          }
          stage ('clone Project') {
                sh 'git clone https://github.com/vMahidhar/pipeline-library-demo.git'
          }
          stage('Change Working Directory') { 
                sh 'cd pipeline-library-demo' 
          }
          stage('clean') { 
                sh 'mvn clean -f /root/.jenkins/workspace/test/pipeline-library-demo' 
          }
          stage('validate') { 
                  sh 'mvn validate' 
          }
          stage('Deploy') { 
                  sh 'mvn package'
          }
    }
}
