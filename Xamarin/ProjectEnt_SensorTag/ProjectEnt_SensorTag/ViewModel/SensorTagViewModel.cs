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

        private ICommand selectSensorTag;
        public ICommand SelectSensorTag
        {
            get { return selectSensorTag; }
            set { selectSensorTag = value; }
        }

        public SensorTagViewModel(INavigationService nav)
        {
            this.nav = nav;
            deviceList = new ObservableCollection<IDevice>();
            selectSensorTag = new RelayCommand(() => nav.NavigateTo("SensorTagDetail"));
            refreshList = new RelayCommand(() => GetDeviceList());
        }
        public async void GetDeviceList()
        {
            if (deviceList.Count > 0) DeviceList = new ObservableCollection<IDevice>();

            try
            {
                deviceList = await DeviceFactory.FindDevice();
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
