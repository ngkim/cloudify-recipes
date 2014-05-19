mport java.util.concurrent.TimeUnit;
import static JmxMonitors.*


service {
	name "endian_simple"
	icon "tomcat.gif"
	type "APP_SERVER"

	elastic false
	numInstances	1
	minAllowedInstances	1
	maxAllowedInstances	1

	compute {
		template "SMALL_LINUX"
		//template "MEDIUM_LINUX"
	}

	lifecycle {
		start "start.groovy"
		startDetectionTimeoutSecs 240
		startDetection {
			return ServiceUtils.isPortOccupied(80)
	 	}
		preStop "stop.groovy"
    }
}
