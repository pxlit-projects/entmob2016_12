using ProjectEnt_SensorTag.SensorTagLib.Exceptions;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Devices
{
    public class DeviceSetup : DeviceEssentials
    {
        protected static TaskCompletionSource<IDevice> tcs = new TaskCompletionSource<IDevice>();
        protected static Dictionary<string, IService> services = new Dictionary<string, IService>();

        private static Action<bool> isScanning;
        public static Task<IDevice> FindDevice(Action<bool> scanning)
        {
            isScanning = scanning;

            if (localAdapter.IsScanning)
            {
                localAdapter.StopScanningForDevices();
            }

            localAdapter.DeviceDiscovered += (sender, e) =>
            {
                if (e.Device?.Name != null)
                {
                    if (e.Device.Name.Contains("SensorTag") == true && e.Device.NativeDevice != null)
                    {
                        Debug.WriteLine("Device Found With Name " + e.Device.Name);
                        tcs.TrySetResult(e.Device);
                    }
                    else
                    {
                        //tcs.SetException(new UnknownDeviceException("Could not connect to unknown device"));
                    }
                }
            };

            localAdapter.ScanTimeoutElapsed += (sender,e) =>
            {
                localAdapter.StopScanningForDevices();
                isScanning(true);
            };

            localAdapter.StartScanningForDevices(Guid.Empty);
            isScanning(false);

            return tcs.Task;
        }
        public static void StopScanning()
        {
            if (localAdapter.IsScanning)
            { 
                localAdapter.StopScanningForDevices();
                isScanning(true);
            }
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
                            if(!services.ContainsKey("Temperature"))
                            services.Add("Temperature", service);
                        }
                        if (service.ID == humidityServiceUuid)
                        {
                            if(!services.ContainsKey("Humidity"))
                            services.Add("Humidity", service);
                        }
                    }
                };

                device.DiscoverServices();
            };

            localAdapter.ConnectToDevice(device);
        }
    }
}