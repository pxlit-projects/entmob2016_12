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
    public static class DeviceFactory
    {
        static TaskCompletionSource<IDevice> tcs = new TaskCompletionSource<IDevice>();
        static ObservableCollection<IDevice> device = new ObservableCollection<IDevice>();
        static IAdapter localadapter;
        public static Task<IDevice> FindDevice(IAdapter adapter)
        {
            localadapter = adapter;
            adapter.DeviceDiscovered += DeviceDiscovered;
            adapter.ScanTimeoutElapsed += ScanTimeoutElapsed;

            if (adapter.IsScanning)
            {
                adapter.StopScanningForDevices();
                device = new ObservableCollection<IDevice>();
                localadapter = null;
            }

            adapter.StartScanningForDevices(Guid.Empty);

            return tcs.Task;
        }

        public static void DeviceDiscovered(object sender, DeviceDiscoveredEventArgs e)
        {
            if (e.Device?.Name.Contains("SensorTag") == true)
            {
                Debug.WriteLine("Device Found With Name " + e.Device.Name);
                device.Add(e.Device);
                tcs.TrySetResult(e.Device);
            }
            else
            {
                tcs.SetException(new UnknownDeviceException("Could not connect to unknown device"));
            }
        }

        public static void ScanTimeoutElapsed(object sender, EventArgs e)
        {
            localadapter.StopScanningForDevices();
            localadapter = null;
            if (device.Count == 0)
            {
                tcs.SetException(new NoDeviceFoundException("No Device was found"));
            }
        }
    }
}
