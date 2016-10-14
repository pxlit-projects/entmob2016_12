using ProjectEnt_SensorTag.SensorTagLib.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Sensors
{
    public class HumiditySensor : HumidityService
    {
        public HumiditySensor()
        {
            DiscoverServicesHumdidity();
        }
    }
}
