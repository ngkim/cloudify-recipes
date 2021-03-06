#!/bin/sh

LOCATORS=$1
GROUP=$2
GSHOME=$3

#sudo ulimit -n 32000

sed -i "1i export JAVA_HOME=$GSHOME/../java" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh" 
sed -i "1i export NIC_ADDR=\"#eth0:ip#\"" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh"
sed -i "1i export GSA_JAVA_OPTIONS=\"-Xmx512m -Xms512m -Dcom.gs.agent.auto-shutdown-enabled=true -Dcom.gs.multicast.enabled=false\"" $GSHOME/bin/gs-agent.sh || error_exit $? "Failed updating gs-agent.sh"
sed -i "1i export GSC_JAVA_OPTIONS=-Dcom.gs.multicast.enabled=false" $GSHOME/bin/gsc.sh || error_exit $? "Failed updating gsc.sh"
sed -i "1i export GSM_JAVA_OPTIONS=\"-Xmx512m -Xms512m -Dcom.sun.jini.reggie.initialUnicastDiscoveryPort=4242 -Dgsm.excludeGscOnFailedInstance.disabled=true -Dcom.gs.multicast.enabled=false\"" $GSHOME/bin/gsm.sh || error_exit $? "Failed updating gsm.sh"
sed -i "1i export LUS_JAVA_OPTIONS=\"-Dcom.gs.multicast.enabled=false -Dcom.sun.jini.reggie.initialUnicastDiscoveryPort=4242 -Dcom.gs.multicast.discoveryPort=4242\"" $GSHOME/bin/startJiniLUS.sh || error_exit $? "Failed updating startJiniLUS.sh"
sed -i "1i export WEBUI_JAVA_OPTIONS=\"-Xmx2g -Xms1g -Dcom.gigaspaces.webui.common.level=FINE -Dcom.gigaspaces.webui.pu.events.level=FINE -Dcom.gigaspaces.webui.lifecycle.level=FINER -Dcom.sun.jini.reggie.initialUnicastDiscoveryPort=4242 -Dcom.gs.multicast.enabled=false -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -Xmn100m -XX:ParallelGCThreads=4 -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=/tmp/oom.hprof -Dcom.gs.transport_protocol.lrmi.connect_timeout=30000\"" $GSHOME/tools/gs-webui/gs-webui.sh || error_exit $? "Failed updating gs-webui.sh"
sed -i "1i export EXT_JAVA_OPTIONS=\"-Xmx2g -Xms1g -Dcom.gigaspaces.webui.lifecycle.level=FINER -Dcom.sun.jini.reggie.initialUnicastDiscoveryPort=4242 -Dcom.gs.multicast.discoveryPort=4242 -Dcom.gs.multicast.enabled=false  -Dcom.gs.jini_lus.groups=$GROUP -Dcom.gs.jini_lus.locators=$LOCATORS\"" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh"
sed -i "1i export LOOKUPGROUPS=$GROUP" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh"
sed -i "1i export LOOKUP_GROUPS_PROP=-Dcom.gs.jini_lus.groups=$GROUP" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh"
sed -i "1i export LOOKUPLOCATORS=$LOCATORS" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh"
sed -i "1i export LOOKUP_LOCATORS_PROP=-Dcom.gs.jini_lus.locators=$LOCATORS" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh"
sed -i "1i export PATH=$JAVA_HOME/bin:$PATH" $GSHOME/bin/setenv.sh || error_exit $? "Failed updating setenv.sh"

sed s/"\${JAVA_OPTIONS} -DagentId=\${AGENT_ID}"/"\${JAVA_OPTIONS} -DagentId=\${AGENT_ID} -Xloggc:\/tmp\/\$\$ -XX:OnOutOfMemoryError=\"jstack -l -F  %p \> \/tmp\/\%p.thread.dump\.\`date +\%y_\%m_\%d.\%H_\%M_\%S\`\.txt\""/g gs.sh > gs.sh.backup2
cp gs.sh gs.sh.backup
cp gs.sh.backup2 gs.sh
rm gs.sh.backup2
chmod 755 gs.sh

nohup sh $GSHOME/tools/gs-webui/gs-webui.sh





