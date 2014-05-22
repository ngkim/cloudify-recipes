import static JmxMonitors.*

service {
	extend "../../../services/endian_simple"
//	elastic false
//	numInstances 1
//	minAllowedInstances	1
//	maxAllowedInstances	1
	
	lifecycle {}
	network {
		//template "APPLICATION_NET"
	}
	

}
