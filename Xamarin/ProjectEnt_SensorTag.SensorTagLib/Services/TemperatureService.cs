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
        public static void DiscoverServicesTemperature()
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
        public static void ConnectToDevice()
        {
            localAdapter.DeviceConnected += (sender, e) =>
            {
                device = e.Device;

                device.ServicesDiscovered += (object se, EventArgs ea) =>
                {
                    foreach (var service in device.Services)
                    {
                        if (service.ID == temperatureServiceUuid)
                        {
                            services.Add("Temperature", service);
                        }
                    }
                };

                device.DiscoverServices();
            };

            localAdapter.ConnectToDevice(device);
        }

        public void StartSensing()
        {

            if (temperatureChar != null)
            {
                //if (temperatureCharConfig.CanUpdate)
                //{
                double ambient, infrared;
                CalculateTemperature(out ambient, out infrared);
                //}
            }
        }
        private static void CalculateTemperature(out double ambient, out double ir)
        {
            var data = temperatureChar.Value;

            short objTemp = (short)((short)data[0] + (short)(data[1] << 8));
            short dieTemp = (short)((short)data[2] + (short)(data[3] << 8));

            const double SCALE_LSB = 0.03125;
            int it;

            it = (int)((objTemp) >> 2);
            ir = (double)it * SCALE_LSB;

            it = (int)((dieTemp) >> 2);
            ambient = (double)it * SCALE_LSB;

            Debug.WriteLine("ambient: " + ambient + "\nIR: " + ir + " C");
        }
    }
}
