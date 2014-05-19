service {
	name "endian-utm"
	type "APP_SERVER"

	elastic false
	numInstances	1
	minAllowedInstances	1
	maxAllowedInstances	1

	compute {
		template "SMALL_LINUX"
	}

	lifecycle {
		init  	"endian-utm_init.groovy"
		install "endian-utm_install.groovy"
		start 	"endian-utm_start.groovy"
    }
}
