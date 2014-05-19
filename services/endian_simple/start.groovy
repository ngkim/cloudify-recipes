import org.cloudifysource.utilitydomain.context.ServiceContextFactory
import java.util.concurrent.TimeUnit

new AntBuilder().sequential {

//File EndianUTM = new File("endian_simple-service.properties")
File EndianUTM = new File("EndianUTM.config")

if(EndianUTM.exists()){
        File settings = new File("/var/efw/ethernet/settings")
		if(!settings.exists()) settings.createNewFile()
        if(settings.exists()){
                EndianUTM.eachLine
                {
                        line_endian -> def endian = line_endian.split('=')
                        settings.eachLine
                        {
                                line_settings ->
                                if(line_endian.contains('GREEN'))
                                {
                                                def ft_g = settings.text
                                                count = 0
                                                if(line_settings.contains(endian[0]))
                                                {
                                                        if(line_settings[line_settings.size()-1]=='=')
                                                        {
                                                                def ft_temp = line_settings+endian[1]
                                                                ft_g = ft_g.replace(line_settings, ft_temp)
                                                                settings.write(ft_g)
                                                                count = count + 1
                                                        }
                                                        else
                                                        {
                                                                def settings_green = line_settings.split('=')
                                                                ft_g = ft_g.replace(settings_green[1], endian[1])
                                                                settings.write(ft_g)
                                                                count = count + 1
                                                        }
                                                }


                                                        list = settings.readLines()

                                                        for (i=0;i<list.size();i++)
                                                        {
                                                                def a = line_endian.split('=')
                                                                def b = list[i].split('=')

                                                                if(a[0]==b[0])
                                                                {
                                                                        count = count +1
                                                                }
                                                        }
                                                        if (count==0)
                                                        {
                                                                def ft_temp2 = line_endian + "\n"
                                                                settings.append(ft_temp2)
                                                        }
                                }
  else if(line_endian.contains('ORANGE'))
                                {
                                                def ft_o = settings.text
                                                count = 0
                                                if(line_settings.contains(endian[0]))
                                                {
                                                        if(line_settings[line_settings.size()-1]=='=')
                                                        {
                                                                ft_temp = line_settings+endian[1]
                                                                ft_o = ft_o.replace(line_settings, ft_temp)
                                                                settings.write(ft_o)
                                                                count = count + 1
                                                        }
                                                        else
                                                        {
                                                                def settings_orange = line_settings.split('=')
                                                                ft_o = ft_o.replace(settings_orange[1], endian[1])
                                                                settings.write(ft_o)
                                                                count = count + 1
                                                        }
                                                }
                                                        list = settings.readLines()
                                                        for (i=0;i<list.size();i++)
                                                        {
                                                                a = line_endian.split('=')
                                                                b = list[i].split('=')

                                                                if(a[0]==b[0])
                                                                {
                                                                        count = count + 1
                                                                }
                                                        }
                                                        if (count==0)
                                                        {
                                                                ft_temp2 = line_endian + "\n"
                                                                settings.append(ft_temp2)
                                                        }

                                }
                        }
                }
        }
}

if(EndianUTM.exists()){
        File settings2 = new File("/var/efw/uplinks/main/settings")
		if(!settings2.exists()) settings2.createNewFile()
        if(settings2.exists()){
                EndianUTM.eachLine
                {
                        line_endian -> endian = line_endian.split('=')
                        settings2.eachLine
                        {
                                line_settings2 ->
                                if(line_endian.contains('RED'))
                                {
                                                def ft_r = settings2.text
                                                count = 0
                                                if(line_settings2.contains(endian[0]))
                                                {
                                                        if(line_settings2[line_settings2.size()-1]=='=')
                                                        {
                                                                ft_temp3 = line_settings2+endian[1]
                                                                ft_r = ft_r.replace(line_settings2, ft_temp3)
                                                                settings2.write(ft_r)
                                                                count = count + 1
                                                        }
                                                        else
                                                        {
                                                                def settings_red = line_settings2.split('=')
                                                                ft_r = ft_r.replace(settings_red[1], endian[1])
                                                                settings2.write(ft_r)
                                                                count = count + 1
                                                        }
                                                }
                                                        list2 = settings2.readLines()
                                                        for(i=0;i<list2.size();i++)
                                                        {
                                                                c = line_endian.split('=')
                                                                d = list2[i].split('=')

                                                                if(c[0]==d[0])
                                                                {
                                                                        count = count + 1
                                                                }
                                                        }
                                                        if (count==0)
                                                        {
                                                                ft_temp4 = line_endian + "\n"
                                                                settings2.append(ft_temp4)
                                                        }
                                }

                                else
                                {
                                }

                        }
                }
        }
}

if(EndianUTM.exists()){
        File settings3 = new File("/var/efw/host/settings")
		if(!settings3.exists()) settings3.createNewFile()
        if(settings3.exists()){
                EndianUTM.eachLine
                {
                        line_endian -> endian = line_endian.split('=')
                        settings3.eachLine
                        {
                                line_settings3 ->
                                if(line_endian.contains('DOMAINNAME'))
                                {
                                        def ft_d = settings3.text
                                        count = 0
                                        if(line_settings3.contains(endian[0]))
                                        {
                                                if(line_settings3[line_settings3.size()-1]=='=')
                                                {
                                                        ft_temp5 = line_settings3+endian[1]
                                                        ft_d = ft_d.replace(line_settings3, ft_temp5)
                                                        settings3.write(ft_d)
                                                        count = count + 1
                                                }
                                                else
                                                {
                                                        def settings_domain = line_settings3.split('=')
                                                        ft_d = ft_d.replace(settings_domain[1], endian[1])
                                                        settings3.write(ft_d)
                                                        count = count + 1
                                                }
                                        }
                                                list3 = settings3.readLines()
                                                for(i=0;i<list3.size();i++)
                                                {
                                                        e = line_endian.split('=')
                                                        g = list3[i].split('=')

                                                        if(e[0]==g[0])
                                                        {
                                                                count = count + 1
                                                        }
                                                }
                                                if (count==0)
                                                {
                                                        ft_temp6 = line_endian + "\n"
                                                        settings3.append(ft_temp6)
                                                }
                                }

 else if(line_endian.contains('HOSTNAME'))
                                {
                                        def ft_h = settings3.text
                                        count = 0
                                        if(line_settings3.contains(endian[0]))
                                        {
                                                if(line_settings3[line_settings3.size()-1]=='=')
                                                {
                                                        ft_temp = line_settings3 + endian[1]
                                                        ft_h = ft_h.replace(line_settings3, ft_temp)
                                                        settings3.write(ft_h)
                                                        count = count + 1
                                                }
                                                else
                                                {
                                                        def settings_host = line_settings3.split('=')
                                                        ft_h = ft_h.replace(settings_host[1], endian[1])
                                                        settings3.write(ft_h)
                                                        count = count + 1
                                                }
                                        }
                                                list3 = settings3.readLines()
                                                for(i=0;i<list3.size();i++)
                                                {
                                                        e = line_endian.split('=')
                                                        g = list3[i].split('=')

                                                        if(e[0]==g[0])
                                                        {
                                                                count = count + 1
                                                        }
                                                }
                                                if (count==0)
                                                {
                                                        ft_temp2 = line_endian + "\n"
                                                        settings3.append(ft_temp2)
                                                }
                                }


                        }
                }

        }

}


//"/sbin/reboot".execute()
}
