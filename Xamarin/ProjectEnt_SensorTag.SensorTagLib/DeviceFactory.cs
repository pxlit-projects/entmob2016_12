﻿using ProjectEnt_SensorTag.SensorTagLib.Exceptions;
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
       public static Task<IDevice> FindDevice()
        {
            if (localAdapter.IsScanning)
            {
                localAdapter.StopScanningForDevices();

                localAdapter.DeviceDiscovered -= DeviceDiscovered;
                localAdapter.ScanTimeoutElapsed -= ScanTimeoutElapsed;
            }

            localAdapter.DeviceDiscovered += DeviceDiscovered;
            localAdapter.ScanTimeoutElapsed += ScanTimeoutElapsed;

            localAdapter.StartScanningForDevices(Guid.Empty);

            return tcs.Task;
        }

        public static void DeviceDiscovered(object sender, DeviceDiscoveredEventArgs e)
        {
            if (e.Device?.Name.Contains("SensorTag") == true)
            {
                Debug.WriteLine("Device Found With Name " + e.Device.Name);
                tcs.TrySetResult(e.Device);
                localAdapter.DeviceDiscovered -= DeviceDiscovered;
            }
            else
            {
                tcs.SetException(new UnknownDeviceException("Could not connect to unknown device"));
            }
        }

        public static void ScanTimeoutElapsed(object sender, EventArgs e)
        {
            localAdapter.StopScanningForDevices();
        }
    }
}
