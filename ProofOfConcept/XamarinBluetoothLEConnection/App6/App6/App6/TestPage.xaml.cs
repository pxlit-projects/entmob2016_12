using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace App6
{
    public partial class TestPage : ContentPage
    {
        private IAdapter adapter;

        public TestPage(IAdapter adapter)
        {
            InitializeComponent();

            this.adapter = adapter;
        }

        public void ScanDevices(object senderr, EventArgs es)
        {
            Debug.WriteLine("Starting to Scan Devices");

            adapter.DeviceDiscovered += (sender, e) =>
            {
                if (e.Device.Name != null)
                {
                    Debug.WriteLine("Device found with name" + e.Device);
                }
            };

            adapter.ScanTimeoutElapsed += (sender, e) =>
            {
                adapter.StopScanningForDevices();

            };

            if (adapter.IsScanning) // stop with previous scans
            {
                Debug.WriteLine("Finishing scanning");
                adapter.StopScanningForDevices();
            }

            adapter.StartScanningForDevices(Guid.Empty);
        }
    }
}
