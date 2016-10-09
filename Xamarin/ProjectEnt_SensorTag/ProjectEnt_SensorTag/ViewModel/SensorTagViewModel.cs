using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using ProjectEnt_SensorTag.SensorTagLib;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.ViewModel
{
    public class SensorTagViewModel : ViewModelBase
    {
        private ObservableCollection<IDevice> deviceList;
        public ObservableCollection<IDevice> DeviceList
        {
            get { return deviceList; }
            set
            {
                deviceList = value;
            }
        }
        public SensorTagViewModel()
        {
            deviceList = new ObservableCollection<IDevice>();
            GetDeviceList();
        }
        public async void GetDeviceList()
        {
            var device = await DeviceFactory.FindDevice(adapter);
            Debug.WriteLine("Device found! " + device.Name);
            deviceList.Add(device);
        }
        public static IAdapter adapter { get; set; }
    }
}
