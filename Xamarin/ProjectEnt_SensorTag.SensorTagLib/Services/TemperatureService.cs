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
    public class TemperatureService : DeviceSetup
    {
        protected static bool isCompleted = false;
        protected void DiscoverServicesTemperature()
        {
            IService service = services["Temperature"];
            int servicesDiscovered = 0;

            service.CharacteristicsDiscovered += (s, e) =>
            {
                foreach (var characteristic in service.Characteristics)
                {
                    if (characteristic.ID == temperatureCharacteristicUuid)
                    {
                        Debug.WriteLine("Characteristic discovered: " + characteristic.Name);
                        temperatureChar = characteristic;
                        servicesDiscovered++;
                    }
                    if (characteristic.ID == temperatureCharacteristicConfigUuid)
                    {
                        Debug.WriteLine("Characteristic discovered: " + characteristic.Name);
                        temperatureCharConfig = characteristic;
                        servicesDiscovered++;
                    }
                    if (characteristic.ID == temperatureCharacteristicPeriodUuid)
                    {
                        Debug.WriteLine("Characteristic discovered: " + characteristic.Name);
                        temperatureCharPeriod = characteristic;
                        servicesDiscovered++;
                    }
                }

                isCompleted = servicesDiscovered == 3 ? true : false;
            };

            service.DiscoverCharacteristics();

            temperatureCharConfig.Write(new byte[] { 0x01 }); // Turn ON
            temperatureChar.StartUpdates();
        }
    }
}