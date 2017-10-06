package grokwich.springbootcore.groovyjoint.beans;

class GroovyBeanD extends JavaBeanC {
	String msg() {
		"${super.msg()} > GroovyBeanD"
	}
}

