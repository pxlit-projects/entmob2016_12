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
using System.Windows.Input;

namespace ProjectEnt_SensorTag.ViewModel
{
    public class SensorTagViewModel : ViewModelBase
    {
        private ObservableCollection<IDevice> deviceList;
        public ObservableCollection<IDevice> DeviceList
        {
            get { return deviceList; }
            set { deviceList = value; }
        }
        public SensorTagViewModel()
        {
            deviceList = new ObservableCollection<IDevice>();
            refreshList = new RelayCommand(() => GetDeviceList());
        }
        public async void GetDeviceList()
        {
            if(deviceList.Count > 0 ) DeviceList = new ObservableCollection<IDevice>();
            var device = await DeviceFactory.FindDevice();
            deviceList.Add(device);
        }

        private ICommand refreshList;

        public ICommand RefreshList
        {
            get { return refreshList; }
            set { refreshList = value; }
        }
    }
}
