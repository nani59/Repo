pipeline {
    agent any

    tools{
       maven 'localmaven' 
    }
    stages {
        stage('Build') { 
            steps {
               sh 'mvn clean package' 
            }
            post {
               success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.jar'
                   }
              } 
          }


    stage('Deliver') {
        steps {
             sh 'scp -v -o StrictHostKeyChecking=no  -i /var/lib/jenkins/secrets/mykey target/*.jar ubuntu@00.00.00.00:/home/ubuntu'
             sh "sshpass -p password ssh -o StrictHostKeyChecking=no -i /var/lib/jenkins/secrets/mykey ubuntu@00.00.00.00 '/home/ubuntu/start.sh'"
        }
    }
}
