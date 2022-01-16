pipeline {
	agent any

	tools {
	    
	maven"MAVEN"
	
	}
	
	stages {
	    
	 stage ('compile'){
	 
	 steps {
	     
	  sh "mvn clean compile"
	  
	 }
	 }
	 
	  stage ('Test'){
	  
	  steps {
	  
	   sh "mvn clean Test"
	  }
	      
	  }
	  
	  stage ('Depoly'){
	 
	 steps {
	   sh "mvn clean Depoly"
	 }
	    }
	  
	   }
	 
	}
