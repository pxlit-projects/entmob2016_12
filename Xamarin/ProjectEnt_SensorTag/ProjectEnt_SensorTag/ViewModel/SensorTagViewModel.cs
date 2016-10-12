using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Views;
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

        private INavigationService nav;
        public INavigationService Nav
        {
            get { return nav; }
            set { nav = value; }
        }

        private IDevice device;
        public IDevice Device
        {
            get
            {
                return device;
            }
            set
            {
                if (device != value)
                {
                    device = value;
                    Set(() => Device, ref device, value);
                    nav.NavigateTo("SensorTagDetail");
                }
            }
        }

        private ICommand selectedDevice;

        public ICommand SelectedDevice
        {
            get { return selectedDevice; }
            set { selectedDevice = value; }
        }

        public SensorTagViewModel(INavigationService nav)
        {
            this.nav = nav;
            deviceList = new ObservableCollection<IDevice>();
            refreshList = new RelayCommand(() => GetDeviceList());
        }
        public async void GetDeviceList()
        {
            if (deviceList.Count > 0) DeviceList = new ObservableCollection<IDevice>();

            try
            {
                var device = await DeviceFactory.FindDevice();
                deviceList.Add(device);
            }
            catch
            {

            }
        }    
        private ICommand refreshList;
        public ICommand RefreshList
        {
            get { return refreshList; }
            set { refreshList = value; }
        }
    }
}
