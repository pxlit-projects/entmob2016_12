using ProjectEnt_SensorTag.SensorTagLib.Exceptions;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib
{
    public class DeviceFactory : DeviceSetup
    {
        static TaskCompletionSource<IDevice> tcs = new TaskCompletionSource<IDevice>();
        static ObservableCollection<IDevice> deviceList = new ObservableCollection<IDevice>();
       
        public static Task<IDevice> FindDevice()
        {

            localAdapter.DeviceDiscovered += DeviceDiscovered;
            localAdapter.ScanTimeoutElapsed += ScanTimeoutElapsed;

            if (localAdapter.IsScanning)
            {
                localAdapter.StopScanningForDevices();
                deviceList = new ObservableCollection<IDevice>();
            }

            localAdapter.StartScanningForDevices(Guid.Empty);

            return tcs.Task;
        }

        public static void DeviceDiscovered(object sender, DeviceDiscoveredEventArgs e)
        {
            if (e.Device?.Name.Contains("SensorTag") == true)
            {
                Debug.WriteLine("Device Found With Name " + e.Device.Name);
                deviceList.Add(e.Device);
                tcs.TrySetResult(e.Device);
            }
            else
            {
                tcs.SetException(new UnknownDeviceException("Could not connect to unknown device"));
            }
        }

        public static void ScanTimeoutElapsed(object sender, EventArgs e)
        {
            localAdapter.StopScanningForDevices();

            if (deviceList.Count == 0)
            {
                tcs.SetException(new NoDeviceFoundException("No Device was found"));
            }
        }
    }
}
