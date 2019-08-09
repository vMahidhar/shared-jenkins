#!/usr/bin/env groovy

def call(maven) {
  
  node {
          stage ('clean Project') {
                sh 'rm -rf pipeline-library-demo'
          }
          stage ('clone Project') {
                sh 'git clone https://github.com/vMahidhar/pipeline-library-demo.git'
          }
          stage('clean') { 
                sh 'mvn clean -f pipeline-library-demo/' 
          }
          stage('validate') { 
                  sh 'mvn validate' 
          }
          stage('Deploy') { 
                  sh 'mvn package'
          }
    }
}
