#!/usr/bin/env groovy

def call(maven) {
  
  node {
          stage('clean previous repo') { 
                sh 'rm -rf pipeline-library-demo' 
          }
          stage('git clone') { 
                sh 'git clone https://github.com/vMahidhar/pipeline-library-demo.git' 
          }
          stage('echo') { 
                echo 'cloned project' 
          }

    
          stage('clean') { 
                          withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: 'maven',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // We recommend to define Maven settings.xml globally at the folder level using
        // navigating to the folder configuration in the section "Pipeline Maven Configuration / Override global Maven configuration"
        // or globally to the entire master navigating to  "Manage Jenkins / Global Tools Configuration"
        mavenSettingsConfig: 'my-maven-settings') 
                sh 'mvn clean -f pipeline-library-demo' 
          }
          stage('validate') { 
                  sh 'mvn validate -f pipeline-library-demo' 
          }
          stage('Deploy') { 
                  sh 'mvn package -f pipeline-library-demo'
          }
    }
}
