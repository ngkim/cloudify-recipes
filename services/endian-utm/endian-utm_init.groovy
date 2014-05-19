import org.cloudifysource.utilitydomain.context.ServiceContextFactory

def context = ServiceContextFactory.getServiceContext()
def config = new ConfigSlurper().parse(new File("${context.serviceDirectory}/nginx.properties").toURL())
def instanceId = context.instanceId

println "endian-utm_init.groovy: Initialize endian-utm..."

new AntBuilder().sequential {
	mkdir(dir:config.installDir)
	get(src:config.downloadPath, dest:"${config.installDir}/${config.zipName}", skipexisting:true)
	unzip(src:"${config.installDir}/${config.zipName}", dest:config.installDir, overwrite:true)
}
