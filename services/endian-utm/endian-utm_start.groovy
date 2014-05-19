import org.cloudifysource.utilitydomain.context.ServiceContextFactory
import org.cloudifysource.dsl.utils.ServiceUtils

def context = ServiceContextFactory.getServiceContext()
def config = new ConfigSlurper().parse(new File("${context.serviceDirectory}/EndianUTM.config").toURL())
def instanceId = context.instanceId

println "endian-utm_start.groovy: Start endian-utm..."


