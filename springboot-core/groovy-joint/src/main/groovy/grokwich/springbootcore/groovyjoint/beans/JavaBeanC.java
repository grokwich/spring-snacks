package grokwich.springbootcore.groovyjoint.beans;

class JavaBeanC extends GroovyBeanB {
	public String msg() {
		return super.msg() + " > JavaBeanC";
	}
}

