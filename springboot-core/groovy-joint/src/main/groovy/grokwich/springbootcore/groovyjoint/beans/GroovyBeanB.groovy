package grokwich.springbootcore.groovyjoint.beans;

class GroovyBeanB extends JavaBeanA {
	String msg() {
		"${super.msg()} > GroovyBeanB"
	}
}

