import org.cloudifysource.utilitydomain.context.ServiceContextFactory

def context = ServiceContextFactory.getServiceContext()
def config = new ConfigSlurper().parse(new File("${context.serviceDirectory}/EndianUTM.config").toURL())
def instanceId = context.instanceId

println "endian-utm_init.groovy: Initialize endian-utm..."
