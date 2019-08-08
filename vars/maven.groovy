#!/usr/bin/env groovy

def call(maven) {
  
  node {
          stage('git clone') { 
                sh 'git clone https://github.com/vMahidhar/pipeline-library-demo.git' 
          }
          stage('echo') { 
                echo 'cloned project' 
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
