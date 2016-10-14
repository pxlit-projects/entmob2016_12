using ProjectEnt_SensorTag.SensorTagLib.Devices;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Services
{
    public class HumidityService : DeviceSetup
    {
        protected void DiscoverServicesHumdidity()
        {
            IService service = services["Humidity"];
            int servicesDiscovered = 0;

            service.CharacteristicsDiscovered += (s, e) =>
            {
                foreach (var characteristic in service.Characteristics)
                {
                    if (characteristic.ID == humidityCharacteristicUuid)
                    {
                        Debug.WriteLine("Characteristic discovered: " + characteristic.Name);
                        temperatureChar = characteristic;
                        servicesDiscovered++;
                    }
                    if (characteristic.ID == humidityCharacteristicConfigUuid)
                    {
                        Debug.WriteLine("Characteristic discovered: " + characteristic.Name);
                        temperatureCharConfig = characteristic;
                        servicesDiscovered++;
                    }
                    if (characteristic.ID == humidityCharacteristicPeriodUuid)
                    {
                        Debug.WriteLine("Characteristic discovered: " + characteristic.Name);
                        temperatureCharPeriod = characteristic;
                        servicesDiscovered++;
                    }
                }
            };

            service.DiscoverCharacteristics();
        }
    }
}