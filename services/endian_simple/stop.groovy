println "stop.groovy"

File settings = new File("/home/ngkim/tmp/settings")
if(!settings.exists()) {
    new File("/home/ngkim/tmp/").mkdirs()
    settings.createNewFile()
}
