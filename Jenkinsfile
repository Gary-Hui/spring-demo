node('demo') {

	stage('Checkout') {
		git credentialsId: 'gogs-credential', url: 'https://gogs.cn133.azure.net/demo/demo-project.git'
	}

	stage('Test') {
		runCommandInContainer {
		    image = 'baselibrary/gradle'
		    version = 'jdk8-alpine'
		    workspacePath = '.'
		    containerPath = '/app'
		    command = 'gradle test --stacktrace'
		}
	}
    
	stage('Build') {

		runCommandInContainer {
		    image = 'baselibrary/gradle'
		    version = 'jdk8-alpine'
		    workspacePath = '.'
		    containerPath = '/app'
		    command = 'gradle build --stacktrace'
		}

		buildDockerImage {
			service = 'demo-project'
			path = '.'
 		}
	}

	stage('Deploy: test') {
		deployService {
		    environment = 'test'
		    service = 'demo-project'
		    replicas = 1
		    servicePort = 80
		    containerPort = 8080
		}
	}

	stage('Deploy: uat') {
		input 'Deploy uat?'
		deployService {
		    environment = 'uat'
		    service = 'demo-project'
		    replicas = 2
		    servicePort = 80
		    containerPort = 8080
		}

		def next = input message: 'Need rollback ?', ok: 'OK', parameters: [
		    [$class: 'ChoiceParameterDefinition', choices: 'done\nrollback', description: '', name: 'continue or rollback?']
		]
		if (next == 'rollback') {
			rollbackService {
			    environment = 'uat'
			    service = 'demo-project'
			}
		}
	}

	stage('Deploy: production') {
		input 'Deploy production?'
		deployService {
		    environment = 'production'
		    service = 'demo-project'
		    replicas = 2
		    servicePort = 80
		    containerPort = 8080
		}

		def next = input message: 'Need rollback ?', ok: 'OK', parameters: [
		    [$class: 'ChoiceParameterDefinition', choices: 'done\nrollback', description: '', name: 'continue or rollback?']
		]
		if (next == 'rollback') {
			rollbackService {
			    environment = 'production'
			    service = 'demo-project'
			}
		}
	}
}
